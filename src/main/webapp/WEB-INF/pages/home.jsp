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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="d" uri="/WEB-INF/tlds/custom-tag-lib.tld" %>
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
        <th>Email</th>
        <th>City</th>
        <th>State</th>
        <th>Country</th>
        <th colspan="2">Action</th>

        <c:forEach var="employee" items="${listEmployee}">
            <tr>
                <d:display name="Amita"/>
                <c:choose>
                    <c:when test="${employee.firstName.length()>20}">
                        <td>${fn:substring(employee.firstName,0,20)}...</td>
                    </c:when>
                    <c:otherwise>
                        <td>${employee.firstName}</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${employee.lastName.length()>20}">
                        <td>${fn:substring(employee.lastName,0,20)}...</td>
                    </c:when>
                    <c:otherwise>
                        <td>${employee.lastName}</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${employee.address.length()>20}">
                        <td>${fn:substring(employee.address,0,20)}...</td>
                    </c:when>
                    <c:otherwise>
                        <td>${employee.address}</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${employee.email.length()>20}">
                        <td>${fn:substring(employee.email,0,20)}...</td>
                    </c:when>
                    <c:otherwise>
                        <td>${employee.email}</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${employee.city.length()>20}">
                        <td>${fn:substring(employee.city,0,20)}...</td>
                    </c:when>
                    <c:otherwise>
                        <td>${employee.city}</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${employee.state.length()>10}">
                        <td>${fn:substring(employee.state,0,20)}...</td>
                    </c:when>
                    <c:otherwise>
                        <td>${employee.state}</td>
                    </c:otherwise>
                </c:choose>
                <td>${employee.countryName}</td>
                <td><a href="editEmployee?id=${employee.id}">Edit</a>
                <td><a href="deleteEmployee?id=${employee.id}">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

