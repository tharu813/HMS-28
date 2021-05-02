package model;


public class Prescription {

    private int prescription_id;
    private String diagnosis;
    private String reason;
    private String further_treatment;
    private String prescribed_for;
    private String prescribed_by;

    public Prescription() {
        this.prescription_id = prescription_id;
        this.diagnosis = diagnosis;
        this.reason = reason;
        this.further_treatment = further_treatment;
        this.prescribed_for = prescribed_for;
        this.prescribed_by = prescribed_by;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getReason() {
        return reason;
    }

    public String getFurther_treatment() {
        return further_treatment;
    }

    public String getPrescribed_for() {
        return prescribed_for;
    }

    public String getPrescribed_by() {
        return prescribed_by;
    }

    public void setPrescription_id(int prescription_id) {
        this.prescription_id = prescription_id;
    }

    public int getPrescription_id() {
        return prescription_id;
    }


}