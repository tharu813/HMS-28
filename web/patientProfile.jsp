<%-- 
    Document   : patientProfile
    Created on : Apr 28, 2021, 12:21:07 PM
    Author     : Dilu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="bootstrap-4.6.0-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="hmscustom.css">

        <script src="bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>

        <title>Doctor</title>
        <style>
            form {
  text-align: center;
}

 h2 {
        font-family: Monospace;
        font-weight: bold;
        font-size: 29px;
        line-height: 1.7em;
        margin-bottom: 8px;
        color: blue;
        
        margin-right: 50;
    }
    body{
    position:relative;
    top:30px;
    height:700px;
    width:800px;
    margin-left:auto;
    margin-right:50;
    background: transparent;
}

            
        </style>
    </head>

    
    <body>
        <div id="prescriptions">
                <div class="row">
                    <div class="col-10">
                        <h2>Create Patient Profile</h2>
                    </div>
                    
             <form method="post" action="./createProfile" >
            User Name:<input type="text" name="username" /><br/><br/>
            NIC Number:<input type="text" name="nic" /><br/><br/>
            First Name:<input type="text" name="firstName" /><br/><br/>
            Last Name:<input type="text" name="lastName" /><br/><br/>
            Email:<input type="email" name="email" /><br/><br/>
            Password:<input type="password" name="password"/><br/><br/>
            Contact Number:<input type="text" name="contactNo"/><br/><br/>
            Age:<input type="number" name="age"/><br/><br/>
            Date of Birth:<input type="date" name="dob"/><br/><br/>
            House Number:<input type="number" name="house_no"/><br/><br/>
            Street:<input type="text" name="street"/><br/><br/>
            City:<input type="text" name="city"/><br/><br/>
            
            
            <input type="submit" value="Register new patient"/>
                </div>
        </div>
</form>

    </body>
</html>
