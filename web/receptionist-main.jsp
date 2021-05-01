<%-- 
    Document   : receptionist-main
    Created on : Apr 27, 2021, 2:01:19 PM
    Author     : Dilu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="bootstrap-4.6.0-dist/css/bootstrap.min.css">
    <script src="bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top">
        <span class="navbar-brand" id="doctorFullName">${user.getFirstName()} ${user.getLastName()}</span>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="patientProfile.jsp">Patient Registration</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Account</a>
            </li>
        </ul>
        
        <form action="ViewPatientProf" class="form-inline" method="POST">
            <input type="text" class="form-control mr-sm-2" placeholder="Patient Username" name="PatientUsername">
            <button class="btn btn-success">Search</button>
            
            <input type="date" class="form-control mr-sm-2" name="availabilityDate">
            <button class="btn btn-success">View Availability</button>
        </form>
        </nav>
        
    <form action="ViewPatientProf" >
                <table border="1" width="75%">
                    <h2>Patient Details</h2>
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
            
</form>
                    
                    
                    <div id="updatePatient">
                <div class="row">
                    <div class="col-10">
                        <h2>Update patient Profile</h2>
                    </div>
                    
                </div>
                <div class="row">
                    <ul style="list-style-type: none;">
                    <form action = "./updateProfile" method = "POST">   
                    <table>
                    
                    <label for="blp">User Name:</label>
                        <input type="User Name:" class="form-control" id="inputbpl" aria-describedby="bpl" placeholder="Enter username" name = username"/>
                      
                    <label for="wit">NIC Number:</label>
                        <input type="NIC Number:" class="form-control" id="inputbpl" aria-describedby="wit" placeholder="Enter nic" name = "nic"/>   
                       
                    <label for="hit">First Name:</label>
                        <input type="First Name:" class="form-control" id="inputbpl" aria-describedby="hit" placeholder="Enter firstName" name = "firstName"/>   
                    
                    <label for="alp">Last Name :</label>
                        <input type="Last Name :" class="form-control" id="inputbpl" aria-describedby="alp" placeholder="Enter lastName" name = "lastName"/>   
                    
                    <label for="dia">E-mail :</label>
                        <input type="E-mail" class="form-control" id="inputbpl" aria-describedby="dia" placeholder="Enter email" name = "email"/>   
                    
                    <label for="Password">Medication:</label>
                        <input type="Password" class="form-control" id="inputbpl" aria-describedby="medi" placeholder="Enter password" name = "password"/>  
                        
                        <br>
                  <div class="container">
             <div class="row">
               <div class="col">
                <a href="#!" class="btn btn-primary btn-sm" input type="submit" name="Add Record" value="Add Record"  >Update Profile</a>
                     </div>
                        </div>
                        
                </form>    
                    </table>
                    </ul>

                </div>
            </div>

            <hr>
                   
        
       
            
            

    </body>
    <style>
     h1 {
            font-family: Monospace;
            font-weight: bold;
            font-size: 29px;
            line-height: 1.7em;
            margin-bottom: 8px;
            text-align: center;
        }
        
        table {
  width: 70%;
}

th {
  height: 70px;
}

th, td {
  padding: 15px;
}

th {
  background-color: #4CAF50;
  color: white;
}
        </style>
</html>
