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
    <title>Books</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <a href="/books">back to the shelves</a>
    <h1>Add a book to your Shelf!</h1>
    <form:form action="/addNewBook" method="POST" modelAttribute="book">
        <form:input path="user" value="${userId}" type="hidden"></form:input>
        <div class="form-group">
            <label for="title">Title</label>
            <form:input path="title" class="form-control"/>
            <form:errors path="title"/>
        </div>
        <div class="form-group">
            <label for="author">Author</label>
            <form:input path="author" class="form-control"/>
            <form:errors path="author"/>
        </div>
        <div class="form-group">
            <label for="thoughts">Thoughts</label>
            <form:textarea path="thoughts" class="form-control"></form:textarea>
            <form:errors path="thoughts"/>
        </div>
        <button type="submit" class="btn btn-primary">Add Book</button>
    </form:form>
</body>
</html>

