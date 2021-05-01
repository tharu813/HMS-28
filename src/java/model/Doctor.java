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
public class Doctor extends StaffUser{
    
    private String specialization;
    private int slmcNo;
    
    public Doctor() {
        super();
    }
    
    public Doctor(String userId, String username, String nic, String firstName, 
            String lastName, String email, String password, String contactNo, int userType,
            String title, String department, String specialization, int slmcNo) {
        super(userId, username, nic, firstName, lastName, email, password, contactNo, userType, title, department);
        this.specialization = specialization;
        this.slmcNo = slmcNo;
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
