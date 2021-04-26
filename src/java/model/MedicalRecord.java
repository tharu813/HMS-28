/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author THARUSHI
 */
public class MedicalRecord {
    
    private String emr_id;
    private String bp_level;
    private int height;
    private int weight; 
    private String allergies;
    private String patient_id;

    public MedicalRecord(String emr_id, String bp_level, int height, int weight, String allergies, String patient_id) {
        this.emr_id = emr_id;
        this.bp_level = bp_level;
        this.height = height;
        this.weight = weight;
        this.allergies = allergies;
        this.patient_id = patient_id;
    }

    public String getEmr_id() {
        return emr_id;
    }

    public String getBp_level() {
        return bp_level;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setEmr_id(String emr_id) {
        this.emr_id = emr_id;
    }

    public void setBp_level(String bp_level) {
        this.bp_level = bp_level;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }
    
    
}
