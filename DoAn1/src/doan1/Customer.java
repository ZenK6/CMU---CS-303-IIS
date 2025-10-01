package doan1;

public class Customer {

    private int id;
    private String name;
    private String email;
    private String cccd;

    public Customer(int id, String name, String email, String cccd) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cccd = cccd;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCccd() {
        return cccd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }
}
