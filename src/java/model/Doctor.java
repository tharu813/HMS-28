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
public class Doctor {
    
    private String doctorId, specialization;
    private int slmcNo;
    
    public void setDoctorId(String docId){
        this.doctorId = docId;
    }
    
    public String getId(){
        return doctorId;
    }
    
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    
    public String getSpecialization(){
        return specialization;
    }
    
    public void setSlmc(int slmcNo){
        this.slmcNo = slmcNo;
    }
    
    public int getSlmc(){
        return slmcNo;
    }
    
    
}
