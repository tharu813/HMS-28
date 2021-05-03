package model;

public class Nurse extends StaffUser{
    private String nursetId;

    public Nurse(){
        super();
    }


    public String getNursetId() {
        return nursetId;
    }

    public void setNursetId(String nursetId) {
        nursetId = nursetId;
    }
}
