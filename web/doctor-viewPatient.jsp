<%-- 
    Document   : doctor-viewPatient
    Created on : Apr 26, 2021, 7:34:52 PM
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

        <title>Doctor</title>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top">
            <div class="navbar-brand">
                <span id="doctorFullName">${user.getFirstName()} ${user.getLastName()}</span>
                <span id="doctorTitle">(Psychiatrist)</span>
            </div>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Appointments</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">My Account</a>
                </li>
            </ul>
        </nav>

        <div id="patientInfo" style="margin-left: 1%; margin-right: 1%;">

            <div id="patientProfile">
                <div class="row">
                    <div class="col">
                        <h2>Patient: ${patient.getFirstName()}</h2>
                    </div>
                </div>
                <div class="row">
                    <ul style="list-style-type: none;">
                        <li id="patientDOB">DOB: ${patient.getDob()}</li>
                        <li id="address">Address: ${patient.getHouse_no()}, ${patient.getHouse_no()}, ${patient.getStreet()}, ${patient.getCity()}</li>
                        <li id="age">DOB: ${patient.getAge()}</li>
                        <li id="email">Email: ${patient.getEmail()}</li>
                        <!--li id="patientGender">Gender: M</li-->
                    </ul>
                </div>
            </div>

            <hr>

            <div id="medialRecords">
                <div class="row">
                    <div class="col-10">
                        <h2>Medical Records</h2>
                    </div>
                    <div class="col-2 doc-viewPat-button"><a href="">Add Record</a></div>
                </div>
                <div class="row">
                    <ul style="list-style-type: none;">
                    <form action = "AddEMRServlet" method = "POST">           
<!--                            <tr><td><input type="submit" name="Add Record" value="Add Record"></td></tr>-->
                    <table>
                        
                        
                    <label for="blp">Blood Pressure Level:</label>
                        <input type="bloodpressure" class="form-control" id="inputbpl" aria-describedby="bpl" placeholder="Enter Blood Pressure Level">
                      
                    
                    <label for="blp">Weight:</label>
                        <input type="weight" class="form-control" id="inputbpl" aria-describedby="wit" placeholder="Enter Weight">   
                       
                    <label for="blp">Height:</label>
                        <input type="weight" class="form-control" id="inputbpl" aria-describedby="wit" placeholder="Enter Weight">   
                    
                    <label for="blp">Allergies:</label>
                        <input type="weight" class="form-control" id="inputbpl" aria-describedby="wit" placeholder="Enter Weight">   
                    
                    <label for="blp">Diagnosis:</label>
                        <input type="weight" class="form-control" id="inputbpl" aria-describedby="wit" placeholder="Enter Weight">   
                    
                    <label for="blp">Medication:</label>
                        <input type="weight" class="form-control" id="inputbpl" aria-describedby="wit" placeholder="Enter Weight">                    
                
                        
                    </form>
                    </table>
                    </ul>

                </div>
            </div>

            <hr>

            <div id="labReports">
                <div class="row">
                    <div class="col-10">
                        <h2>Lab Reports</h2>
                    </div>
                    <div class="col-2 doc-viewPat-button"><a href="">Request New Report</a></div>
                </div>
                <div class="row">
                </div>
            </div>

            <hr>

            <div id="prescriptions">
                <div class="row">
                    <div class="col-10">
                        <h2>Prescriptions</h2>
                    </div>
                    <div class="col-2 doc-viewPat-button"><a href="">Add Prescription</a></div>
                </div>
                <div class="row">
                    <tr><td>Blood Pressure Level : </td><td><input type="text" name = "bp_level"/></td></tr>
                            <tr><td>Weight: </td><td><input type="text" name = "weight"/></td></tr>
                            <tr><td>Height: </td><td><input type="text" name = "height"/></td></tr>
                            <tr><td>Allergies: </td><td><input type="text" name = "allergies"/></td></tr>
                            <tr><td>Diagnosis: </td><td><input type="text" name = "diagnosis"/></td></tr>
                            <tr><td>Medication: </td><td><input type="text" name = "medication"/></td></tr>  
                            <tr><td><input type="submit" name="Add Record" value="Add Record"></td></tr>
                </div>
            </div>

        </div>
    </body>

</html>