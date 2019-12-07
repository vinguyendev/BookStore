<%--
  Created by IntelliJ IDEA.
  User: ViNguyen
  Date: 12/6/2019
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Online</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<%--    <link rel="stylesheet" href="styles.css" type="text/css">--%>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
        body{
            background-color: #1cbb9b;
        }
        .login-box{
            position:relative;
            margin: 200px auto;
            width: 500px;
            height: 400px;
            background-color: #fff;
            padding: 10px;
            border-radius: 3px;
            -webkit-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.33);
            -moz-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.33);
            box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.33);
        }
        .lb-header{
            position:relative;
            color: #00415d;
            margin: 5px 5px 10px 5px;
            padding-bottom:10px;
            border-bottom: 1px solid #eee;
            text-align:center;
            height:28px;
        }
        .lb-header a{
            margin: 0 25px;
            padding: 0 20px;
            text-decoration: none;
            color: #666;
            font-weight: bold;
            font-size: 15px;
            -webkit-transition: all 0.1s linear;
            -moz-transition: all 0.1s linear;
            transition: all 0.1s linear;
        }
        .lb-header .active{
            color: #029f5b;
            font-size: 18px;
        }
        .social-login{
            position:relative;
            float: left;
            width: 100%;
            height:auto;
            padding: 10px 0 15px 0;
            border-bottom: 1px solid #eee;
        }
        .social-login a{
            position:relative;
            float: left;
            width:calc(40% - 8px);
            text-decoration: none;
            color: #fff;
            border: 1px solid rgba(0,0,0,0.05);
            padding: 12px;
            border-radius: 2px;
            font-size: 12px;
            text-transform: uppercase;
            margin: 0 3%;
            text-align:center;
        }
        .social-login a i{
            position: relative;
            float: left;
            width: 20px;
            top: 2px;
        }
        .social-login a:first-child{
            background-color: #49639F;
        }
        .social-login a:last-child{
            background-color: #DF4A32;
        }
        .email-login,.email-signup{
            position:relative;
            float: left;
            width: 100%;
            height:auto;
            margin-top: 20px;
            text-align:center;
        }
        .u-form-group{
            width:100%;
            margin-bottom: 10px;
        }
        .u-form-group input[type="email"],
        .u-form-group input[type="password"]{
            width: calc(50% - 22px);
            height:45px;
            outline: none;
            border: 1px solid #ddd;
            padding: 0 10px;
            border-radius: 2px;
            color: #333;
            font-size:0.8rem;
            -webkit-transition:all 0.1s linear;
            -moz-transition:all 0.1s linear;
            transition:all 0.1s linear;
        }
        .u-form-group input:focus{
            border-color: #358efb;
        }
        .u-form-group button{
            width:50%;
            background-color: #1CB94E;
            border: none;
            outline: none;
            color: #fff;
            font-size: 14px;
            font-weight: normal;
            padding: 14px 0;
            border-radius: 2px;
            text-transform: uppercase;
        }
        .forgot-password{
            width:50%;
            text-align: left;
            text-decoration: underline;
            color: #888;
            font-size: 0.75rem;
        }
    </style>
</head>
<body>

<div class="login-box">
    <div class="lb-header">
        <a href="#" class="active" id="login-box-link">Login</a>
        <a href="#" id="signup-box-link">Sign Up</a>
    </div>
    <form class="email-login" action="login" method="post">
        <%
            String msg = (String)request.getAttribute("msg");
            String error = (String)request.getAttribute("error");
            if(msg!="") {
                %>
            <p>${msg}</p>
        <%
            }
            if(error!="") {
                %>
            <p>${error}</p>
        <%
            }
        %>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="username" placeholder="Username">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 col-form-label"></label>
            <div class="col-sm-9">
                <input type="submit" class="btn btn-primary" value="Login">
            </div>
        </div>
    </form>
    <form class="email-signup" action="registration" method="post">
        <div class="form-group row">
            <label class="col-sm-3 col-form-label">Full Name</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="fullName" placeholder="Full Name">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 col-form-label">Username</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="username" placeholder="Username">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 col-form-label">Mobile</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="mobile" placeholder="Mobile">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 col-form-label">Address</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="address" placeholder="Address">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 col-form-label">Password</label>
            <div class="col-sm-9">
                <input type="password" class="form-control" name="password" placeholder="Password">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-3 col-form-label"></label>
            <div class="col-sm-9">
                <button type="submit" class="btn btn-primary">Sign in</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script>
    $(".email-signup").hide();
    $("#signup-box-link").click(function(){
        $(".email-login").fadeOut(100);
        $(".email-signup").delay(100).fadeIn(100);
        $("#login-box-link").removeClass("active");
        $("#signup-box-link").addClass("active");
    });
    $("#login-box-link").click(function(){
        $(".email-login").delay(100).fadeIn(100);;
        $(".email-signup").fadeOut(100);
        $("#login-box-link").addClass("active");
        $("#signup-box-link").removeClass("active");
    });
</script>
