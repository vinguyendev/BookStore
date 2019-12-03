package models;

public class Book {
    private int id;
    private String code;
    private String name;
    private String author;
    private Double price;

    public Book(int id,String code, String name, String author, Double price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book() {
        this.code = "";
        this.name = "";
        this.author = "";
        this.price = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}