<%-- 
    Document   : home
    Created on : Jun 13, 2016, 12:03:51 PM
    Author     : dipen
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
        <h1>Hello World!</h1>
        <c:forEach items="${posts}" var="post">
            <c:forEach items="${post.imageName}" var="image" >
                <img src="${image}" alt="Picture" style="border: black solid thick;" width="200px" height="200px"/>
            </c:forEach>
            
        </c:forEach>
    </body>
</html>
