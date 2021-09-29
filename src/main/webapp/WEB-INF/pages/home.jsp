<%--
  Created by IntelliJ IDEA.
  User: Amita.Nair
  Date: 9/23/2021
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Management System</title>
</head>
<body>
<div align="center">
    <h1>Employee List</h1>
    <h3>
        <a href="newEmployee">New Employee</a>
    </h3>
    <table border="1">

        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Country</th>
        <th colspan="2">Action</th>

        <c:forEach var="employee" items="${listEmployee}">
            <tr>

                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.address}</td>
                <td>${employee.city}</td>
                <td>${employee.state}</td>
                <td>${employee.country}</td>
                <td><a href="editEmployee?id=${employee.id}">Edit</a>
                <td><a href="deleteEmployee?id=${employee.id}">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

