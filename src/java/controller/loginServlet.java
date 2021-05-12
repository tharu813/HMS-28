package controller;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import model.DBHandler;
import model.Doctor;
import model.Nurse;
import model.Patient;
import model.Receptionist;
import model.StaffUser;

public class loginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        User u = new User();

        u.setUsername(userName);
        u.setPassword(password);

        DBHandler loginDao = new DBHandler();

        try {
            u = loginDao.login(u);
            int userType = u.getUserType();
            String landingPage = "login.jsp";
            if (userType >= 0) {
                switch (userType) {
                    case 0:
                        u = (StaffUser) u;
                        landingPage = "admin_dashboard.jsp";
                        break;
                    case 1:
                        u = (Doctor) u;
                        landingPage = "doctor-main.jsp";
                        break;
                    case 2:
                        u = (Receptionist) u;
                        landingPage = "receptionist-main.jsp";
                        break;
                    case 3:
                        u = (Nurse) u;
                        landingPage = "Nurse.jsp";
                        break;
                    case 4:
                        u = (StaffUser) u;
                        landingPage = "doctor-main.jsp";
                        break;
                    case 5:
                        u = (StaffUser) u;
                        landingPage = "doctor-main.jsp";
                        break;
                    case 6:
                        u = (Patient) u;
                        landingPage = "patientDashboard.jsp";
                        break;
                }
            }
            RequestHandler.addAttribute(request, "user", u);
            request.getRequestDispatcher(landingPage).forward(request, response);

        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
