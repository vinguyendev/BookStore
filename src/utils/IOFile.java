package utils;

import models.Book;

import java.io.*;
import java.util.ArrayList;

public class IOFile {

    public static void add(ArrayList<Book> list, String filepath) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(filepath));
        for (int i = 0; i < list.size(); i++) {
            out.println(list.get(i).getId() + ","
                    + list.get(i).getCode() + ","
                    + list.get(i).getName() + ","
                    + list.get(i).getAuthor() + ","
                    + list.get(i).getPrice()
            );
        }
        out.close();
    }

    public static Book convert(String s){
        Book bo = new Book();
        s=s.trim();
        String ss[]=s.split(",");
        bo.setId(Integer.parseInt(ss[0]));
        bo.setCode(ss[1]);
        bo.setName(ss[2]);
        bo.setAuthor(ss[3]);
        bo.setPrice(Double.parseDouble(ss[4]));

        return bo;
    }

    public static ArrayList<Book> read( String filepath) throws FileNotFoundException, IOException{
        ArrayList<Book> list=new ArrayList<>();
        BufferedReader br=new BufferedReader(new FileReader(filepath));
        String s;
        while((s=br.readLine())!=null){
            Book bo=convert(s);
            System.out.println(bo.toString());
            list.add(bo);
        }
        br.close();
        return list;
    }

}
