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
    
    public Doctor loginUser(String username, String password){
           Doctor doc = new Doctor("1", username, "123456", "Nisha", "Fernando", "nisha@gmail.com", password, "0714484678", 1, 
                   "Psychiatrist", "Psychology", "Special", 12);
           return doc;
    } 
    
    
   
}


