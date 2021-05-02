<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/27/2021
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="styles/dashboard.css" type="text/css">

</head>
<body>
<div class="nav-btn">Menu</div>
<div class="container">

    <div class="sidebar">
        <nav>
            <a href="#">Patient<span>Panel</span></a>
            <ul>
                <li class="active"><a href="#">Dashboard</a></li>
                <li><a href="<%=request.getContextPath()%>/dashboardServlet">view profile</a></li>
            </ul>
        </nav>
    </div>

    <div class="main-content">
        <h1>Dashboard</h1>
        <p>stay happy stay safe</p>
        <div class="panel-wrapper">
            <div class="panel-head">
                <li> <a href="viewLabReport.jsp">Lab Report</a></li>
            </div>
            <div class="panel-body">
                <h2>View Lab Report</h2><br>
            </div>
        </div>
        <div class="panel-wrapper">
            <div class="panel-head">
                <li><a href="viewMedicalReport.jsp">Medical Report</a></li>
            </div>
            <div class="panel-body">
                <h2>View Medical Report</h2><br>
            </div>
        </div>
        <div class="panel-wrapper">
            <div class="panel-head">
                <li><a href="viewPrescription.jsp">Prescription</a></li>
            </div>
            <div class="panel-body">
                <h2>View Prescription</h2><br>
            </div>
        </div>

    </div>
</div>
</body>
</html>
