package Project.Users;
import java.io.*;
public class User {
    private String username;
    private String password;

    public User(String userID, String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String genUID() {
        //txt file last ID +1
        return null;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
