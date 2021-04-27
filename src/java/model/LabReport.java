/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.sql.Date;

/**
 *
 * @author THARUSHI
 */
public class LabReport {
    
   
private String ref_id;
private String patient_id;
private String doctor_id;
private Date date;
private String test_requested; 
private File result; 
private short state;

    public LabReport(String ref_id, String patient_id, String doctor_id, Date date, String test_requested, File result, short state) {
        this.ref_id = ref_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.date = date;
        this.test_requested = test_requested;
        this.result = result;
        this.state = state;
    }

    public String getRef_id() {
        return ref_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public Date getDate() {
        return date;
    }

    public String getTest_requested() {
        return test_requested;
    }

    public File getResult() {
        return result;
    }

    public short getState() {
        return state;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTest_requested(String test_requested) {
        this.test_requested = test_requested;
    }

    public void setResult(File result) {
        this.result = result;
    }

    public void setState(short state) {
        this.state = state;
    }


}
