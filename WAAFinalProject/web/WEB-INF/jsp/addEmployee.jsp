<%-- 
    Document   : addEmployee
    Created on : Jun 13, 2016, 6:08:12 PM
    Author     : tsegaab
--%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<html>
<head>
    <title>Add Employee Form</title>
</head>
 
<body>
    <h2><spring:message code="lbl.page" text="Add New Employee" /></h2>
    <br/>
    <form:form method="post" modelAttribute="employee">
        <table>
            <tr>
                <td><spring:message code="lbl.firstName" text="First Name" /></td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.lastName" text="Last Name" /></td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.email" text="Email Id" /></td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add Employee"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>