package controller;

import model.appoinment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import model.DBHandler;

public class appoinmentService {

    private static PreparedStatement preparedStatement;
    private static Connection con;

    public static void insertAppoinment(appoinment appmn) throws SQLException {

        try {
            DBHandler dbHandler = new DBHandler();
            con = dbHandler.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO appoinment " + " (date,time,patientID,doctorID,state) VALUES " + " (?,?,?,?,?)");

            preparedStatement.setDate(1, appmn.getDate());
            preparedStatement.setString(2, appmn.getTime());
            preparedStatement.setString(3, appmn.getPatientID());
            preparedStatement.setString(4, appmn.getDoctorID());

            preparedStatement.setInt(5, appmn.getState());

            System.out.println(preparedStatement);
            preparedStatement.executeLargeUpdate();

        } catch (SQLException | ClassNotFoundException e) {

            printSQLException1(e);
        }
    }

    public List<appoinment> selectAllAppoinment() {

        //use arraylist to store list of appoinment
        List< appoinment> listAppoinment = new ArrayList<>();
        //  Establishing a Connection
        try {

            DBHandler dbHandler = new DBHandler();
            con = dbHandler.createConnection();
            //Create a statement using connection object
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM appoinment");
            System.out.println(preparedStatement);
            //  Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            //  Process the ResultSet object.
            while (rs.next()) {
                int appointmentID = rs.getInt("appointmentID");

                String time = rs.getString("time");
                Date date = rs.getDate("date");
                String patientID = rs.getString("patientID");
                String doctorID = rs.getString("doctorID");
                int state = rs.getInt("state");

                listAppoinment.add(new appoinment(appointmentID, time, date, patientID, doctorID, state));
            }
        } catch (SQLException | ClassNotFoundException e) {
            printSQLException1(e);
        }
        return listAppoinment;
    }

    private static void printSQLException1(Exception e) {
    }
}
