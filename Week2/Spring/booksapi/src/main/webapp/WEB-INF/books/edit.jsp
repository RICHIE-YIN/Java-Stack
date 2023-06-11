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
    <title>New Book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    ${book}
    <div class="container">
        <!-- <form class="form-control" action="/books" method="POST">
            Author: <input type="text" name="author">
            Title: <input type="text" name="title">
            Pages: <input type="number" name="pages">
            <input type="submit" value="create">
        </form> -->

        <h2>Edit a ${book.title}</h2>
        <form:form action="/books/${book.id}" method="PUT" modelAttribute="book"> <!-- form on steroids! -->
        <div class="form-control">
            <form:label path="author">author</form:label>
            <form:errors path="author"/>
            <form:input path="author"></form:input>
        </div>
        <div class="form-control">
            <form:label path="title">title</form:label>
            <form:errors path="title"/>
            <form:input path="title"></form:input>
        </div>
        <div class="form-control">
            <form:label path="pages">pages</form:label>
            <form:errors path="pages"/>
            <form:input path="pages"></form:input>
        </div>
        <input type="submit" name="submit">
        </form:form>

    </div>

</body>
</html>

