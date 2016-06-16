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
        <hr/>


        Before the new file
        =====================================
        <hr/>
        <h3> Welcome  ${user.username}, </h3>
        Your list of Friends:
        <hr/>
        <input type="hidden" value="${name}" name="name"/>
        <c:forEach items="${friends}" var="freind">
            <div class="col-sm-6 col-md-3" style="padding-bottom:
                 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <form action="/WAAFinalProject/removeUser.spring" method="POST">
                            <input type="hidden" value="${freind.username}" name="oldFriend"/>
                                <input type="hidden" value="${user.username}" name="delUser"/>
                                <input type="hidden" value="${name}" name="name"/>
                            User Name: ${freind.username} <input type="submit" value="Remove"/><br/>
                            Last Name: ${freind.firstname}<br/>                   
                            First Name: ${freind.lastname}  
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>

        List of searched users:
        <hr/>
        <div>
            <c:forEach items="${users}" var="user">
                <div class="col-sm-6 col-md-3" style="padding-bottom:
                     15px">
                    <div class="thumbnail">
                        <div class="caption">
                            User Name: ${user.username}<br/>
                            Last Name: ${user.firstname}<br/>                   
                            First Name: ${user.lastname}                      
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <hr/>
        List of Suggested Friends: 
        <div>
            <c:forEach items="${suggested}" var="addfrined">
                <div class="col-sm-6 col-md-3" style="padding-bottom:
                     15px">
                    <div class="thumbnail">
                        <div class="caption">
                            <form action="addFriend.spring" method="POST">
                                <input type="hidden" value="${addfrined.username}" name="newFriend"/>
                                <input type="hidden" value="${user.username}" name="regUser"/>
                                <input type="hidden" value="${name}" name="name"/>
                                User Name: ${addfrined.username}&nbsp;<input type="submit" value="Add"/> <br/>
                                Last Name: ${addfrined.firstname}<br/>                   
                                First Name: ${addfrined.lastname}   
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
        <%--</c:forEach>--%>
    </body>
</html>
