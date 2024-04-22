package Project.Users;

import Project.Scheduler.Schedule;

public class Doctor extends User {
    private String workName;
    private Schedule schedule;
    public Doctor(String username, String password, String workName) {
        super(username, password);
        this.workName = workName;
        // Initialize the doctor's schedule
        this.schedule = new Schedule();
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
