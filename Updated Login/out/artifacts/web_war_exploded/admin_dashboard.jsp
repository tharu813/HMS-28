<%--
  Created by IntelliJ IDEA.
  User: Kavindu Balasooriya
  Date: 4/27/2021
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="styles/admin_dashboard.css" type="text/css">
<header>
    <div class="logo">Admin<span>Panel</span></div>
</header>
<div class="nav-btn">Menu</div>
<div class="container">

    <div class="sidebar">
        <nav>
            <a href="#">Admin<span>Panel</span></a>
            <ul>
                <li class="active"><a href="#">Dashboard</a></li>
                <li><a href="<%=request.getContextPath()%>/AddConsultationInfoServlet">Consultation</a></li>
            </ul>
        </nav>
    </div>

    <div class="main-content">
        <h1>Dashboard</h1>
        <p>Here you can add staff members!</p>
        <div class="panel-wrapper">
            <div class="panel-head">
                <li> <a href="<%=request.getContextPath()%>/UserIDtoDoctorServlet">Doctor registation</a></li>
            </div>
            <div class="panel-body">
               <h2>Doctor registation form</h2><br>
            </div>
        </div>
        <div class="panel-wrapper">
            <div class="panel-head">
                <li><a href="<%=request.getContextPath()%>/UserIDtoNurseServlet">Nurse registation</a></li>
            </div>
            <div class="panel-body">
                <h2>Nurse registation form</h2><br>
            </div>
        </div>
        <div class="panel-wrapper">
            <div class="panel-head">
                <li><a href="<%=request.getContextPath()%>/UserIDtoLabServlet">Laboratory registation</a></li>
            </div>
            <div class="panel-body">
                <h2>Laborotary Technician registation form</h2><br>
            </div>
        </div>
        <div class="panel-wrapper">
            <div class="panel-head">
                <li><a href="<%=request.getContextPath()%>/UserIDtoCashierServlet">Cashier registation</a></li>
            </div>
            <div class="panel-body">
                <h2>Cashier registation form</h2><br>
            </div>
        </div>
        <div class="panel-wrapper">
            <div class="panel-head">
                <li><a href="<%=request.getContextPath()%>/UserIDtoReceptionistServlet">Receptionist registation</a></li>
            </div>
            <div class="panel-body">
                <h2>Receptionist registation form</h2><br>
            </div>
        </div>
    </div>
</div>