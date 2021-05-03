<%--
  Created by IntelliJ IDEA.
  User: Kavindu Balasooriya
  Date: 4/27/2021
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<link href="//db.onlinewebfonts.com/c/a4e256ed67403c6ad5d43937ed48a77b?family=Core+Sans+N+W01+35+Light" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="styles/form.css" type="text/css">
<div class="body-content">
    <div class="module">
        <h1>Receptionist</h1>
        <form class="form" action="form.php" method="post" enctype="multipart/form-data" autocomplete="off">
            <div class="alert alert-error"></div>
            <input type="text" placeholder="User Name" name="userID" required />
            <input type="text" name="nic" placeholder="nic" required/>
            <input type="text" placeholder="First Name" name="fname" required />
            <input type="text" placeholder="Last Name" name="lname" required />
            <input type="email" placeholder="Email" name="email" required />
            <input type="text" placeholder="contact number" name="number" required />
            <input type="text" placeholder="Title" name="title" />
            <input type="text" placeholder="Department" name="department"  required />
            <input type="text" placeholder="User type" name="type"  required />
            <input type="password" placeholder="Password" name="password"  required />

            <input type="submit" value="Register" name="register" class="btn btn-block btn-primary" />
        </form>
    </div>
</div>
