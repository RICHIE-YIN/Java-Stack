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
    <title>Character Details</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <h1>${yogaClass.name} with ${yogaClass.user.userName}</h1>
    <h3>Day: ${yogaClass.dayOfWeek}</h3>
    <h3>Cost: $${yogaClass.price}</h3>
    <h3>Time: ${yogaClass.time}</h3>
    <p>${yogaClass.description}</p>

    <!-- <h2>Add Students to Course</h2> -->
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${yogaClass.students}">
                <tr>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <!-- <h4>Students</h4>
    <table>
        <thead>
            <tr>
                <th>Student Name</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${yogaClass.students}" var="student">
            <tr>
                <td>${student.name}</td>
                <td>${student.email}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table> -->

    <h3>Add Students to Course</h3>
    <h5>New Student</h5>
    <form:form action="/student/new" method="POST" modelAttribute="student">
        <div class="form-group">
            <label for="name">Student Name</label>
            <form:input path="name" class="form-control"/>
            <form:errors path="name"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="email" class="form-control"/>
            <form:errors path="email"/>
        </div>
        <button type="submit">Add Student</button>
    </form:form>

    <h5>Existing Student</h5>
    <form:form action="/yogaclass/${yogaClass.id}/assign" method="POST" modelAttribute="student">
        <div class="form-control">
            <form:label path="studentId">Existing Student</form:label>
            <form:select path="studentId" class="form-control" name="studentId">
                <c:forEach var="student" items="${allStudents}">
                    <form:option value="${student.id}">${student.name} - ${student.email}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <button type="submit">Assign Student</button>
    </form:form>
</body>
</html>
