/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DBHandler;
import model.MedicalRecord;
import model.Patient;
import model.Prescription;

/**
 *
 * @author THARUSHI
 */
public class AddPrescriptionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddPrescriptionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddPrescriptionServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         Patient patient = (Patient) RequestHandler.fetchAttribute(request, "patient");
         String doctorID = RequestHandler.getCurrentUser(request).getUserId();
         
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String diagnosis = request.getParameter("diagnosis");
        String reason = request.getParameter("reason");
        String further_treatment = request.getParameter("further_treatment");
        
        int numOfDrugs = Integer.parseInt(request.getParameter("numOfLines"));
        ArrayList<String> drugList = new ArrayList<>();
        String drug = "";

        for (int n = 0; n < numOfDrugs; n++){
            String drugText = request.getParameter("drug"+(n+1));
            String doseText = request.getParameter("dose"+(n+1));
            drug = drugText + ", " + doseText;
            drugList.add(drug);
        }

        try {
            DBHandler dbObj = new DBHandler();
            int presID = Integer.parseInt(dbObj.generateID("prescription"));

            Prescription pres = new Prescription(presID, diagnosis, reason, further_treatment, patient.getUserId(), doctorID);                   

            int status = dbObj.addPrescription(pres, drugList);
            if (status > 0) {
                out.println("<h1><center>Prescription uploaded successfully!</h1>");
                RequestDispatcher req = request.getRequestDispatcher("doctor-viewPatient.jsp");
                req.include(request, response);
            } else {
                out.println("Something went wrong. prescription was not uploaded");
            }

        } catch (NumberFormatException se) {
            System.out.print(se);
        } catch (Exception e) {
            System.out.print(e);
        }
        

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
