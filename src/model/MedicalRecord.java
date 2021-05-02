package model;

/**
 *
 * @author THARUSHI
 */
public class MedicalRecord {

    private int emr_id;
    private String bp_level;
    private int weight;
    private int height;
    private String allergies;
    private String diagnoses;
    private String medication;
    private String patient_id;


    public MedicalRecord(int emr_id, String bp_level, int weight, int height, String allergies, String diagnoses, String medication, String patient_id) {
        this.emr_id = emr_id;
        this.bp_level = bp_level;
        this.weight = weight;
        this.height = height;
        this.allergies = allergies;
        this.diagnoses=diagnoses;
        this.medication=medication;
        this.patient_id = patient_id;
    }

    public MedicalRecord(){}

    public int getEmr_id() {
        return emr_id;
    }

    public String getBp_level() {
        return bp_level;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setEmr_id(int emr_id) {
        this.emr_id = emr_id;
    }

    public void setBp_level(String bp_level) {
        this.bp_level = bp_level;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }
    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }


}