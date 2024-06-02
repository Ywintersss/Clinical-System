package Project.Users;
public class User {
    private String name;
    private String email;
    private String phoneNo;
    private String username;
    private String password;
    private int Age;
    private Gender gender;
    private String image;

    public User(String username, String password, String name, String email, String phoneNo, int age, Gender gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.Age = age;
        this.gender = gender;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public int getAge() {
        return Age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
