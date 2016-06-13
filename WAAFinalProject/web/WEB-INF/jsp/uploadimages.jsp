<%-- 
    Document   : uploadimages
    Created on : Jun 12, 2016, 3:40:27 PM
    Author     : dipen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="uploader.spring" method="post" enctype="multipart/form-data">
            Select images: <input type="file" name="uploadedFiles" accept="image/*" multiple=""/>
            <input type="submit" value="Upload" />
        </form>
        ${name}
    </body>
</html>
