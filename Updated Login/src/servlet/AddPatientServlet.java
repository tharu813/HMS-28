package servlet;

import model.Patient;
import service.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/AddPatientServlet")
public class AddPatientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String username = request.getParameter("username");
        String nic =request.getParameter("nic");
        String fname = request.getParameter("fname");
        String lname =request.getParameter("lname");
        String email =request.getParameter("email");
        String number = request.getParameter("number");
        int age =Integer.parseInt(request.getParameter("age"));
        Date dob=Date.valueOf(request.getParameter("dob"));
        int house =Integer.parseInt(request.getParameter("house"));
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String registered_by=request.getParameter("reg_by");

        Patient patient = new Patient();
        patient.setUserId(userID);
        patient.setUsername(username);
        patient.setNic(nic);
        patient.setFirstName(fname);
        patient.setLastName(lname);
        patient.setEmail(email);
        patient.setContactNo(number);
        patient.setAge(age);
        patient.setDob(dob);
        patient.setHouse_no(house);
        patient.setStreet(street);
        patient.setCity(city);
        patient.setRegistered_by(registered_by);

        AdminService service = new AdminService();
        service.addPatient(patient);

        RequestDispatcher dis = request.getRequestDispatcher("admin_dashboard.jsp");
        dis.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
