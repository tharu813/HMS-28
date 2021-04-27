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

    //login validation
    public int login(User u) {

        String username = u.getUsername();
        String password = u.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";
        int roleDB;

        try {
            con = createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username,password,user_type from user");

            while (resultSet.next()) {
                userNameDB = resultSet.getString("username");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getInt("user_type");

                if (username.equals(userNameDB) && password.equals(passwordDB) && roleDB == 0) {
                    return 0;
                } else if (username.equals(userNameDB) && password.equals(passwordDB) && roleDB == 1) {
                    return 1;
                } else if (username.equals(userNameDB) && password.equals(passwordDB) && roleDB == 2) {
                    return 2;
                } else if (username.equals(userNameDB) && password.equals(passwordDB) && roleDB == 3) {
                    return 3;
                } else if (username.equals(userNameDB) && password.equals(passwordDB) && roleDB == 4) {
                    return 4;
                } else if (username.equals(userNameDB) && password.equals(passwordDB) && roleDB == 5) {
                    return 5;
                } else if (username.equals(userNameDB) && password.equals(passwordDB) && roleDB == 6) {
                    return 6;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
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

    /* public MedicalRecord fetchEMR(Patient p) throws SQLException, ClassNotFoundException {
        try {
            Connection con = createConnection();

            PreparedStatement ps = con.prepareStatement("select * from medical_record where patient_id = ?");
            
            Patient p = new Patient();
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
    }*/
    public int addEMR(MedicalRecord emr) throws SQLException, ClassNotFoundException {

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
            ps.setString(7, "");

            status = ps.executeUpdate();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    return status;
    }
    
     /*public int addPrescription(Prescription pres) throws SQLException, ClassNotFoundException {

        int status = 0;
        try {
            
            Connection con = createConnection();

            PreparedStatement ps = con.prepareStatement("insert into medical_record(emr_id, bp_level, weight, height, allergies, diagnosis, medication, patient_id) values (default,?,?,?,?,?,?,?)");
            ps.setString(1, pres.getBp_level());
            ps.setInt(2, emr.getWeight());
            ps.setInt(3, emr.getHeight());
            ps.setString(4, emr.getAllergies());
            ps.setString(5, emr.getDiagnosis());
            ps.setString(6, emr.getMedication());
            ps.setString(7, "");

            status = ps.executeUpdate();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    return status;
    }*/
}
