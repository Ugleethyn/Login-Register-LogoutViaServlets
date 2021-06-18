package models;

public class User {

    private int _id;
    private String firstName;
    private String lastName;
    private String password;
    private String username;

    public User() {
    }

    public User(int _id, String _firstName, String _lastName, String _password, String _username) {
        this._id = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.password = _password;
        this.username = _username;
    }

    public User(String _firstName, String _lastName, String _password, String _username) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.password = _password;
        this.username = _username;
    }

    public User(String _firstName, String _lastName, String _username) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.username = _username;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String _firstName) {
        this.firstName = _firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String _lastName) {
        this.lastName = _lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String _username) {
        this.username = _username;
    }

}
