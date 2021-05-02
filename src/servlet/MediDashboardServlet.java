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

@WebServlet("/MediDashboardServlet")
public class MediDashboardServlet extends HttpServlet {
    PatientService ps1 = new PatientService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String user_id = (String)session.getAttribute("user_id");
        System.out.println("servlet" +user_id);
        MedicalRecord m = new MedicalRecord();
        m = ps1.viewMedicalReport(user_id);
        request.setAttribute("emr_id",m.getEmr_id());
        request.setAttribute("firsLast",m.getBp_level());
        request.setAttribute("height",m.getHeight());
        request.setAttribute("weight",m.getWeight());
        request.setAttribute("allergies",m.getAllergies());
        request.setAttribute("diagnosis",m.getDiagnoses());
        request.setAttribute("medication",m.getMedication());
        request.setAttribute("patient_id",m.getPatient_id());



        RequestDispatcher ds =request.getRequestDispatcher("viewMedicalReport.jsp");
        ds.forward(request,response);
    }
    }

