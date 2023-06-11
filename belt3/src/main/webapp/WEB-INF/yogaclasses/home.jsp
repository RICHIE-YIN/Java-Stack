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
    <title>login and reg</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <a href="/logout">logout</a>
    <a href="/classes/new">new</a>
    ${user.userName}.
    <h1>Course Schedule</h1>
    <table>
        <thead>
        <tr>
            <th>Class Name</th>
            <th>Instructor</th>
            <th>Weekday</th>
            <th>Price</th>
            <th>Time</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="yogaClass" items="${yogaclasss}">
            <tr>
            <td><a href="/classes/${yogaClass.id}">${yogaClass.name}</a>
                <c:if test="${yogaClass.user.id == user.id}">
                    <a href="/classes/${yogaClass.id}/edit">Edit</a>
                </c:if>
            </td>
            <td>${yogaClass.user.userName}</td>
            <td>${yogaClass.dayOfWeek}</td>
            <td>${yogaClass.price}</td>
            <td>${yogaClass.time}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>