/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author THARUSHI
 */
public class DBHandler {

    public static Connection createConnection() throws ClassNotFoundException, SQLException {

        System.out.println("App Started");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms28?serverTimezone=UTC", "root", "");
        return con;
    }

    public User login(User u) {

        String username = u.getUsername();
        String password = u.getPassword();

        try {
            Connection con = createConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE username = ?;");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                if (storedPassword.equals(password)) {
                    String userID = rs.getString("user_id");
                    String nic = rs.getString("nic");
                    String fName = rs.getString("first_name");
                    String lName = rs.getString("last_name");
                    String email = rs.getString("email");
                    int userType = rs.getInt("user_type");

                    ps = con.prepareStatement("SELECT * FROM user_contact where user_id = ?;");
                    ps.setString(1, userID);
                    rs = ps.executeQuery();

                    if (rs.next()) {

                        String contactNo = rs.getString("contact_no");

                        if (userType < 6) {

                            ps = con.prepareStatement("SELECT * FROM staff_user where staff_id = ?;");
                            ps.setString(1, userID);
                            rs = ps.executeQuery();

                            if (rs.next()) {

                                String title = rs.getString("title");
                                String department = rs.getString("department");

                                switch (userType) {

                                    case 0: // System Admin
                                        StaffUser sysAdmin = new StaffUser(userID,
                                                username, nic, fName, lName, email,
                                                password, contactNo, userType, title, department);
                                        return sysAdmin;
                                    case 1: // Doctor

                                        ps = con.prepareStatement("SELECT * FROM doctor WHERE doctor_id = ?;");
                                        ps.setString(1, userID);
                                        rs = ps.executeQuery();

                                        if (rs.next()) {
                                            String specialization = rs.getString("specialization");
                                            int slmcNo = rs.getInt("slmc_no");

                                            Doctor doctor = new Doctor(userID,
                                                    username, nic, fName, lName, email,
                                                    password, contactNo, userType,
                                                    title, department, specialization, slmcNo);
                                            return doctor;
                                        }

                                        break;
                                    case 2: // Receptionist
                                        Receptionist receptionist = new Receptionist(userID,
                                                username, nic, fName, lName, email,
                                                password, contactNo, userType, title, department);
                                        return receptionist;
                                    case 3: // Nurse
                                        Nurse nurse = new Nurse(userID, userID,
                                                username, nic, fName, lName, email,
                                                password, contactNo, userType, title, department);
                                        return nurse;
                                    case 4: // Lab Technician
                                        StaffUser labTec = new StaffUser(userID,
                                                username, nic, fName, lName, email,
                                                password, contactNo, userType, title, department);
                                        return labTec;
                                    case 5: //Cashier
                                        StaffUser cashier = new StaffUser(userID,
                                                username, nic, fName, lName, email,
                                                password, contactNo, userType, title, department);
                                        return cashier;
                                    default:
                                        break;
                                }
                            }

                        } else if (userType == 6) {

                            ps = con.prepareStatement("SELECT * FROM patient WHERE patient_id = ?;");
                            ps.setString(1, userID);
                            rs = ps.executeQuery();

                            if (rs.next()) {
                                int age = rs.getInt("age");
                                Date dob = rs.getDate("dob");
                                int house_no = Integer.parseInt(rs.getString("house_no"));
                                String street = rs.getString("street");
                                String city = rs.getString("city");
                                String regBy = rs.getString("registered_by");

                                Patient patient = new Patient(age, dob, house_no, street,
                                        city, regBy, userID, username, nic, fName, lName,
                                        email, password, contactNo, userType);
                                return patient;
                            }
                        }
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        u.setUserType(-1);
        return u;
    }

    public Patient fetchPatient(String uname) throws SQLException, ClassNotFoundException {
        try {
            Connection con = createConnection();

            PreparedStatement ps = con.prepareStatement("select * from user where username = ?");
            ps.setString(1, uname);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String userID = rs.getString("user_id");
                String nic = rs.getString("nic");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int userType = rs.getInt("user_type");

                ps = con.prepareStatement("select * from patient where patient_id = ?");
                ps.setString(1, userID);

                rs = ps.executeQuery();

                if (rs.next()) {
                    int age = rs.getInt("age");
                    Date dob = rs.getDate("dob");
                    int house_no = Integer.parseInt(rs.getString("house_no"));
                    String street = rs.getString("street");
                    String city = rs.getString("city");
                    String regBy = rs.getString("registered_by");

                    ps = con.prepareStatement("select * from user_contact where user_id = ? ;");
                    ps.setString(1, userID);

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        String contact_no = rs.getString("contact_no");

                        Patient p = new Patient(age, dob, house_no, street, city, regBy, userID, uname, nic, fName, lName, email, password, contact_no, userType);
                        return p;
                    }
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public MedicalRecord fetchEMR(String patientID) throws SQLException, ClassNotFoundException {
        try {
            Connection con = createConnection();

            PreparedStatement ps = con.prepareStatement("select * from medical_record where patient_id = ?");

            ps.setString(1, patientID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int emrID = rs.getInt("emr_id");
                int height = rs.getInt("height");
                int weight = rs.getInt("weight");
                String bp_level = rs.getString("bp_level");
                String allergies = rs.getString("allergies");
                String diagnosis = rs.getString("diagnosis");
                String medication = rs.getString("medication");

                MedicalRecord medRec = new MedicalRecord(emrID, bp_level,
                        height, weight, allergies, patientID, diagnosis, medication);
                con.close();

                return medRec;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public int addEMR(MedicalRecord emr, Patient p) throws SQLException, ClassNotFoundException {

        int status = 0;
        try {

            Connection con = createConnection();

            PreparedStatement ps = con.prepareStatement("insert into medical_record(emr_id, bp_level, weight, height, allergies, diagnosis, medication, patient_id) values (default,?,?,?,?,?,?,?)");

            ps.setString(1, emr.getBp_level());
            ps.setInt(2, emr.getWeight());
            ps.setInt(3, emr.getHeight());
            ps.setString(4, emr.getAllergies());
            ps.setString(5, emr.getDiagnosis());
            ps.setString(6, emr.getMedication());
            ps.setString(7, p.getUserId());

            status = ps.executeUpdate();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return status;
    }

    public int addPrescription(Prescription pres, ArrayList<String> drugList) throws SQLException, ClassNotFoundException {

        int status = 0;
        try {

            Connection con = createConnection();

            PreparedStatement ps = con.prepareStatement("insert into prescription values (?,?,?,?,?,?); ");
            ps.setInt(1, pres.getPrescription_id());
            ps.setString(2, pres.getDiagnosis());
            ps.setString(3, pres.getReason());
            ps.setString(4, pres.getFurther_treatment());
            ps.setString(5, pres.getPrescribed_for());
            ps.setString(6, pres.getPrescribed_by());

            status = ps.executeUpdate();

            for (String drug : drugList) {
                ps = con.prepareStatement("insert into prescribed_drug values (?, ?) ;");
                ps.setInt(1, pres.getPrescription_id());
                ps.setString(2, drug);
                status = ps.executeUpdate();
            }

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return status;
    }

    public String generateID(String tableName) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = createConnection().prepareStatement("SELECT COUNT(*) FROM " + tableName + " ;");
        // cannot setString to preparedStatement as tablename is not of VARCHAR data type
        int count = 0;

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            count = rs.getInt(1);
        }

        return String.valueOf(count + 1);
    }

    public ArrayList<String[]> getAppointments(String doctorID) throws ClassNotFoundException, SQLException {

        Connection con = createConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM appointment where doctor_id = ? and state = 1;");
        ps.setString(1, doctorID);

        ResultSet rs = ps.executeQuery();

        PreparedStatement ps2 = con.prepareStatement("SELECT * FROM user where user_id = ?;");
        ResultSet rs2;

        ArrayList<String[]> appointments = new ArrayList<>();

        while (rs.next()) {
            Date date = rs.getDate("date");
            String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
            Time time = rs.getTime("time");
            String timeString = time.toString();
            String appointmentID = String.valueOf(rs.getInt("appointment_id"));

            String patientID = rs.getString("patient_id");

            ps2.setString(1, patientID);
            rs2 = ps2.executeQuery();

            if (rs2.next()) {
                String fName = rs2.getString("first_name");
                String lName = rs2.getString("last_name");
                String fullName = fName + " " + lName;

                appointments.add(new String[]{fullName, dateString, timeString, appointmentID});
            }
        }

        return appointments;
    }

    public boolean AddPatient(String username, String nic, String firstName, String lastName, String email, String password, String contactNo, String age, String dob, String house_no, String street, String city, int userType, int regBy) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = createConnection().prepareStatement(" INSERT INTO user VALUES (?,?,?,?,?,?,?,?); ");

        String UserId = generateID("user");
        ps.setString(1, UserId);
        ps.setString(2, username);
        ps.setString(3, nic);
        ps.setString(4, firstName);
        ps.setString(5, lastName);
        ps.setString(6, email);
        ps.setString(7, password);
        ps.setInt(8, userType);

        int i = ps.executeUpdate();

        ps = createConnection().prepareStatement("INSERT INTO patient VALUES (?,?,?,?,?,?,?); ");

        ps.setString(1, UserId);
        ps.setString(2, age);
        ps.setString(3, dob);
        ps.setString(4, house_no);
        ps.setString(5, street);
        ps.setString(6, city);
        ps.setInt(7, regBy);

        i = ps.executeUpdate();

        ps = createConnection().prepareStatement("INSERT INTO user_contact VALUES (?,?);");

        ps.setString(1, UserId);
        ps.setString(2, contactNo);

        i = ps.executeUpdate();

        if (i > 0) {
            return true;
        } else {
            return false;
        }

    }

    public Patient updatePatient(String uId) throws SQLException, ClassNotFoundException {
        try {
            int age = 0;
            Date dob = null;
            int house_no = 0;
            String street = "";
            String city = "";
            String regBy = "";
            String contact_no = "";

            Connection con = createConnection();

            PreparedStatement ps = con.prepareStatement("select * from user where user_id = ?");
            ps.setString(1, uId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String userID = rs.getString("user_id");
                String nic = rs.getString("nic");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int userType = rs.getInt("user_type");

                ps = con.prepareStatement("select * from patient where patient_id = ?");
                ps.setString(1, userID);

                rs = ps.executeQuery();

                if (rs.next()) {
                    age = rs.getInt("age");
                    dob = rs.getDate("dob");
                    house_no = Integer.parseInt(rs.getString("house_no"));
                    street = rs.getString("street");
                    city = rs.getString("city");
                    regBy = rs.getString("registered_by");

                    ps = con.prepareStatement("select * from user_contact where user_id = ? ;");
                    ps.setString(1, userID);

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        contact_no = rs.getString("contact_no");

//                        Patient p = new Patient(age,dob, house_no, street, city, regBy, userID, uname, nic, fName, lName, email, password, contact_no, userType);
//                        return p;
                    }
                }
                String uname = null;

                Patient p = new Patient(age, dob, house_no, street, city, regBy, userID, uname, nic, fName, lName, email, password, contact_no, userType);
                return p;

            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            return null;
        }
        //return null;

    }

    public int addLabTest(LabReport lr) throws SQLException, ClassNotFoundException {

        int status = 0;
        try {

            Connection con = createConnection();

            PreparedStatement ps = con.prepareStatement("insert into lab_report_details(ref_id, patient_id, doctor_id, date, test_requested, result, state) values (default,?,?,?,?,?,?)");

            ps.setString(1, lr.getPatient_id());
            ps.setString(2, lr.getDoctor_id());
            ps.setString(3, lr.getDate());
            ps.setString(4, lr.getTest_requested());
            ps.setString(5, lr.getResult());
            ps.setInt(6, lr.getState());

            status = ps.executeUpdate();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return status;
    }

    public int updateEMR(String patientID, MedicalRecord emr) throws SQLException, ClassNotFoundException {

        int status = 0;
        try {

            Connection con = createConnection();

            PreparedStatement ps = con.prepareStatement("update medical_record "
                    + "set bp_level = ?, weight = ?, height = ?, "
                    + "allergies = ?, diagnosis = ?, medication = ? where patient_id = ? ");

            ps.setString(1, emr.getBp_level());
            ps.setInt(2, emr.getWeight());
            ps.setInt(3, emr.getHeight());
            ps.setString(4, emr.getAllergies());
            ps.setString(5, emr.getDiagnosis());
            ps.setString(6, emr.getMedication());
            ps.setString(7, patientID);

            status = ps.executeUpdate();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return status;

    }

    public void deleteAppointment(int appointmentID) throws SQLException, ClassNotFoundException {

       

        try {

            Connection con = createConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM appointment WHERE appointment_id = ?");
            ps.setInt(1, appointmentID);
            ps.executeUpdate();
            
            con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
       
    }

   
}
