package utils;

import models.Book;

import java.util.ArrayList;

public class Process {

    public static ArrayList<Book> deleteById(ArrayList<Book> list, int id) {
        for(int i=0;i<list.size();i++) {
            if(id==list.get(i).getId()) {
                list.remove(i);
                break;
            }
        }
        return list;
    }
    public static Book findById(ArrayList<Book> list, int id) {
        for(int i=0;i<list.size();i++) {
            if(id==list.get(i).getId()) {
                return  list.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Book> UpdateBook(ArrayList<Book> list,Book bo,int id){
        for(int i=0;i<list.size();i++){
            if(id==list.get(i).getId()){
                list.set(i, bo);
                break;
            }
        }
        return list;
    }

    public static ArrayList<Book> AddBook(ArrayList<Book> list,Book bo){
        list.add(bo);
        return list;
    }

}
