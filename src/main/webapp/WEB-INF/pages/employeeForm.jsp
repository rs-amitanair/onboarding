<%--
  Created by IntelliJ IDEA.
  User: Amita.Nair
  Date: 9/23/2021
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Contact</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/validation.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#mail").blur(function () {
                var enteredMail=$("#mail").val();
                $.ajax({
                    url:"/validateMail",
                    method:"GET",
                    data:"email="+enteredMail,
                    success:function (result){
                            if(!result){
                            $("#emailMsg").html("This email is already registered!");
                            $("#saveBtn").prop('disabled',true);
                            }else{
                                $("#emailMsg").html("");
                                $("#saveBtn").prop('disabled',false);
                            }
                    },
                    error:function () {
                        alert("Error");
                    }
                })
            });
        });
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
                <td><form:input id="firstName" required="required" path="firstName" maxlength="50"/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input required="required" path="lastName" maxlength="50" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input  required="required" path="address" maxlength="100" /></td>
            </tr>
            <tr>
                <td>Email Address:</td>
                <td><form:input id="mail" required="required" path="email" maxlength="50"/></td>
            </tr>
            <td>
                <span id="emailMsg"></span>
            </td>
            <tr>
                <td>City:</td>
                <td><form:input required="required" path="city" maxlength="25"/></td>
            </tr>
            <tr>
                <td>State</td>
                <td><form:input  required="required" path="state" maxlength="25"/></td>
            </tr>
            <tr>
                <td>Country</td>
                <td>
                    <form:select path="countryId">
                        <c:forEach var="country" items="${countryList}">
                            <form:option value="${country.id}">${country.countryName}</form:option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:password path="password"  required="required" id="pass" maxlength="10"/></td>
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><input required="required" type="password" id="conf"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input id="saveBtn" type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
