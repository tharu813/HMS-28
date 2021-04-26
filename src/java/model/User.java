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
public class User {
    
    private String userId, username, nic, firstName, lastName, email, password, contactNo;
    private int userType;

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getNic() {
        return nic;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastNname) {
        this.lastName = lastNname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
   
   
    
    
    
    
}
