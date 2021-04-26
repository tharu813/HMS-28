/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

/**
 *
 * @author THARUSHI
 */
public class Appointment {

    private int appointmentID;
    private Date date;
    private Time time;
    private String patientID, doctorID, receptionistID;

    public Appointment(int appointmentID, Date date, Time time, String patientID, String doctorID, String receptionistID) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.time = time;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.receptionistID = receptionistID;
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

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return time;
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

    public String getDoctorID() {
        return doctorID;
    }

    public void setReceptionistID(String receptionistID) {
        this.receptionistID = receptionistID;
    }
    
    public String getReceptionistID() {
        return receptionistID;
    }

}
