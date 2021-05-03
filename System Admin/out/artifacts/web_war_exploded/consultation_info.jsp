<%--
  Created by IntelliJ IDEA.
  User: Kavindu Balasooriya
  Date: 4/27/2021
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="//db.onlinewebfonts.com/c/a4e256ed67403c6ad5d43937ed48a77b?family=Core+Sans+N+W01+35+Light" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="styles/form.css" type="text/css">
<div class="body-content">
    <div class="module">
        <h1>Consultation Info</h1>
        <form class="form" action="<%=request.getContextPath()%>/AddConsultationInfoServlet" method="post" enctype="multipart/form-data" autocomplete="off">
            <div class="alert alert-error"></div>


            <input type="text" placeholder="fee" name="fee"  required />
            <input type="time" placeholder="time" name="time" required />
            <input type="date" name="date" placeholder="date" required/>

            <input type="submit" value="Register" name="register" class="btn btn-block btn-primary" />
        </form>
    </div>
</div>
