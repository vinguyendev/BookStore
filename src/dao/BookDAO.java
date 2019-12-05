package dao;

import models.Book;

import java.util.ArrayList;

public interface BookDAO {
    public ArrayList<Book> findAll();
    public void Insert(Book bo);
    public void Update(Book bo);
    public void Delete(int id);
    public Book findById(int id);
}
