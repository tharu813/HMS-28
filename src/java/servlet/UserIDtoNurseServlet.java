package servlet;

import model.User;
import service.LoadingServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserIDtoNurseServlet")
public class UserIDtoNurseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    LoadingServices load;

    public void init() {
        this.load = new LoadingServices ();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            User user = load.getUserId();

            request.setAttribute("user",user);

            RequestDispatcher dis = request.getRequestDispatcher("Nurse_reg.jsp");
            dis.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
