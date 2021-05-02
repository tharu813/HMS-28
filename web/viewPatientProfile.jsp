<%@ page import="service.PatientService" %>
<%@ page import="model.Patient" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/27/2021
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="styles/viewPatieantProfile.css">
</head>
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
            PatientService ps = new PatientService();


     %>
        <div class="col-md-7 ">

            <div class="panel panel-default">
                <div class="panel-heading">  <h4 >User Profile</h4></div>
                <div class="panel-body">

                    <div class="box box-info">

                        <div class="box-body">
                            <div class="col-sm-6">
                                <div  align="center"> <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive">

                                    <input id="profile-image-upload" class="hidden" type="file">
                                    <div style="color:#999;" >click here to change profile image</div>
                                    <!--Upload Image Js And Css-->
                                </div>

                                <br>

                                <!-- /input-group -->
                            </div>
                            <div class="col-sm-6">
                                <h4 style="color:#00b1b1;"><%=request.getAttribute("firstName")%></h4></span>
                                <span><p><%=request.getAttribute("patient_id")%></p></span>
                            </div>
                            <div class="clearfix"></div>
                            <hr style="margin:5px 0 5px 0;">


                            <div class="col-sm-5 col-xs-6 tital " >First Name:</div><div class="col-sm-7 col-xs-6 " name="first_name"><%=request.getAttribute("firstName")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >Last Name:</div><div class="col-sm-7" name="last_name"><%=request.getAttribute("lastName")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >Age:</div><div class="col-sm-7" name="age"><%=request.getAttribute("age")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >Date Of Birth:</div><div class="col-sm-7" name="dob"><%=request.getAttribute("dob")%></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >NIC:</div><div class="col-sm-7" name="nic"><%=request.getAttribute("nic")%></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>


                            <div class="col-sm-5 col-xs-6 tital " >Email:</div><div class="col-sm-7" name="email"><%=request.getAttribute("email")%></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >Contact Number:</div><div class="col-sm-7" name="contact_no"><%=request.getAttribute("contact_no")%></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >House no:</div><div class="col-sm-7" name="house_no"><%=request.getAttribute("house_no")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >Street:</div><div class="col-sm-7" name="street"><%=request.getAttribute("street")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >City:</div><div class="col-sm-7" name="city"><%=request.getAttribute("city")%></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " >Registered Date:</div><div class="col-sm-7" name="registered_by"><%=request.getAttribute("registered_by")%></div>


                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->

                    </div>


                </div>
            </div>
        </div>
        <script>
            $(function() {
                $('#profile-image1').on('click', function() {
                    $('#profile-image-upload').click();
                });
            });
        </script>









    </div>
</div>

</body>
</html>
