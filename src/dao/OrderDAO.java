package dao;

import models.Order;

import java.util.ArrayList;

public interface OrderDAO {
    public ArrayList<Order> findAll();
    public void Insert(Order or);
    public void Update(Order or);
    public void Delete(int id);
    public Order findById(int id);
    public int findOrderNew();
}
