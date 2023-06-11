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
<h1>All Books</h1>
${books}
<table class="table">
    <thead>
        <tr>
            <th>Author</th>
            <th>Title</th>
            <th>Pages</th>
            <th>Edit</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${books}"> <!-- allows us to iterate through using our JTSL tags; we can also name our var anything and our item is gonna be all of our ${books} -->
        <tr>
            <td>${book.author}</td>
            <td><a href="/books/${book.id}">${book.title}</a></td>
            <td>${book.pages}</td>
            <td><a href="/books/${book.id}/edit">Edit</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/books/new">Create new book</a>
</body>
</html>

