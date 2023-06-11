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
    <title>Yoga Class</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <a href="/home">back to home</a>
    <h1>Create a Course!</h1>
    <form:form action="/yogaclass/new" method="POST" modelAttribute="yogaClass">
        <div class="form-group">
            <label for="name">Class Name</label>
            <form:input path="name" class="form-control"/>
            <form:errors path="name"/>
        </div>
        <div class="form-group">
            <label for="dayOfWeek">Day of Week</label>
            <form:select path="dayOfWeek" class="form-control">
                <form:option value="Monday">Monday</form:option>
                <form:option value="Tuesday">Tuesday</form:option>
                <form:option value="Wednesday">Wednesday</form:option>
                <form:option value="Thursday">Thursday</form:option>
                <form:option value="Friday">Friday</form:option>
                <form:option value="Saturday">Saturday</form:option>
                <form:option value="Sunday">Sunday</form:option>
            </form:select>
            <form:errors path="dayOfWeek"/>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="price" class="form-control" type="text" />
            <form:errors path="price" />
        </div>        
        <div class="form-group">
            <label for="time">Time</label>
            <form:input path="time" type="time" class="form-control" />
            <form:errors path="time" />
        </div>        
        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="description" class="form-control" rows="5"></form:textarea>
            <form:errors path="description"/>
        </div>    
        <button type="submit" class="btn btn-primary">Create</button>
    </form:form>
</body>
</html>
