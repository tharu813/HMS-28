package servlet;

import model.Doctor;
import model.Receptionist;
import service.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddReceptionistServlet")
public class AddReceptionistServlet extends HttpServlet {
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


        Receptionist rep = new Receptionist( );
        rep.setUserId(userID);
        rep.setUsername(username);
        rep.setNic(nic);
        rep.setFirstName(fname);
        rep.setLastName(lname);
        rep.setEmail(email);
        rep.setContactNo(number);
        rep.setTitle(title);
        rep.setDepartment(department);
        rep.setUserType(type);


        AdminService service = new AdminService();
        service.addReceptionist(rep);

        RequestDispatcher dis = request.getRequestDispatcher("admin_dashboard.jsp");
        dis.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
