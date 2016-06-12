<%-- 
    Document   : register
    Created on : Jun 12, 2016, 9:25:16 AM
    Author     : tsegaab
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        
        <h1>registration page</h1>
        <form:form action="userRegister.spring" modelAttribute="user" method="POST" >
        <fieldset>
            <label>username</label>
            <form:input path="username" />
            
            <label for="password" class="">password</label>
            <form:input type="password" path="password"/>
            
            <label for="firstName" class="">First Name</label>
            <form:input type="text" path="firstname" />

            <label for="lastName" class="">Last Name</label>
            <form:input type="text" path="lastname"/>
            
            <label for="birthDay" class="">Birthday</label>
            <form:input type="text" path="dateofbirth" />
                        
            <label for="gender" class="">Gender</label>
            <form:input type="text" path="gender" />
            
            <label for="country" class="">Country</label>
            <form:input type="text" path="address.country" />
                        
            <label for="state" class="">State</label>
            <form:input type="text" path="address.state" />
                        
            <label for="lastName" class="">High School</label>
            <form:input type="text" path="address.highschool"/>
            
            <label for="lastName" class="">College</label>
            <form:input type="text" path="address.college"/>
            
            <label for="citizenship" class="">Nationality</label>
            <form:input type="text" path="address.nationality" />   
            
            <button type="submit">Sign up</button>
        </fieldset>
</form:form>
    </body>
</html>
