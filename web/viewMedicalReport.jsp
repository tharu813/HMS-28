<%@ page import="service.PatientService" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/27/2021
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medical Report</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="styles/viewMedicalReport.css">
</head>
<br>
<body>
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
                <div class="panel-heading">  <h4 >Medical Report</h4></div>
                <div class="panel-body">

                    <div class="box box-info">

                        <div class="box-body">
                            <div class="col-sm-5 col-xs-6 tital " >Patient ID:</div><div class="col-sm-7 col-xs-6 " name="patient_id"><%=request.getAttribute("patient_id")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >MRI ID:</div><div class="col-sm-7" name="emr_id"><%=request.getAttribute("emr_id")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >Blood Pressure Level:</div><div class="col-sm-7" name="bp_level"><%=request.getAttribute("bp_level")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >Height:</div><div class="col-sm-7" name="height"><%=request.getAttribute("height")%></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >Weight:</div><div class="col-sm-7" name="weight"><%=request.getAttribute("weight")%></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >Allergies:</div><div class="col-sm-7" name="allergies"><%=request.getAttribute("allergies")%></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>
                            <div class="col-sm-5 col-xs-6 tital " >Diagnosis:</div><div class="col-sm-7" name="diagnosis"><%=request.getAttribute("diagnosis")%></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>
                            <div class="col-sm-5 col-xs-6 tital " >Medication:</div><div class="col-sm-7" name="medication"><%=request.getAttribute("medication")%></div>

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
