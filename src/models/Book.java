package models;

import daoImpl.CategoryDaoImpl;

public class Book {
    private int id;
    private String code;
    private String name;
    private String author;
    private Double price;
    private int category_id;
    private String description;
    private String publisher;
    private String picture;

    public Book() {
        this.code = "";
        this.name = "";
        this.author = "";
        this.price = 0.0;
        this.category_id = 0;
        this.description = "";
        this.publisher = "";
        this.picture = "";
    }


    public Book(int id, String code, String name, String author, Double price, int category_id, String description, String publisher, String picture) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.author = author;
        this.price = price;
        this.category_id = category_id;
        this.description = description;
        this.publisher = publisher;
        this.picture = picture;
    }

    public Book(String code, String name, String author, Double price, int category_id, String description, String publisher, String picture) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.price = price;
        this.category_id = category_id;
        this.description = description;
        this.publisher = publisher;
        this.picture = picture;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNameCategory() {
        String nameCategory = "";
        nameCategory = new CategoryDaoImpl().getNameCategory(this.category_id);
        return  nameCategory;
    }
}