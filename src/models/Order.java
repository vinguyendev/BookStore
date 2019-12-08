package models;

import java.util.ArrayList;

public class Order {
    private int id;
    private int customer_id;
    private User customer;
    private String date;
    private Double total;
    private int status;
    private ArrayList<Item> listItems;

    public Order() {
        this.status = 0;
    }

    public Order(int id, User customer, String date, Double total) {
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.total = total;
    }

    public  Order(int customer_id,String date,Double total,int status) {
        this.customer_id = customer_id;
        this.date = date;
        this.total = total;
        this.status = status;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Order(User customer, String date, Double total) {
        this.customer = customer;
        this.date = date;
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ArrayList<Item> getListItems() {
        return listItems;
    }

    public void setListItems(ArrayList<Item> listItems) {
        this.listItems = listItems;
    }
}
