<%-- 
    Document   : updatePatient
    Created on : Apr 27, 2021, 9:12:56 PM
    Author     : Dilu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <h2> Update  Patient Profile </h2>
        <form method="post" action="./updateProfile">
            User Name:<input type="text" name="username" /><br/>
            NIC Number:<input type="text" name="nic" /><br/><br/>
            First Name:<input type="text" name="firstName" /><br/><br/>
            Last Name:<input type="text" name="lastName" /><br/><br/>
            Email:<input type="email" name="email" /><br/><br/>
            Password:<input type="password" name="password"/><br/><br/>
            
            
            <input type="submit" value="Update Patient Profile"/>
    </body>
</html>
