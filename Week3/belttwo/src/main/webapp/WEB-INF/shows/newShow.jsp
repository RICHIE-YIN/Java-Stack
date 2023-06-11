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
    <title>Characters</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <a href="/shows">Back to Dashboard</a>
    <h1>Add a name!</h1>
    <form:form action="/show/new" method="POST" modelAttribute="show">
    <div class="form-group">
        <label for="title">Title</label>
        <form:input path="title" class="form-control"/>
        <form:errors path="title"/>
    </div>
    <div class="form-group">
        <label for="network">Network</label>
        <form:input path="network" class="form-control"/>
        <form:errors path="network"/>
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <form:textarea path="description" class="form-control" rows="5"></form:textarea>
        <form:errors path="description"/>
    </div>    
    <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
    <a href="/shows">Cancel</a>
</body>
</html>
