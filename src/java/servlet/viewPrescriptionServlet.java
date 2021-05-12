package servlet;

import model.Patient;
import model.Prescription;
import service.PatientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/viewPrescriptionServlet")
public class viewPrescriptionServlet extends HttpServlet {
    PatientService ps = new PatientService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String user_id = (String)session.getAttribute("user_id");
        System.out.println("servlet" +user_id);
        Prescription p = new Prescription();
        p = ps.viewPrescription(user_id);


        RequestDispatcher ds =request.getRequestDispatcher("viewPatientProfile.jsp");
        ds.forward(request,response);
    }
}
