<%-- 
    Document   : index
    Created on : Apr 25, 2021, 12:34:17 AM
    Author     : THARUSHI
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="controller.RequestHandler"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="bootstrap-4.6.0-dist/css/bootstrap.min.css">
        <script src="bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
        
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>

        <title>Doctor</title>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top">
            <span class="navbar-brand" id="doctorFullName">${user.getFirstName()} ${user.getLastName()}</span>
            <ul class="navbar-nav">
            </ul>
            <form action="ViewPatientProfileServlet" class="form-inline" method="POST">
                <input type="text" class="form-control mr-sm-2" placeholder="Patient Username" name="Patient Username">
                <button class="btn btn-success">Search</button>
            </form>
        </nav>

        <h1>My Appointments</h1>
        <% ArrayList<String[]> appointments = (ArrayList<String[]>) RequestHandler.fetchAttribute(request, "appointments"); %>
        <% if (appointments.size() > 0) { %>
        <table style="width: 50%;">
            <thead>
                <tr>
                    <th>Patient</th>
                    <th>Date</th>
                    <th>Time</th>
                </tr>
            </thead>
            <tbody>
                
                <% for (String[] appointment : appointments) { %>
                <tr>
                    <td><%=appointment[0]%></td>
                    <td><%=appointment[1]%></td>
                    <td><%=appointment[2]%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
            <% } else { %>
            <p>No Appointments</p>
            <% } %>
            
    </body>

</html>