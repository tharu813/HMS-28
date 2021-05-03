package servlet;

import model.Doctor;
import service.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddDoctorServlet")
public class AddDoctorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String username = request.getParameter("username");
        String nic =request.getParameter("nic");
        String fname = request.getParameter("fname");
        String lname =request.getParameter("lname");
        String email =request.getParameter("email");
        String number = request.getParameter("number");
        String title =request.getParameter("title");
        String department =request.getParameter("department");
        int type=Integer.parseInt(request.getParameter("type"));
        String special = request.getParameter("spec");
        int slmc=Integer.parseInt(request.getParameter("slmc"));

        Doctor doc = new Doctor();
        doc.setUserId(userID);
        doc.setUsername(username);
        doc.setNic(nic);
        doc.setFirstName(fname);
        doc.setLastName(lname);
        doc.setEmail(email);
        doc.setContactNo(number);
        doc.setTitle(title);
        doc.setDepartment(department);
        doc.setUserType(type);
        doc.setSpecialization(special);
        doc.setSlmc(slmc);

        AdminService service = new AdminService();
        service.addDoctor(doc);

        RequestDispatcher dis = request.getRequestDispatcher("admin_dashboard.jsp");
        dis.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
