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

/**
 *
 * @author THARUSHI
 */
public class DBHandler {

    public Connection createConnection() throws ClassNotFoundException, SQLException {

        System.out.println("App Started");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms28?serverTimezone=UTC", "root", "");
        return con;
    }

    public Doctor loginUser(String username, String password) {
        Doctor doc = new Doctor("1", username, "123456", "Nisha", "Fernando", "nisha@gmail.com", password, "0714484678", 1,
                "Psychiatrist", "Psychology", "Special", 12);
        return doc;
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
    
    
    
    
}
