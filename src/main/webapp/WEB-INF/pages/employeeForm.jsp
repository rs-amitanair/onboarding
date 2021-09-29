<%--
  Created by IntelliJ IDEA.
  User: Amita.Nair
  Date: 9/23/2021
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Contact</title>
    <script type="text/javascript" src="/resources/validation.js">
    </script>
</head>
<body>
<div align="center">
    <h1>New Employee</h1>
    <form:form onsubmit="test();" action="saveEmployee" method="post" modelAttribute="employee">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>First Name:</td>
                <td><form:input required="required" path="firstName"/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input required="required" path="lastName" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input  required="required" path="address" /></td>
            </tr>
            <tr>
                <td>Email Address:</td>
                <td><form:input id="mail" required="required" path="email"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><form:input required="required" path="city" /></td>
            </tr>
            <tr>
                <td>State</td>
                <td><form:input  required="required" path="state"/></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><form:input  required="required" path="country"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:input path="password"  required="required" type="password" id="pass"/></td>
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><form:input path="confirmPassword"  required="required" type="password" id="conf"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>