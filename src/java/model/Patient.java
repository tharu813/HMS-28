/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author THARUSHI
 */
public class Patient extends User {

    private String patient_id;
    private int age;
    private Date dob;
    private int house_no;
    private String street;
    private String city;
    private String registered_by;

    public Patient(String userId, String username, String nic, String firstName, String lastName, String email, String password, String contactNo, int userType) {
        super(userId, username, nic, firstName, lastName, email, password, contactNo, userType);
    }

    public String getPatient_id() {
        return patient_id;
    }

    public int getAge() {
        return age;
    }

    public Date getDob() {
        return dob;
    }

    public int getHouse_no() {
        return house_no;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getRegistered_by() {
        return registered_by;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setHouse_no(int house_no) {
        this.house_no = house_no;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegistered_by(String registered_by) {
        this.registered_by = registered_by;
    }

    
}
