package entity;

public class User {
    private int id;
    private String user_name;
    private  String password;
    private String phone_number;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int id, String user_name, String password, String phone_number, String email) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
    }
    public User(){

    }
}
