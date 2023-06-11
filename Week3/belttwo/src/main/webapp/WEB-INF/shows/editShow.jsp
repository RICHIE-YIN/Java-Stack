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
    <title>Shows</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <a href="/shows">Back to Dasboard</a>
    <h1>${show.title}!</h1>
    <form:form action="/show/${show.id}/editshow" method="POST" modelAttribute="show">
        <div class="form-group">
            <label for="title">Title</label>
            <form:input path="title" class="form-control" value="${show.title}"/>
            <form:errors path="title"/>
        </div>
        <div class="form-group">
            <label for="network">network</label>
            <form:input path="network" class="form-control" value="${show.network}"/>
            <form:errors path="network"/>
        </div>
        <div class="form-group">
            <label for="description">description</label>
            <form:textarea path="description" class="form-control" rows="5"/>
            <form:errors path="description"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
        <a href="/show/${show.id}">Cancel</a>
        <c:if test="${isCurrentUser}">
            <form action="/show/${show.id}/delete" method="POST">
                <input type="hidden" name="_method" value="DELETE">
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </c:if>
</body>
</html>
