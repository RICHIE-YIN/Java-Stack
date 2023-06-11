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
    <title>${dorm.name}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<h1>${dorm.name} Location Students</h1>
<form method="POST" action="/dorms/${dorm.id}/assignstudent">
    <select name="studentId">
        <c:forEach var="student" items="${students}">
            <option value="${student.id}">
                ${student.first} (${student.dorm.name})
            </option>
        </c:forEach>
    </select>
    <input type="submit" value="Add">
</form>
<table class="table">
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="student" items="${dorm.students}"> <!-- allows us to iterate through using our JTSL tags; we can also name our var anything and our item is gonna be all of our ${books} -->
        <tr>
            <td>${student.first}</td>
            <td>${student.last}</td>
            <td>
                <form action="/students/${student.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>







