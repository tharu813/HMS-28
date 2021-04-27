/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 *
 * @author THARUSHI
 */
public class DBHandler {

    public Connection createConnection() throws ClassNotFoundException, SQLException {

        System.out.println("App Started");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms28db", "root", "");
        return con;
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

}
