package controller;

import model.appoinment;
import controller.appoinmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;

//@WebServlet("/AddAppoinmentServlet")
public class AddAppoinmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String time = request.getParameter("time");
        System.out.println(time);

        Date date = Date.valueOf(request.getParameter("date"));

        String patientID = request.getParameter("patientID");

        String  doctorID= request.getParameter("doctorID");
        int state = Integer.parseInt(request.getParameter("state"));


        ;


        appoinment newAppoinment = new  appoinment(time,date, patientID,doctorID,state);
        try {

            appoinmentService.insertAppoinment(newAppoinment);
            response.sendRedirect("AppoinmentList.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
