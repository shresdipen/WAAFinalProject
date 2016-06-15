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
        <script>
            function disablePost() {
                disable = true;
                if (document.getElementsByName("uploadedFiles")[0].value != "" || document.getElementsByName("comment")[0].value != "") {
                    disable = false;
                }
                document.getElementById("uploadPost").disabled = disable;
            }
            ;
        </script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

        <link href="css/main_1.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="homebody">

        <div>  
            <div id="header">
                <div id="header1"><img id="headerimage" border="0" src="images/logo.jpg"></div>
                <div id="logout">
                    <form action="login.rajeev" method="POST">
                        <input type="submit" value="logout">
                    </form>
                </div>
            </div>

        </div>


        <div class="container-fluid text-center">  
            <div class="row content" style="padding-left:   15px;">
                <!--        <div class="login" id="post">    -->
                <!--
                                    <div class="col-sm-2 sidenav">
                                    
                                    </div>-->


                <hr/><hr/>
                <!--        <div class="login">-->
                <div class="col-sm-8 text-left" style="background-color: white"> 

                    <div id="leftbox">
                        <form action="uploader.spring" method="post" enctype="multipart/form-data">
                            Select images: <input type="file" name="uploadedFiles" accept="image/*" multiple="" onchange ="disablePost()"/>
                            <br/>
                            Comment: <textarea name="comment" onkeyup="disablePost()"> </textarea>

                            <br/>
                            <input type="submit" value="Upload" id="uploadPost" disabled="true"/>
                        </form>
                    </div>


                    <br><br>
                    <br>
<hr><hr>
                    <c:forEach items="${posts}" var="post">
                        
                        <c:if test="${post.userName == userName}">

                            <form action="removePost.spring" method="post">
                                <input type="hidden" name="postId" value="${post.postId}"/>
                                <input type="submit" value="Delete" />
                            </form>
                            <br>
                        </c:if>
                        <c:forEach items="${post.imageName}" var="image" >
                            <c:if test="${image != 'uploadedFolder/'}">
                                <img src="${image}" alt="Picture" class="images" />                
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
                                <c:if test="${child.userName == userName || post.userName == userName}">
                                    <input type="submit" value="Delete" />
                                </c:if>
                            </form>
                            <hr/>
                        </c:forEach>

                        <form action="addChildren.spring" method="post">
                            <input type="hidden" name="parentPostId" value="${post.postId}" />
                            Comment: <textarea name="childComment"></textarea>

                            <input type="submit" value="Comment"/>
                        </form>



                        <hr/><hr/>
                    </c:forEach>
                    <!--        </div>-->

                </div>
                <div id="rightbox" class="col-sm-2 sidenav" style="background-color: white; padding:0px;"  >
                    <div id="smallrightbox" class="well">
                        <p>suggested friends</p>
                        <c:forEach items="${suggested}" var="addfrined">
                            <c:if test="${userName != addfrined.username}">
                                <div  style="padding-bottom:15px">
                                    <div class="thumbnail">
                                        <div class="caption">
                                            <form action="addFriends.spring" method="POST">
                                                <input type="hidden" value="${addfrined.username}" name="newFriend"/>
                                                <input type="hidden" value="${user.username}" name="regUser"/>
                                                <input type="hidden" value="${name}" name="name"/>
                                                ${addfrined.username}&nbsp;<input type="submit" value="Add"/> <br/>
                                                ${addfrined.firstname} &nbsp; ${addfrined.lastname}   
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>

                    </div>
                    
                    <div id="" class="well">
                        List of searched users:
        <hr/>
        <div>
            <form action="users.jsp" method="POST">
               <input type="text" name="username" required="Wrong username" />
               <input type="submit" name="submit" value="Search"/>
            </form>
        </div>
        <hr/>                 
                    </div>
                    
                    
                    
                    
                    <div id="smallleftbox"class="well">
                        <p></p>
                        <a href="addEmployee.spring">report suspicion</a>
                    </div>
                </div>
            </div>
        </div>    

        <div id="footer">
            <p>copy righted material</p>
        </footer></div>

</div>  
</body>
</html>
