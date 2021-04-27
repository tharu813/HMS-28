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
public class Drug {
    private String drug;
    private int prescription_id;

    public Drug(int prescription_id, String drug) {
        this.drug = drug;
        this.prescription_id = prescription_id;
    }

    
    public String getDrug() {
        return drug;
    }

    public int getPrescription_id() {
        return prescription_id;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public void setPrescription_id(int prescription_id) {
        this.prescription_id = prescription_id;
    }
   
    
}
