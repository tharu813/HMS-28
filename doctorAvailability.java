package service;

import model.appoinment;
import util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class doctorAvailability {
    private static PreparedStatement preparedStatement;
    private static Connection con;
    public static List<appoinment> checkAvailability(String first_name,Date date) {

        //use arraylist to store list of appoinment
        List <appoinment> list1 = new ArrayList<>();
        //  Establishing a Connection
        try {

            con = DBConnectionUtil.getConnection();
            //Create a statement using connection object


            PreparedStatement preparedStatement = con.prepareStatement("SELECT distinct u.first_name,u.last_name,a.doctorID from appoinment a, user u where a.doctorID = u.user_id and u.first_name = ? and a.date <> ? ");

            preparedStatement.setString(1, first_name);
            preparedStatement.setDate(2, date);
            System.out.println("service"+date);
            //  Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            //  Process the ResultSet object.
            while (rs.next()) {


                String lname = rs.getString("last_name");
                String doctorID = rs.getString("doctorID");




                list1.add(new appoinment(lname,doctorID));
            }
            System.out.println(preparedStatement);
        } catch (SQLException | ClassNotFoundException e) {
            printSQLException1(e);

        }
        return  list1;
    }

    private static void printSQLException1(Exception e) {
    }

}
