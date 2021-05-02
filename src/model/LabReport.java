package model;

import java.io.File;
import java.sql.Date;

/**
 *
 * @author THARUSHI
 */
public class LabReport {


    private int ref_id;
    private String patient_id;
    private String doctor_id;
    private String date;
    private String test_requested;
    private String result;
    private int state;

    public LabReport(int ref_id, String patient_id, String doctor_id, String date, String test_requested, String result, int state) {
        this.ref_id = ref_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.date = date;
        this.test_requested = test_requested;
        this.result = result;
        this.state = state;
    }

    public LabReport() {

    }

    public int getRef_id() {
        return ref_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public String getDate() {
        return date;
    }

    public String getTest_requested() {
        return test_requested;
    }

    public String getResult() {
        return result;
    }

    public int getState() {
        return state;
    }

    public void setRef_id(int ref_id) {
        this.ref_id = ref_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTest_requested(String test_requested) {
        this.test_requested = test_requested;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setState(int state) {
        this.state = state;
    }


}