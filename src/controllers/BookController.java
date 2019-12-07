package controllers;

import dao.BookDAO;
import dao.CategoryDAO;
import daoImpl.BookDaoImpl;
import daoImpl.CategoryDaoImpl;
import models.Book;
import models.Category;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.IOFile;
import utils.Process;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "index.html")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BookController extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "images";
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bd = new BookDaoImpl();
        ArrayList<Book> list = bd.findAll();
        String uri = request.getRequestURI();
        ArrayList<String> listForm = new ArrayList<String>();
        String fileName = "";
        String message = "";
        String picture = "";
        int id;

        if(uri.contains("QLAddBook")||uri.contains("QLEditBook")) {

            if (!ServletFileUpload.isMultipartContent(request)) {
                // if not, we stop here
                PrintWriter writer = response.getWriter();
                writer.println("Error: Form must has enctype=multipart/form-data.");
                writer.flush();
                return;
            }

            // configures upload settings
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // sets memory threshold - beyond which files are stored in disk
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            // sets temporary location to store files
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);

            // sets maximum size of upload file
            upload.setFileSizeMax(MAX_FILE_SIZE);

            // sets maximum size of request (include file + form data)
            upload.setSizeMax(MAX_REQUEST_SIZE);

            String uploadPath = getServletContext().getInitParameter("file-upload") + File.separator + UPLOAD_DIRECTORY;

            uploadPath = uploadPath.replace('\\', '/');

            System.out.println(uploadPath);
            // creates the directory if it does not exist
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                // parses the request's content to extract file data
                @SuppressWarnings("unchecked")
                List<FileItem> formItems = upload.parseRequest(request);

                if (formItems != null && formItems.size() > 0) {
                    // iterates over form's fields
                    for (FileItem item : formItems) {
                        // processes only fields that are not form fields
                        if (!item.isFormField()) {

                            fileName = new File(item.getName()).getName();
                            picture = fileName;
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            // saves the file on disks
                            item.write(storeFile);
                            System.out.println("upload success...");
                            request.setAttribute("msg","Upload has been done successfully!");
                        } else {
                            listForm.add(item.getString());
                        }
                    }
                }
            } catch (Exception ex) {
                System.out.println("upload fail...");
                request.setAttribute("msg",
                        "There was an error: " + ex.getMessage());
            }

            for (int i = 0; i < listForm.size(); i++) {
                System.out.print(listForm.get(i) + " - "+i);
            }

            if(listForm.get(0).length()>0) {
                id = Integer.parseInt(listForm.get(0));
            }
            else {
                id = 0;
            }
            String code = listForm.get(1);
            String name = listForm.get(2);
            String author = listForm.get(3);
            String charge = listForm.get(4);
            int category_id;
            if(listForm.get(5).length()>0) {
                category_id = Integer.parseInt(listForm.get(5));
            } else {
                category_id = 0;
            }
            String description = listForm.get(6);
            String publisher = listForm.get(7);

            Double price;
            if(charge.matches("-?\\d+(\\.\\d+)?")) {
                price = Double.parseDouble(charge);
            }
            else  {
                price = Double.parseDouble("0");
            }

            Book bo;
            CategoryDAO ca = new CategoryDaoImpl();
            if(uri.contains("QLEditBook")) {
                bo = new Book(id,code,name,author,price,category_id,description,publisher,picture);
            }
            else bo = new Book(code,name,author,price,category_id,description,publisher,picture);

            if(code.length()==0 || name.length()==0 || author.length()==0 || charge.length()==0 || price==0 || category_id==0 || description.length()==0||publisher.length()==0) {
                message = "* marks required fields";
                ArrayList<Category> listCate = ca.findAll();
                request.setAttribute("listCate",listCate);
                request.setAttribute("message",message);
                request.setAttribute("bo",bo);
                String url;
                if(uri.contains("QLEditBook")) url = "/views/Admin/Book/update.jsp";
                else url = "/views/Admin/Book/add.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            }
            else  {
                if(uri.contains("QLEditBook")) {
                    bd.Update(bo);
                }
                else {
                    bd.Insert(bo);
                }
            }
        } else if (uri.contains("QLDeleteBook")) {
            id = Integer.parseInt(request.getParameter("id"));
            bd.Delete(id);
        }

        response.sendRedirect(request.getContextPath()+"/QLBook");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies=request.getCookies();
        int checkRole = 0;
        String username = "";

        for (int i=0;i<cookies.length;i++) {
            Cookie cookie = cookies[i];
            if(cookie.getName().equals("username") && cookie.getValue()!="") {
                checkRole = 1;
                username = cookie.getValue();
            }
            if(cookie.getName().equals("role") && cookie.getValue().equals("admin")) {
                checkRole = 2;
            }
        }

        if(checkRole==2) {
            BookDAO bd = new BookDaoImpl();
            CategoryDAO ca = new CategoryDaoImpl();

            String uri = request.getRequestURI();

            if(uri.contains("QLBook")) {
                String url = "/views/Admin/Book/index.jsp";
                ArrayList<Book> list = bd.findAll();
                ArrayList<Category> listCate = ca.findAll();
                request.setAttribute("list",list);
                request.setAttribute("listCate",listCate);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            }
            else  if(uri.contains("QLAddBook")) {
                String url = "/views/Admin/Book/add.jsp";
                ArrayList<Category> listCate = ca.findAll();
                request.setAttribute("listCate",listCate);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            } else  if(uri.contains("QLEditBook")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String url = "/views/Admin/Book/update.jsp";
                Book bo = bd.findById(id);
                request.setAttribute("bo",bo);
                ArrayList<Category> listCate = ca.findAll();
                request.setAttribute("listCate",listCate);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            } else  if(uri.contains("QLDeleteBook")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String url = "/views/Admin/Book/delete.jsp";
                Book bo = bd.findById(id);
                request.setAttribute("bo",bo);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            }
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
            rd.forward(request,response);
        }

    }

}