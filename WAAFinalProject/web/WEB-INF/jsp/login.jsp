<%-- 
    Document   : login
    Created on : Jun 12, 2016, 1:28:32 AM
    Author     : tsegaab
--%>

<%--<%@include file="include.jsp"%>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">

    </head>
    <body >
        <!--<h1 align="center">Login Page</h1>-->
        <div id="main">
            <div id="header">
                <div id="header1"><img border="0" src="images/logo.jpg"></div><!--end of header1-->
                <div id="header2"></div><!--end of header2-->
                <div id="header3">

                    <div class="login">
                        <form action="login.rajeev" method="POST">

                            <%
                                if (request.getAttribute("nonUser") != null) {
                                    out.println("Username or Password error!!!");
                                }
                            %>

                            <div class="loginone">
                                <div class="loginA"> Username :</div>
                                <div class=loginC>Password :</div>
                            </div>

                            <div class="loginTwo">
                                <div class="loginB"><input type="text" name="username" required="Wrong username" /></div>
                                <div class="loginD"><input type="password" name="password" required="Wrong password" /></div>
                                <div class="loginB"> <input type="submit" name="submit" value="LogIn"></div>
                            </div>

                            <!--                &nbsp; &nbsp;<a href="#" class="">forgot password ?</a>-->
                        </form>
                    </div>
                </div>
            </div>

            <div id="header4"><img border="0" src="images/bg.jpg" style="z-index: 2;">
                <div id="header5"><img border="0" src="images/signup.jpg">
                </div>
            </div>
        </div>

    </body>
</html>
