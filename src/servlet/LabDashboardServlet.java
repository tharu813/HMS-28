package servlet;

import model.LabReport;
import model.MedicalRecord;
import service.PatientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LabDashboardServlet")
public class LabDashboardServlet extends HttpServlet {
    PatientService ps = new PatientService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String user_id = (String)session.getAttribute("user_id");
        System.out.println("servlet" +user_id);
        LabReport l = new LabReport();
        l = ps.viewLabReport(user_id);
        request.setAttribute("ref_id",l.getRef_id());
        request.setAttribute("patient_id",l.getPatient_id());
        request.setAttribute("doctor_id",l.getDoctor_id());
        request.setAttribute("date",l.getDate());
        request.setAttribute("test_requested",l.getTest_requested());
        request.setAttribute("result",l.getResult());
        request.setAttribute("state",l.getState());




        RequestDispatcher ds =request.getRequestDispatcher("viewLabReport.jsp");
        ds.forward(request,response);
    }
    }

