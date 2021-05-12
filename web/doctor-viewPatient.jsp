<%-- 
    Document   : doctor-viewPatient
    Created on : Apr 26, 2021, 7:34:52 PM
    Author     : THARUSHI
--%>

<%@page import="controller.RequestHandler"%>
<%@page import="model.MedicalRecord"%>
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
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top" id="NavigationBar">
            <div class="navbar-brand" style="margin-left: 3%; margin-right: 3%;">
                <span id="doctorFullName">${user.getFirstName()} ${user.getLastName()}</span>
                <span id="doctorTitle"> - ${ user.getTitle() }</span>
            </div>
            <ul class="navbar-nav"
                <li class="nav-item">
                    <a class="nav-link" href="#prescriptions">Prescriptions</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#labrequest">Request Lab Test</a>
                </li>            
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="Logout" style="background-color: #b22222; border-radius: 5%; color: white;">Log out</a>
                </li>
            </ul>

        </nav>

        <div id="patientInfo" >

            <div id="patientProfile">
                <div class="row" id="headingdiv">
                    <div class="col">
                        <h2 id="profileheading"><center>Patient Profile</center></h2>
                    </div>
                </div>


                <div class="row" id="patientName">
                    <div class="col">
                        <h4>Patient's Name: ${patient.getFirstName()} </h4>
                    </div>
                </div>
                <div class="row" id = "patientdata">
                    <ul style="list-style-type: none;">
                        <li id="patientDOB">DOB: ${patient.getDob()}</li>
                        <li id="address">Address: ${patient.getHouse_no()}, ${patient.getHouse_no()}, ${patient.getStreet()}, ${patient.getCity()}</li>
                        <li id="age">Age: ${patient.getAge()}</li>
                        <li id="email">Email: ${patient.getEmail()}</li>
                    </ul>
                </div>
                <hr>

                <% MedicalRecord medRec = (MedicalRecord) RequestHandler.fetchAttribute(request, "medical_record"); %>
                <% if (medRec != null) {%>

                <div class="row" id="headingdiv">
                    <div class="col">
                        <h3 id="EMRheading"><center>Medical Record</center></h3>
                    </div>
                </div>

                <div class="row" id = "EMRdata">
                    <ul style="list-style-type: none;">
                        <li id="bp_level">Blood Pressure level: <b> <%= medRec.getBp_level()%> mmHg </b></li>
                        <li id="weight">Weight: <b> <%= medRec.getWeight()%> </b></li>
                        <li id="height">Height: <b> <%= medRec.getHeight()%> </b></li>
                        <li id="allergies">Allergies: <b> <%= medRec.getAllergies()%> </b></li>
                        <li id="diagnosis">Diagnosis: <b> <%= medRec.getDiagnosis()%> </b></li>
                        <li id="medication">Previously Recommended Medications: <b> <%= medRec.getMedication()%> </b></li>
                        <li style="margin-top: 1%;"><button type="button" onClick="document.getElementById('updateMedicalRecord').style.display = 'block';"
                                                            class="btn btn-secondary">Update
                            </button></li>
                    </ul>

                </div>


            </div>

            <% } else { %>
        </div>
        <div id="addMedicalRecord">
            <div class="row">
                <div class="col-10">
                    <h2>Add Medical Record</h2>
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

        <% }%>
        <% if (medRec != null) {%>
        <div id="updateMedicalRecord" style="display: none;">
            <div class="row">
                <div class="col-10">
                    <h2>Update Medical Record</h2>
                </div>
            </div>
            <div class="row">
                <form action = "UpdateEMRServlet" method = "POST">
                    <table>
                        <tr><td>Blood Pressure Level (mmHg): </td><td><input type="text" name = "bp_level" value="<%= medRec.getBp_level()%>"/></td></tr>
                        <tr><td>Weight (kg): </td><td><input type="text" name = "weight" value="<%= medRec.getWeight()%>"/></td></tr>
                        <tr><td>Height(cm): </td><td><input type="text" name = "height" value="<%= medRec.getHeight()%>"/></td></tr>
                        <tr><td>Allergies: </td><td><input type="text" name = "allergies" value="<%= medRec.getAllergies()%>"/></td></tr>
                        <tr><td>Diagnosis: </td><td><input type="text" name = "diagnosis" value="<%= medRec.getDiagnosis()%>"/></td></tr>
                        <tr><td>Medication: </td><td><input type="text" name = "medication" value="<%= medRec.getMedication()%>"/></td></tr>  
                        <tr><td><input type="submit" name="Add Record" value="Update Record" class="btn btn-secondary"></td></tr>

                    </table>

                </form>

            </div>
        </div>
        <% }%>
        <hr>

        <div id="prescriptions">
            <div class="row">
                <div class="col-10">
                    <h2>Prescription</h2>
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

        <hr>

        <div id="labrequest">
            <div class="row">
                <div class="col-10">
                    <h2>Request Lab Tests</h2>
                </div>
            </div>
            <div class="row">
                <form action = "RequestLabTestServlet" method = "POST">
                    <table>
                        <tr><td>Test to be done: </td><td><input type="text" name = "test_request"/></td></tr>
                        <tr><td><input type="submit" name="Request Test" value="Request Test" class="btn btn-secondary"></td></tr>

                    </table>

                </form>

            </div>
        </div>

    </div>
</body>

</html>