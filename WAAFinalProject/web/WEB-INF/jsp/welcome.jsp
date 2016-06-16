<%-- 
    Document   : welcome
    Created on : Jun 12, 2016, 7:58:25 AM
    Author     : tsegaab
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        Welcome ${user.firstname} ${user.lastname},
        
        <br />
        ${user.age}
        <br />
        ${user.address.college}, ${user.address.country}
        
        <br />
        <a href="logout.rajeev">Logout</a>

        <h1 align =" center">welcome page</h1>
        <br> test model attribute tt
        <br>
        <br>
        <h3>user details</h3>
        ${username}
        <br> username ${newuser.username}
        <br> password ${newuser.password}
        <br> firstname ${newuser.firstname}
        <br> lastname ${newuser.lastname}
        <br> age ${newuser.age}
        <br> date of birth ${newuser.dateofbirth}
        <br> gender ${newuser.gender}
        <br> <h3>the following is address information</h3>
        <br> country ${newuser.address.country}
        <br> state ${newuser.address.state}
        <br> highschool ${newuser.address.highschool}
        <br> college ${newuser.address.college}
        <br> nationality ${newuser.address.nationality}

    </body>
</html>
