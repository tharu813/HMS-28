package service;

import model.LabReport;
import model.MedicalRecord;
import model.Patient;
import model.Prescription;

public interface IPatient {

    public Patient viewPatientProfile(String user_id);
    public MedicalRecord viewMedicalReport(String user_id);
    public LabReport viewLabReport(String user_id);
    public Prescription viewPrescription();



}
