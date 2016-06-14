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
                <c:if test="${image != 'uploadedFolder/'}">
                    <img src="${image}" alt="Picture" style="border: black solid thick;" width="200px" height="200px"/>                
                </c:if>

            </c:forEach>
            <br/>
            Comment: ${post.comment}

            <br/>
            Username: ${post.userName}
            <br/>
            Post Id: ${post.postId}
            <hr/>
            <c:forEach items="${post.childrenPost}" var="child">
                User: ${child.userName} <br/>
                Comment: ${child.comment} <br/>
            </c:forEach>
                
                
            <form action="addChildren.spring" method="post">
                <input type="hidden" name="parentPostId" value="${post.postId}" />
                Comment: <textarea name="childComment"></textarea>
                              
                <input type="submit" value="Comment" />
            </form>
                
                
                
            <hr/><hr/>
        </c:forEach>
    </body>
</html>
