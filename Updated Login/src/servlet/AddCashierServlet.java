package servlet;

import model.Cashier;
import model.Receptionist;
import service.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddCashierServlet")
public class AddCashierServlet extends HttpServlet {
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
       // int type=Integer.parseInt(request.getParameter("type"));


        Cashier cashier = new Cashier( );
        cashier.setUserId(userID);
        cashier.setUsername(username);
        cashier.setNic(nic);
        cashier.setFirstName(fname);
        cashier.setLastName(lname);
        cashier.setEmail(email);
        cashier.setContactNo(number);
        cashier.setTitle(title);
        cashier.setDepartment(department);
        //cashier.setUserType(type);


        AdminService service = new AdminService();
        service.addCashier(cashier);

        RequestDispatcher dis = request.getRequestDispatcher("admin_dashboard.jsp");
        dis.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
