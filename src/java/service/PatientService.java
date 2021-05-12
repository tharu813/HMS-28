package service;

import model.LabReport;
import model.MedicalRecord;
import model.Patient;
import model.Prescription;
import util.DBConnectionUtil;

import java.sql.*;

public class PatientService  implements  IPatient{


    private static Connection con;

    private static PreparedStatement preparedStatement;

    @Override
    public Patient viewPatientProfile(String user_id) {

        Patient p=new Patient();
        try {

            con = DBConnectionUtil.getConnection();
            String sql = "SELECT * from user u,patient p,user_contact uc where u.user_id=p.patient_id and uc.user_id=u.user_id and u.user_id = ?;";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user_id);

            ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next()) {
               p.setUserId(resultSet.getString("user_id"));
               p.setUsername(resultSet.getString("username"));
               p.setNic(resultSet.getString("nic"));
               p.setFirstName(resultSet.getString("first_name"));
               p.setLastName(resultSet.getString("last_name"));
               p.setEmail(resultSet.getString("email"));
               //p.setUserId(resultSet.getString(7));
               p.setAge(Integer.parseInt(resultSet.getString("age")));
               p.setDob(resultSet.getDate("dob"));
               p.setHouse_no(Integer.parseInt(resultSet.getString("house_no")));
               p.setStreet(resultSet.getString("street"));
               p.setCity(resultSet.getString("city"));
               p.setRegistered_by(resultSet.getString("registered_by"));
               p.setContactNo(resultSet.getString("contact_no"));

           }
            System.out.println("service"+user_id);





            } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

            return p;

    }

    @Override
    public MedicalRecord viewMedicalReport(String user_id) {

        MedicalRecord m=new MedicalRecord();
        try {

            con = DBConnectionUtil.getConnection();
            String sql = "SELECT * from medical_record m,patient p,user u where u.user_id=p.patient_id and p.patient_id=m.patient_id and u.user_id = ?;";

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                m.setEmr_id(resultSet.getInt(1));
                m.setBp_level(resultSet.getString(2));
                m.setWeight(resultSet.getInt(3));
                m.setHeight(resultSet.getInt(4));
                m.setAllergies(resultSet.getString(5));
                m.setDiagnoses(resultSet.getString(6));
                m.setMedication(resultSet.getString(7));
                m.setPatient_id(resultSet.getString(8));

            }
            System.out.println("service"+user_id);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

        return m;

    }

    @Override
    public LabReport viewLabReport(String user_id) {
        LabReport l=new LabReport();
        try {

            con = DBConnectionUtil.getConnection();
            String sql = "SELECT * from lab_report_details l,patient p,user u where u.user_id=p.patient_id and p.patient_id=l.patient_id";

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                l.setRef_id(resultSet.getInt(1));
                l.setPatient_id(resultSet.getString(2));
                l.setDoctor_id(resultSet.getString(3));
                l.setDate(resultSet.getString(4));
                l.setTest_requested(resultSet.getString(5));
                l.setResult(resultSet.getString(6));
                l.setState(resultSet.getInt(7));


            }
            System.out.println("service"+user_id);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

        return l;

    }

    @Override
    public Prescription viewPrescription(String user_id) {
        Prescription p = new Prescription();
        try {
            String sql = "SELECT * from prescription m,patient p,user u where u.user_id=p.patient_id and p.patient_id=m.prescribed_for and u.user_id = ?;";

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                p.setPrescription_id(resultSet.getInt(1));
                p.setDiagnosis(resultSet.getString(2));
                p.setReason(resultSet.getString(3));
                p.setFurther_treatment(resultSet.getString(4));
                p.setPrescribed_for(resultSet.getString(5));
                p.setPrescribed_by(resultSet.getString(6));



            }


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return p;
    }

}
