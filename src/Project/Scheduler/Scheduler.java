package Project.Scheduler;

import Project.ClinicalSystem;
import Project.Users.Doctor;
import Project.Users.Patient;
import Project.Utilities.File;
import Project.Utilities.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


//Controller for schedules and appointments among patients and doctors
public class Scheduler {
    private static Scheduler instance;
    private Scheduler() {}
    public static Scheduler getInstance() {
        if(instance == null) {
            instance = new Scheduler();
        }
        return instance;
    }

    public ObservableList<Schedule> getAllSchedules() {
        try {
            ArrayList<String> scheduleData = File.readFile("\\schedules\\Schedules.txt");
            ArrayList<String[]> parseScheduleData = File.parseData(scheduleData);

            ObservableList<Schedule> FXScheduleData = FXCollections.observableArrayList();
            for (String[] data : parseScheduleData) {
                FXScheduleData.add(new Schedule(data[0], data[1], data[2], data[3], data[4]));
            }
            return FXScheduleData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Schedule> getAllDoctorSchedules(String doctorID, boolean getActiveSchedules) {
            try {
                ObservableList<Schedule> Schedules = getAllSchedules();
                Schedules.removeIf(schedule -> !schedule.getDoctorID().equals(doctorID));

                if (getActiveSchedules) {
                    Schedules.removeIf(schedule -> !Utilities.isActive(schedule.getDate(), schedule.getEndTime()));
                }

                return Schedules;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    public ObservableList<Appointment> getAllAppointments(){
        try {
            ArrayList<String> appointmentData = File.readFile("\\schedules\\Appointments.txt");
            ArrayList<String[]> parseAppointmentData = File.parseData(appointmentData);

            ObservableList<Appointment> FXAppointmentData = FXCollections.observableArrayList();

            for (String[] data : parseAppointmentData) {
                FXAppointmentData.add(new Appointment(data[0], data[1], data[2], data[3], data[4]));
            }
            return FXAppointmentData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Appointment> getAllDoctorAppointments(String doctorID){
        try {
            ArrayList<String> appointmentData = File.readFile("\\schedules\\Appointments.txt");
            ArrayList<String[]> parseAppointmentData = File.parseData(appointmentData);

            ObservableList<Appointment> FXAppointmentData = FXCollections.observableArrayList();

            for (String[] data : parseAppointmentData) {
                if (data[0].equals(doctorID)){
                    FXAppointmentData.add(new Appointment(data[0], data[1], data[2], data[3], data[4]));
                }
            }

            return FXAppointmentData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<AppointmentDetail> getAllAppointmentDetails() {
        ObservableList<Doctor> doctors = ClinicalSystem.getUserDataManager().getAllDoctors();
        HashMap<String, Doctor> doctorMap = new HashMap<>();
        ObservableList<Patient> patients = ClinicalSystem.getUserDataManager().getAllPatients();
        HashMap<String, Patient> patientMap = new HashMap<>();
        ObservableList<Schedule> schedules = ClinicalSystem.getScheduler().getAllSchedules();
        HashMap<String, Schedule> scheduleMap = new HashMap<>();
        ObservableList<Appointment> appointments = ClinicalSystem.getScheduler().getAllAppointments();
        ObservableList<AppointmentDetail> appointmentDetails = FXCollections.observableArrayList();

        for (Doctor doctor : doctors) {
            doctorMap.put(doctor.getID(), doctor);
        }

        for (Patient patient : patients) {
            patientMap.put(patient.getID(), patient);
        }

        for (Schedule schedule : schedules) {
            scheduleMap.put(schedule.getScheduleID(), schedule);
        }

        for (Appointment appointment : appointments) {
            Doctor doctor = doctorMap.get(scheduleMap.get(appointment.getScheduleID()).getDoctorID());
            Patient patient = patientMap.get(appointment.getPatientID());
            Schedule schedule = scheduleMap.get(appointment.getScheduleID());

            appointmentDetails.add(new AppointmentDetail(doctor, patient, schedule, appointment.getTime(), appointment.getDescription()));
        }

        return appointmentDetails;
    }

    public ObservableList<ScheduleDetail> getAllScheduleDetails() {
        ObservableList<Schedule> schedules = ClinicalSystem.getScheduler().getAllSchedules();
        ObservableList<Doctor> doctors = ClinicalSystem.getUserDataManager().getAllDoctors();
        HashMap<String, Doctor> doctorMap = new HashMap<>();
        ObservableList<ScheduleDetail> scheduleDetails = FXCollections.observableArrayList();

        for (Doctor doctor : doctors) {
            doctorMap.put(doctor.getID(), doctor);
        }

        for (Schedule schedule : schedules) {
            Doctor doctor = doctorMap.get(schedule.getDoctorID());
            scheduleDetails.add(new ScheduleDetail(schedule, doctor, schedule.getStartTime(), schedule.getEndTime(), schedule.getDate()));
        }

        return scheduleDetails;
    }

    public ObservableList<ScheduleDetail> getActiveScheduleDetails(){
        ObservableList<ScheduleDetail> activeScheduleDetails = FXCollections.observableArrayList();
        for(ScheduleDetail scheduleDetail : getAllScheduleDetails()){
            if (Utilities.isActive(scheduleDetail.getDate(), scheduleDetail.getEndTime())) {
                activeScheduleDetails.add(scheduleDetail);
            }
        }
        return activeScheduleDetails;
    }

    public void addSchedule(String doctorID, String startTime, String endTime, String date) {
        String scheduleID = Utilities.generateID("SC", "\\schedules\\Schedules.txt");
        //Write to schedule file
        String scheduleData = File.formatData(scheduleID, doctorID, startTime, endTime, date);
        try {
            File.appendToFile("\\schedules\\Schedules.txt", scheduleData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Create a new appointment
    public void makeAppointment(String scheduleID, String patientID, String time, String description) {
        String appointmentID = Utilities.generateID("AP", "\\schedules\\appointments.txt");
        //Write to appointment file
        String appointmentData = File.formatData(appointmentID, scheduleID, patientID, time, description);
        try {
            File.appendToFile("\\schedules\\appointments.txt", appointmentData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cancelAppointment(String doctorID, String patientID, Appointment appointment) {

        //Delete from appointment file
    }

    public void completeAppointment(String issue, String prescription, String followUpDate, Appointment appointment) {
//        cancelAppointment(doctor, patient, appointment);
//
//        MedicalRecord medicalRecord = doctor.writeMedicalRecord(issue, prescription, followUpDate, appointment);
//
        //write to medical record file
//        Recorder.addRecord(patient, issue ,prescription, followUpDate, appointment);

        //delete from appointment file
    }

    public static void main(String[] args) {

    }
}
