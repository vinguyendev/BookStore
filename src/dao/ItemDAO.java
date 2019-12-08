package dao;

import models.Item;

import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<Item> findByOrder(int order_id);
    public void Insert(Item it);
    public void Update(Item it);
    public void Delete(int id);
}
