package Problems.Food_Delivery_System.Core_Classes;

public class User {
    private int userId;
    private String name;
    private String address;

    public User(int userId, String name, String address) {
        this.userId = userId;
        this.name = name;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
