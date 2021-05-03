package model;

public class LabTechnician extends StaffUser{

    private String labTechnician;

    public LabTechnician(){
        super();
    }

    public String getLabTechnician() {
        return labTechnician;
    }

    public void setLabTechnician(String labTechnician) {
        this.labTechnician = labTechnician;
    }
}
