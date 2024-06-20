package Project.Scheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

// Schedule class, schedule for each individual doctor
public class Schedule {
    private String scheduleID;
    private String doctorID;
    private String startTime;
    private String endTime;
    private String date;

    public Schedule(String scheduleID, String doctorID, String startTime, String endTime, String date) {
        this.scheduleID = scheduleID;
        this.doctorID = doctorID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public String getDoctorID() { return doctorID; }

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
