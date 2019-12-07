package dao;

import models.Category;

import java.util.ArrayList;

public interface CategoryDAO {
    public ArrayList<Category> findAll();
    public void Insert(Category ca);
    public void Update(Category ca);
    public void Delete(int id);
    public Category findById(int id);
    public String getNameCategory(int id);
}
