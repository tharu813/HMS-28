<%-- 
    Document   : Login
    Created on : Apr 26, 2021, 8:04:27 PM
    Author     : THARUSHI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <form method="POST" action="LoginServlet">
                <label>Username :</label>
                <input type ="text" name ="username"/><br>
                <label>Password :</label>
                <input type ="password" name ="password"/><br>
                <input type ="submit" value ="Login"/>
            </form>
        </div>
    </body>
</html>