package models;

public class Item {
    private int id;
    private Book book;
    private Order order;
    private int amount;
    private int book_id;
    private int order_id;
    private String nameBook;

    public Item(int book_id,int order_id,int amount) {
        this.book_id = book_id;
        this.order_id = order_id;
        this.amount = amount;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Item(int id, Book book, Order order, int amount) {
        this.id = id;
        this.book = book;
        this.order = order;
        this.amount = amount;
    }

    public Item(Book book, Order order,int amount) {
        this.book = book;
        this.order = order;
        this.amount = amount;
    }

    public  Item() {

    }

//    public  Item() {
//        this.book = null;
//        this.order = null;
//        this.amount = 0;
//    }

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
