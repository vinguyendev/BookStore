package dao;

import models.User;

import java.util.ArrayList;

public interface UserDAO {
    public ArrayList<User> findAll(int role);
    public void Insert(User us);
    public void Delete(int id);
    public User findById(int id);
    public User findUser(String username,String password);
    public String findNameUser(String username, String password);
    public User findByUserName(String username);
}
