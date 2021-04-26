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
public abstract class StaffUser extends User {
    
    private String title;
    private String department;

    public StaffUser(String userId, String username, String nic, String firstName, String lastName, String email, String password, String contactNo, int userType) {
        super(userId, username, nic, firstName, lastName, email, password, contactNo, userType);
    }
    
    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
