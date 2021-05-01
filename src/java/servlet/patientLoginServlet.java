package servlet;

import service.patientLoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/patientLoginServlet")
public class patientLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        String password = request.getParameter("password");


        patientLoginService ploginService =new  patientLoginService();


        if(ploginService.login(user_id,password)) {
            HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("user_id", user_id); //setting session attribute

            RequestDispatcher dis = request.getRequestDispatcher("patientDashboard.jsp");
            dis.forward(request, response);
        }
        else{
            RequestDispatcher dis = request.getRequestDispatcher("");
            dis.forward(request,response);
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
