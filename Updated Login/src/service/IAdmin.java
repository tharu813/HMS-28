package service;

import model.*;

public interface IAdmin {
    public boolean addDoctor(Doctor doctor);

    public boolean addPatient(Patient patient);

    public boolean addReceptionist(Receptionist receptionist);

    public boolean addNurse(Nurse nurse);

    public boolean addCashier(Cashier cashier);

    public boolean addLabTechinician(LabTechnician labTechnician);

    public boolean addConsultation_info(Consultation_info consultation_info);

}
