/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DBHandler;
import model.MedicalRecord;
import model.Patient;

/**
 *
 * @author THARUSHI
 */
public class UpdateEMRServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateEMRServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateEMRServlet at " + request.getContextPath() + "</h1>");
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
        String patientID = patient.getUserId();
        System.out.println(patientID);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String bp_level = request.getParameter("bp_level");
        int weight = Integer.parseInt(request.getParameter("weight"));
        int height = Integer.parseInt(request.getParameter("height"));
        String allergies = request.getParameter("allergies");
        String diagnosis = request.getParameter("diagnosis");
        String medication = request.getParameter("medication");
        

        try {
            DBHandler dbObj = new DBHandler();

            MedicalRecord emr = (MedicalRecord) RequestHandler.fetchAttribute(request, "medical_record");
            emr.setBp_level(bp_level);
            emr.setWeight(weight);
            emr.setHeight(height);
            emr.setAllergies(allergies);
            emr.setDiagnosis(diagnosis);
            emr.setMedication(medication);
            emr.setPatient_id(medication);

            int status = dbObj.updateEMR(patientID, emr);
            if (status > 0) {
                //out.println("<h1><center>Medical Record was updated Successfully!</h1>");
                RequestDispatcher req = request.getRequestDispatcher("doctor-viewPatient.jsp");
                req.include(request, response);
            } else {
                out.println("Something has gone wrong. Record was not updated");
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
