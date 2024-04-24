package Project;

import Project.Controller.userDataManager;

public class ClinicalSystem {
    public <T> T login(String username, String password) {
        //validation
        userDataManager loginManager = new userDataManager();
        T user = loginManager.getUser(username, password);
        return user;
    }

    public void register(String username, String password) {
        //
        return;
    }
}
