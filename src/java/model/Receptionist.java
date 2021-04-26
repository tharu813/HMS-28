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
public class Receptionist extends StaffUser{
    
    private String receptionistId;

    public Receptionist(String userId, String username, String nic, String firstName, String lastName, String email, String password, String contactNo, int userType) {
        super(userId, username, nic, firstName, lastName, email, password, contactNo, userType);
    }

    public String getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(String receptionistId) {
        this.receptionistId = receptionistId;
    }
    
    
}
