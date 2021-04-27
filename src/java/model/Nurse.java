package model;

public class Nurse extends StaffUser{
    private String nursetId;

    public Nurse(String nursetId, String userId, String username, String nic, String firstName, String lastName, String email, String password, String contactNo, int userType, String title, String department) {
        super(userId, username, nic, firstName, lastName, email, password, contactNo, userType, title, department);
        this.nursetId = nursetId;
    }
    
    public String getNursetId() {
        return nursetId;
    }

    public void setNursetId(String nursetId) {
        nursetId = nursetId;
    }
}
