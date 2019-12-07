package models;

public class Admin {
    private int id;
    private User user;
    private String fullName;

    public Admin(int id, User user, String fullName) {
        this.id = id;
        this.user = user;
        this.fullName = fullName;
    }

    public Admin(User user, String fullName) {
        this.user = user;
        this.fullName = fullName;
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
}
