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
    <title>New Product</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <h1>New Product</h1>
    <a href="/">Home</a>
    <form:form action="/newproduct" method="POST" modelAttribute="product">
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="name" class="form-control"/>
            <form:errors path="name"/>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <form:input path="description" class="form-control"/>
            <form:errors path="description"/>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <form:input type="number" path="price" class="form-control"/>
            <form:errors path="price"/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</body>
</html>

