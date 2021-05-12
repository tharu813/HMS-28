package servlet;

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


public class ViewPatientServlet extends HttpServlet {
    PatientService ps = new PatientService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String user_id = (String)session.getAttribute("user_id");
        System.out.println("servlet" +user_id);
        Patient p = new Patient();
        p = ps.viewPatientProfile(user_id);
        request.setAttribute("firstName",p.getFirstName());
        request.setAttribute("firsLast",p.getLastName());
        request.setAttribute("age",p.getAge());
        request.setAttribute("dob",p.getDob());
        request.setAttribute("nic",p.getNic());
        request.setAttribute("email",p.getEmail());
        request.setAttribute("contact_no",p.getContactNo());
        request.setAttribute("house_no",p.getHouse_no());
        request.setAttribute("street",p.getHouse_no());
        request.setAttribute("city",p.getCity());
        request.setAttribute("registered_by",p.getRegistered_by());


        RequestDispatcher ds =request.getRequestDispatcher("/viewPatientProfile.jsp");
        ds.forward(request,response);
    }

}
