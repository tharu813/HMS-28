<%-- 
    Document   : recep-viewPatient
    Created on : Apr 27, 2021, 3:19:15 PM
    Author     : Dilu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div id="patientInfo" style="margin-left: 1%; margin-right: 1%;">

        <div id="patientProfile">
            <div class="row">
                <div class="col">
                    <h2>Patient: ${patient.getFirstName()}</h2>
                </div>
            </div>
            <div class="row">
                
                <table border="1" width="100%">
                    <tr>
                        <th>DOB</th> <th>Address</th> <th>Age</th> <th>E-mail</th> <th>Update</th>
                    </tr>
                    <tr>
                        <td>${patient.getDob()}</td>
                        <td>${patient.getHouse_no()},${patient.getStreet()},${patient.getCity()}</td>
                        <td>${patient.getAge()}</td>
                        <td>${patient.getEmail()}</td>
                        <td><a href="updatePatientServlet?id=${patient.getUserId()}" > Update </a></td>  
                    </tr>
                </table>
               
                
                <ul style="list-style-type: none;">
                    <li id="patientDOB">DOB: ${patient.getDob()}</li>
                    <li id="address">Address: ${patient.getHouse_no()}, ${patient.getStreet()}, ${patient.getCity()}</li>
                    <li id="age">Age: ${patient.getAge()}</li>
                    <li id="email">Email: ${patient.getEmail()}</li>
                    <!--li id="patientGender">Gender: M</li-->
                </ul>
            </div>
        </div>
    </body>
</html>
