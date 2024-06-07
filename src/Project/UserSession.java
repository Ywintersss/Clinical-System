package Project;

import Project.Users.*;

public class UserSession {
    private static UserSession instance;
    private User currentUser;
    private static void UserSession(User user) {}

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
