package models;

public class Customer {
    private int id;
    private User user;
    private String fullName;
    private String mobile;
    private String address;

    public Customer(int id, User user, String fullName, String mobile, String address) {
        this.id = id;
        this.user = user;
        this.fullName = fullName;
        this.mobile = mobile;
        this.address = address;
    }

    public Customer(User user, String fullName, String mobile, String address) {
        this.user = user;
        this.fullName = fullName;
        this.mobile = mobile;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
