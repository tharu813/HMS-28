<%@ page import="controller.appoinmentService" %>
<%@ page import="model.appoinment" %>
<%@ page import="java.util.List" %>
<%@ page import="controller.appoinmentService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/table.css">

</head>
<style>
    body{
        font-family: 'Open Sans', sans-serif;
        font-weight: 400;
        line-height: 1.6;
        

        background-size: cover;
        background-repeat:round;
        min-height: 100vh;
    }

    h1 {
        font-family: Monospace;
        font-weight: bold;
        font-size: 29px;
        line-height: 1.7em;
        margin-bottom: 8px;
        text-align: center;
    }
    #wrapper {
        display: block;
        width:950px;
        background: #fff;
        margin: 0 auto;
        padding: 10px 17px;
        -webkit-box-shadow: 2px 2px 3px -1px rgba(0,0,0,0.35);
    }

    #keywords {
        margin: 0 auto;
        font-size: 1.2em;
        margin-bottom: 10px;
    }


    #keywords thead {
        cursor: pointer;
        background: #4da6ff;
    }
    #keywords thead tr th {
        font-weight: bold;
        padding: 12px 29px;
        padding-left: 30px;
        font-size:19px;
        font-family:Monospace;


    }
    #keywords thead tr th span {
        padding-right: 30px;
        background-repeat: no-repeat;
        background-position: 100% 100%;
        align:right;
    }

    #keywords thead tr th.headerSortUp, #keywords thead tr th.headerSortDown {
        background: #acc8dd;
        color:white;
    }




    #keywords tbody tr {
        color: #555;
    }
    #keywords tbody tr td {
        text-align:center;
        padding: 10px 7px;
        font-size:15px;
        font-family:Monospace;
    }
    #keywords tbody tr td.align {
        text-align: left;
    }
</style>
<body>
<ul>
    <li><a href="LandingPage.jsp">Home</a></li>


</ul>
<center><h1>ALL APPOINMENTS</h1></center>
<section class="details">
    <div class="card">
        <body>


        <div id="wrapper">

            <hr>



            <br>
            <%
                appoinmentService app = new  appoinmentService();

                List<appoinment> list= app.selectAllAppoinment(); %>
            <table id="keywords" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th><span>appoinmentId</span></th>
                    <th><span>date</span></th>
                    <th><span>time</span></th>
                    <th><span>patientID</span></th>
                    <th><span>doctorID</span></th>
                    <th><span>State</span></th>



                </tr>
                </thead>
                <tbody>
                <!-- table data -->
                <%for(appoinment i:list){ %>

                <tr>
                    <td>
                        <%=i.getAppointmentID() %>
                    </td>
                    <td>
                        <%=i.getDate() %>
                    </td>
                    <td>
                        <%=i.getTime() %>
                    </td>
                    <td>
                        <%=i.getPatientID() %>
                    </td>
                    <td>
                        <%=i.getDoctorID() %>
                    </td>
                    <td>
                        <%=i.getState() %>
                    </td>



                </tr>
                <%} %>

                </tbody>

            </table>
        </div>

<br>

</body>
</html>