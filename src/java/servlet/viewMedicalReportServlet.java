package servlet;

import model.MedicalRecord;
import model.Patient;
import service.PatientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "viewMedicalReportServlet")
public class viewMedicalReportServlet extends HttpServlet {
    PatientService ps = new PatientService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String user_id = (String)session.getAttribute("user_id");
        System.out.println("servlet" +user_id);
        MedicalRecord m = new MedicalRecord();
        m = ps.viewMedicalReport(user_id);



        RequestDispatcher ds =request.getRequestDispatcher("viewPatientProfile.jsp");
        ds.forward(request,response);
    }
}
