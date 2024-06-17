package Project.Scheduler;

import Project.Users.*;

/**
 * <h3>ScheduleDetail class, template for a compilation of related schedule information which includes:</h3>
 * Schedule (Object), Doctor (Object), StartTime (String), EndTime (String), Date (String)
 *
 */

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
