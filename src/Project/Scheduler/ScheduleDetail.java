package Project.Scheduler;

import Project.Users.*;

public class ScheduleDetail {
    private Schedule schedule;
    private Doctor doctor;
    private String startTime;
    private String endTime;
    private String date;

    public ScheduleDetail(Schedule schedule, Doctor doctor, String startTime, String endTime, String date) {
        this.schedule = schedule;
        this.doctor = doctor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDate() {
        return date;
    }
}
