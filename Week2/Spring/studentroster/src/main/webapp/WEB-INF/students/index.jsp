<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>dan</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<a href="/dorms">Dashboard</a>
<h1>New Student</h1>
    <form:form action="/createstudents" method="POST" modelAttribute="student">
        <form:label path="first">first</form:label>
        <form:input path="first"></form:input>
        <form:label path="last">last</form:label>
        <form:input path="last"></form:input>
        <form:select path="dorm">
            <c:forEach var="dorm" items="${dorms}">
                <form:option value="${dorm.id}">${dorm.name}</form:option>
            </c:forEach>
        </form:select>
        <input type="submit" value="Create">
    </form:form>
</body>
</html>