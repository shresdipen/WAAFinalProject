<%-- 
    Document   : users
    Created on : Jun 12, 2016, 4:20:05 PM
    Author     : kb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>users</title>
    </head>
    <body>
        <p>
            This is the initial part of testing.
        </p>
        <%--<c:forEach items="${friends}" var="friend">--%>
        Friend List:
        
            <c:forEach items="${friends}" var="user">
                <div class="col-sm-6 col-md-3" style="padding-bottom:
                     15px">
                    <div class="thumbnail">
                        <div class="caption">
                            <h3>${user.userName}</h3>
                            <p>${user.age}</p>                        
                        </div>
                    </div>
                </div>
            </c:forEach>
        
        <%--</c:forEach>--%>
    </body>
</html>
