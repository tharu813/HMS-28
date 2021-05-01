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

        <script>
            function enableAddButton() {
                document.getElementById("addMoreDrugsBtn").disabled = false;
            }

            function addDrugLine() {
                var nextLineNum = parseInt(document.getElementById("idNumOfLines").value) + 1;
                console.log(nextLineNum);

                var container = document.getElementById("drugLines");
                
                var tr = document.createElement("tr");

                var td1 = document.createElement("td");
                var drugInput = document.createElement("input");
                drugInput.type = "text";
                drugInput.placeholder = "Drug";
                drugInput.name = "drug" + nextLineNum;
                
                td1.appendChild(drugInput);
                tr.appendChild(td1);
                
                var td2 = document.createElement("td");
                var doseInput = document.createElement("input");
                doseInput.type = "text";
                doseInput.placeholder = "Dose";
                doseInput.name = "dose" + nextLineNum;
                
                td2.appendChild(doseInput);
                tr.appendChild(td2);
                
                container.appendChild(tr);
                document.getElementById("idNumOfLines").value = nextLineNum;

            }
        </script>

        <title>Doctor</title>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top">
            <div class="navbar-brand">
                <span id="doctorFullName">${user.getFirstName()} ${user.getLastName()}</span>
                <span id="doctorTitle">${ user.getTitle() }</span>
            </div>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Appointments</a>
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
                </div>
                <div class="row">
                    <form action = "AddEMRServlet" method = "POST">
                        <table>
                            <tr><td>Blood Pressure Level (mmHg): </td><td><input type="text" name = "bp_level"/></td></tr>
                            <tr><td>Weight (kg): </td><td><input type="text" name = "weight"/></td></tr>
                            <tr><td>Height(cm): </td><td><input type="text" name = "height"/></td></tr>
                            <tr><td>Allergies: </td><td><input type="text" name = "allergies"/></td></tr>
                            <tr><td>Diagnosis: </td><td><input type="text" name = "diagnosis"/></td></tr>
                            <tr><td>Medication: </td><td><input type="text" name = "medication"/></td></tr>  
                            <tr><td><input type="submit" name="Add Record" value="Add Record" class="btn btn-secondary"></td></tr>

                        </table>

                    </form>

                </div>
            </div>

        

            <hr>

            <div id="prescriptions">
                <div class="row">
                    <div class="col-10">
                        <h2>Prescriptions</h2>
                    </div>
                </div>
                <div class="row">
                    <form action = "AddPrescriptionServlet" method = "POST">
                        <table  id="drugLines">
                            <tr><td>Diagnosis : </td><td><input type="text" name = "diagnosis"/></td></tr>
                            <tr><td>Reason: </td><td><input type="text" name = "reason"/></td></tr>
                            <tr><td>Further Treatment: </td><td><input type="text" name = "further_treatment"/></td></tr>
                            <tr>
                                <td>Drugs: </td>
                                <td><button type="button" disabled="true" id="addMoreDrugsBtn" onclick="addDrugLine();">Add More Drugs</button></td>
                            </tr>
                            <tr>
                            <input type="number" hidden="true" name="numOfLines" id="idNumOfLines" value="1"/>
                                <tr>
                                    <td>
                                        <input type="text" placeholder="Drug" name="drug1"/>
                                    </td>
                                    <td>
                                        <input type="text" placeholder="Dose" name="dose1" oninput="enableAddButton();"/>
                                    </td>
                                </tr>
                            </tr>
                            
                        </table>
                        <input type="submit" name="Add Prescription" value="Add Prescription" class="btn btn-secondary">
                    </form>
                </div>
            </div>

        </div>
    </body>

</html>