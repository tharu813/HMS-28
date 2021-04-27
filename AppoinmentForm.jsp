<%@ page import="model.appoinment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection"%>
<%@ page import="service.appoinmentService" %>
<%@ page import="service.doctorAvailability" %>
<%@ page import="java.sql.Date" %>

<!DOCTYPE html>
<html>
<head>
    <title>Validate Login & Register Forms Flat Responsive Widget Template :: w3layouts</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content="Validate Login & Register Forms Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />

    <!-- Meta tag Keywords -->

    <!-- css files -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <!-- Style-CSS -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- Font-Awesome-Icons-CSS -->
    <!-- //css files -->
    <!-- web-fonts -->
    <link href="//fonts.googleapis.com/css?family=Magra:400,700&amp;subset=latin-ext" rel="stylesheet">
    <!-- //web-fonts -->
    <style>

body{

}

        table { border-collapse: collapse; border-spacing: 0; }


        h1 {
            font-family: Monospace;
            font-weight: bold;
            font-size: 29px;
            line-height: 1.7em;
            margin-bottom: 8px;
            text-align: center;
        }


        /** page structure **/
        #wrapper {
            display: block;
            width: 850px;
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

        .amount{
            font-size:20px;
            color:#0269A4;
            font-weight:bold;
            font-family:Monospace;
        }

        .box{
            background-color:#fff;
            border-radius:5px;
            box-shadow:0 2px 5px rgba(0,0,0,0.3);
            margin: 0 auto;
            width:400px;
            max-width:100%;

        }
        .form{
            padding:30px 40px;

        }
        .header{
            text-align: center;
            color:cornflowerblue;
            font-size: 25px;
            font-family: inherit;
        }
        .form-control{
            margin-bottom:10px;
            padding-bottom:20px;
            position:relative;
        }
        .form-control label{
            display:inline-block;
            margin-bottom:5px;
            font-family: inherit;
            color:lightslategray;
            font-size:12px;

        }
        .form-control input{
            border:2px solid #f0f0f0;
            border-radius: 4px;
            display:block;
            padding:10px;
            width:100%;
            font-size: 14px;
            font-family: inherit;

        }
        .form-control input:focus{
            outline:0;
            border-color: #777;
        }
        .form-control.success input{
            border-color:#2ecc71;


        }
        .form-control.error input{
            border-color:#e74c3c;


        }
        .form-control i{
            visibility: hidden;
            position: absolute;
            top:40px;
            right:10px;
        }
        .form-control.success i.fa-check-circle{

            color:#2ecc71;
            visibility: visible;
        }
        .form-control.error i.fa-exclamation-circle{

            color:#e74c3c;
            visibility: visible;
        }
        .form-control small{
            color:#2ecc71;

            position: absolute;
            bottom: 0;
            left:0;
            visibility: hidden;
        }
        .form-control.error small{
            visibility: visible;
            color:#e74c3c;
        }
        .form button{
            background-color: #006699;
            border: 2px solid #006699;
            border-radius:4px ;
            color:#fff;
            display:block;
            padding:10px;
            font-size: 16px;
            width:320px;

        }
        /* //responsive */
    </style>
</head>
<body>

<div id="wrapper">

    <h1>Available Doctors</h1>

    <%
        doctorAvailability da = new  doctorAvailability();

        Date date = Date.valueOf(request.getParameter("date"));
        String first_name = request.getParameter("first_name");
        List<appoinment> list1 = da.checkAvailability(first_name,date);%>

    <table id="keywords" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th><span>first name</span></th>
            <th ><span>last name</span></th>
            <th ><span>Doctor Id</span></th>

        </tr>
        </thead>
        <tbody>
        <%for(appoinment i:list1){ %>
        <tr>


            <td><%=i.getFirst_name() %></td>
            <td><%=i.getLast_name() %></td>
            <td><%=i.getDoctorID() %></td>

        </tr>
      <% } %>




        </tbody>


    </table>
</div>

<div class="box">
    <form method="post" class="form" id="form" action="<%=request.getContextPath()%>/AddAppoinmentServlet" >


        <%--@declare id="vehicleregino"--%><%--@declare id="customername"--%><%--@declare id="estimateamount"--%>
        <%--@declare id="cash"--%><%--@declare id="paymentdate"--%>

        <div class="header">Make appoinment</div>

        <br>
        <input type ="hidden" name="payId">
        <div class="form-control" id="form-container">
            <label >Appoinment date</label>
            <input type="date" name="date">

        </div>


        <div class="form-control" id="form-container2">
            <label>Appoinment time</label>
            <input type="text" name="time">

        </div>

        <div class="form-control" id="form-container3">
            <label>Doctor ID</label>
            <input type="text"   name="doctorID" id="cash"  >

        </div>



        <div class="form-control" id="form-container4">
            <label>patient ID</label>
            <input type="text"  name="patientID"  >

        </div>
            <div class="form-control" id="form-container4">
                <label>State of the appoinment</label>
                <input type="text"  name="state" >

            </div>










        <button type="submit">submit</button>
    </form>

</div>

</div>

</div>
</div>
<script src="financial_script/addpayment.js"></script>
</body>
</html>

