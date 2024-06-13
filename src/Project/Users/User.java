package Project.Users;
public class User {
    private String ID;
    private String name;
    private String email;
    private String contact;
    private String username;
    private String password;
    private int Age;
    private Gender gender;
    private String image;

    public User(String ID, String username, String password, String name, String email, String contact, int age, Gender gender) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.Age = age;
        this.gender = gender;
    }

    public User(String ID,String username, String password) {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
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

    public void setContact(String contact) {
        this.contact = contact;
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

    @Override
    public String toString() {
        return this.name;
    }
}
