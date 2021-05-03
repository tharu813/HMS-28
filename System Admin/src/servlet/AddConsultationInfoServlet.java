package servlet;

import model.Cashier;
import model.Consultation_info;
import service.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet("/AddConsultationInfoServlet")
public class AddConsultationInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fee =Integer.parseInt(request.getParameter("fee"));
        Time time =Time.valueOf(request.getParameter("time"));
        Date date = Date.valueOf(request.getParameter("date"));

        Consultation_info consultation_info = new Consultation_info();
        consultation_info.setFee(fee);
        consultation_info.setTime(time);
        consultation_info.setDate(date);


        AdminService service = new AdminService();
        service.addConsultation_info(consultation_info);

        RequestDispatcher dis = request.getRequestDispatcher("admin_dashboard.jsp");
        dis.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
