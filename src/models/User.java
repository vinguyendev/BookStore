package models;

public class User {
    private int id;
    private String username;
    private String password;
    private String mobile;
    private String fullName;
    private String address;
    private int role;

    public User(int id, String username, String password, String mobile, String fullName, String address, int role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.fullName = fullName;
        this.address = address;
        this.role = role;
    }

    public User(String username, String password, String mobile, String fullName, String address, int role) {
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.fullName = fullName;
        this.address = address;
        this.role = role;
    }

    public User() {
        this.username = "";
        this.password = "";
        this.mobile = "";
        this.fullName = "";
        this.address = "";
        this.role = 1;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
