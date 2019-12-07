package models;

public class Order {
    private int id;
    private Customer customer;
    private String date;
    private Double total;

    public Order(int id, Customer customer, String date, Double total) {
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.total = total;
    }

    public Order(Customer customer, String date, Double total) {
        this.customer = customer;
        this.date = date;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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
}
