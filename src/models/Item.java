package models;

public class Item {
    private int id;
    private Book book;
    private Order order;

    public Item(int id, Book book, Order order) {
        this.id = id;
        this.book = book;
        this.order = order;
    }

    public Item(Book book, Order order) {
        this.book = book;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
