<%@ page import="service.PatientService" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/27/2021
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab Report</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="styles/viewMedicalReport.css">
</head>
<body background="img1.jpg">
<ul class="nav">
    <li class="nav_link"><a class="nav_a" href="viewPatientProfile.jsp">Profile</a></li>
    <li class="nav_link"><a class="nav_a" href="viewMedicalReport.jsp">Medical Report</a></li>
    <li class="nav_link"><a class="nav_a" href="viewPrescription.jsp">Prescription</a></li>
    <li class="nav_link"><a class="nav_a" href="viewLabReport.jsp">Lab Report</a></li>
</ul>
<br>
<div class="container">
    <div class="row">
        <%
            PatientService ps1 = new PatientService();


        %>
        <div class="col-md-7 ">

            <div class="panel panel-default">
                <div class="panel-heading"><h4>Lab Report</h4></div>
                <div class="panel-body">

                    <div class="box box-info">

                        <div class="box-body">


                            <br>

                            <div class="col-sm-5 col-xs-6 tital ">Reference ID:</div>
                            <div class="col-sm-7 col-xs-6 " name="ref_id"><%=request.getAttribute("ref_id")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Patient ID:</div>
                            <div class="col-sm-7" name="patient_id"><%=request.getAttribute("patient_id")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Doctor ID:</div>
                            <div class="col-sm-7" name="doctor_id"> <%=request.getAttribute("doctor_id")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Date:</div>
                            <div class="col-sm-7" name="date"><%=request.getAttribute("date")%></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Requested Test:</div>
                            <div class="col-sm-7" name="test_requested"><%=request.getAttribute("test_requested")%></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Result:</div>
                            <div class="col-sm-7" name="result"><%=request.getAttribute("result")%></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">State:</div>
                            <div class="col-sm-7 col-xs-6 " name="state"><%=request.getAttribute("state")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->

                    </div>


                </div>
            </div>
        </div>


    </div>
</div>
</body>
</html>
