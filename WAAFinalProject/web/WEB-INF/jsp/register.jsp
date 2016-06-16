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
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <title></title>
    </head>
    <body>
        <div id="header1"></div>
        <div id="header2"></div>
        <div id="header3"></div>
        <form class="form1"></form>
        
        <h3> Sign Up </h3>
<form action="userRegister.spring" modelAttribute="user" method="POST" >
            <table>
                <tr>
                    <td><h4>User Name:</h4> </td>
             <td><input type="text" name="username" maxlength="15" minlength="5" required="true"/> </td>
                 </tr><tr>
            <td><h4>Password: </h4></td>
            <td><input type="password" name="password" required="true"/></td>
                </tr><tr>
             <td><h4>First Name:</h4> </td>
             <td><input type="text" name="firstname" maxlength="20" minlength="5" required="true"/> </td>
                </tr><tr>
             <td><h4>Last Name:</h4> </td>
             <td><input type="text" name="lastname" maxlength="20" minlength="5" required="true"/> </td>
                </tr><tr>
             <td><h4>Age:</h4> </td>
             <td><input type="number" name="age" min="18" max="99" step="1" required="true"/> </td>
                 </tr><tr>
             <td><h4>Birthday:</h4> </td>
             <td><input type="date"  name="dateofbirth" required="true"/> </td>
                 </tr><tr>      
             <td><h4>Gender:</h4> </td>
                <td>Male<input type="radio" name="gender" value="Male" required="true" checked="true"/>
                         Female<input type="radio" name="gender" value="Female" required="true"/>
            Other<input type="radio" name="gender" value="Other" required="true"/> </td>
                </tr><tr>
         <td><h4>Country of Birth:</h4> </td>
              <td><select name="country" required="true">
        <c:forEach items="${country}" var="country">            
            <option value="${country}">${country}</option>                    
        </c:forEach>
        </select> </td>
                </tr><tr>
             <td><h4>State:</h4> </td>
             <td><input type="text" name="state" required="true"/> </td>
                </tr><tr>  
             <td><h4>High School:</h4> </td>
             <td><input type="text" name="highschool" maxlength="15" minlength="3" required="true"/> <td>
                </tr>  <tr>
             <td><h4>College:</h4> </td>
             <td><input type="text" name="college" maxlength="15" minlength="3" required="true"/> </td>
             </tr> <tr>
            
             <td><h4>Nationality:</h4> </td>
              <td><select name="nationality" required="true">
        <c:forEach items="${nationality}" var="nationality">            
            <option value="${nationality}">${nationality}</option>                    
        </c:forEach>
            </select> </td>
            
            </tr>
            </table>
            <input type="submit" value="Sign up"/>   
</form>
    </body>
</html>
