package model;

import java.sql.Date;
import java.sql.Time;

public class appoinment {

    private int appointmentID;
    private Date date;
    private String time;
    private String first_name;
    private String last_name;
    private String patientID, doctorID, receptionistID;
    private int state;

    public appoinment(int appointmentID, Date date, String time, String first_name,String last_name,String patientID, String doctorID, String receptionistID,int state) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.time = time;
        this.first_name = first_name;
        this.last_name = last_name;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.receptionistID = receptionistID;
        this.state = state;
    }
    public appoinment(String last_name,String doctorID){
        this.last_name = last_name;
        this.doctorID=doctorID;
    }

    public appoinment(int appointmentID, String time, Date date, String patientID, String doctorID, int state) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.time = time;

        this.patientID = patientID;
        this.doctorID = doctorID;
        this.receptionistID = receptionistID;
        this.state = state;
    }

    public appoinment(String time, Date date, String patientID, String doctorID, int state) {
        this.time = time;
        this.date = date;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.state = state;
    }

    public void setAppointmentID(int id) {
        this.appointmentID = id;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public  String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public  String getDoctorID() {
        return doctorID;
    }

    public void setReceptionistID(String receptionistID) {
        this.receptionistID = receptionistID;
    }

    public String getReceptionistID() {
        return receptionistID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
