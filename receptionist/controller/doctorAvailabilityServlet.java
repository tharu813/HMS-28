package controller;

import model.appoinment;
import controller.doctorAvailability;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;

//@WebServlet("/doctorAvailabilityServlet")
public class doctorAvailabilityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first_name = request.getParameter("first_name");
        Date date = Date.valueOf(request.getParameter("date"));


        List<appoinment> appoinmentList = doctorAvailability.checkAvailability(first_name, date);//call checkAvailability method

        System.out.println("servlet" + date);


        request.setAttribute("services", appoinmentList);

        RequestDispatcher dis = request.getRequestDispatcher("AppoinmentForm.jsp");
        dis.forward(request, response);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

