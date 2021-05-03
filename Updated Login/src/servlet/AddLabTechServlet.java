package servlet;

import model.LabTechnician;
import model.Receptionist;
import service.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddLabTechServlet")
public class AddLabTechServlet extends HttpServlet {
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


        LabTechnician labTechnician = new LabTechnician( );
        labTechnician.setUserId(userID);
        labTechnician.setUsername(username);
        labTechnician.setNic(nic);
        labTechnician.setFirstName(fname);
        labTechnician.setLastName(lname);
        labTechnician.setEmail(email);
        labTechnician.setContactNo(number);
        labTechnician.setTitle(title);
        labTechnician.setDepartment(department);
        labTechnician.setUserType(type);


        AdminService service = new AdminService();
        service.addLabTechinician(labTechnician);

        RequestDispatcher dis = request.getRequestDispatcher("admin_dashboard.jsp");
        dis.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
