<%-- 
    Document   : index
    Created on : Apr 25, 2021, 12:34:17 AM
    Author     : THARUSHI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="bootstrap-4.6.0-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="hmscustom.css">
        <script src="bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
        <style>
            body{
                background-image: url("doc-main.jpg");
                background-repeat: no-repeat;
                background-size: cover;
                background-attachment: fixed;
                background-position: center;    
            }
        </style>

        <title>Doctor</title>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top">
            <span class="navbar-brand" id="doctorFullName">${user.getFirstName()} ${user.getLastName()}</span>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/DoctorViewAppointmentServlet">My Appointments</a>
                </li>
            </ul>
            <form action="ViewPatientProfileServlet" class="form-inline" method="POST">
                <input type="text" class="form-control mr-sm-2" placeholder="Patient Username" name="Patient Username">
                <button class="btn btn-success">Search</button>
            </form>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="Logout" style="background-color: #b22222; border-radius: 5%; color: white;">Log out</a>
                </li>
            </ul>
        </nav>
    </body>

</html>