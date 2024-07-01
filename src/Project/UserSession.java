package Project;

import Project.Users.*;

public class UserSession {
    private static UserSession instance;
    private User currentUser;
    //private constructor
    private static void UserSession(User user) {}

    //get instance of UserSession within the class and prevents multiple instances
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }

        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void clearSession() {
        currentUser = null;
    }
}
