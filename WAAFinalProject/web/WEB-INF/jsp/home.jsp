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
        <h1>Welcome User</h1>
        <form action="uploader.spring" method="post" enctype="multipart/form-data">
            Select images: <input type="file" name="uploadedFiles" accept="image/*" multiple=""/>
            <br/>
            Comment: <textarea name="comment" name="comment"> </textarea>

            <br/>
            <input type="submit" value="Upload" />
        </form>

        <hr/><hr/>
        <c:forEach items="${posts}" var="post">
            <c:if test="${post.userName == userName}">

                <form action="removePost.spring" method="post">
                    <input type="hidden" name="postId" value="${post.postId}"/>
                    <input type="submit" value="Delete" />
                </form>
            </c:if>
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
                <form action="removeChildren.spring" method="post">
                    User: ${child.userName} <br/>
                    Comment: ${child.comment} <br/>
                    Post Id: ${child.postId} <br/>
                    <input type="hidden" name="parentPostId" value="${post.postId}"/>
                    <input type="hidden" name="childPostId" value="${child.postId}"/>
                    <c:if test="${child.userName == userName}">
                        <input type="submit" value="Delete" />
                    </c:if>
                </form>
                <hr/>
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
