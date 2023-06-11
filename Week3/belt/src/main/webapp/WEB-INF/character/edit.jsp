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
    <a href="/home">back to home</a>
    <h1>Change ${character.name}!</h1>
    <form:form action="/character/${character.id}/editcharacter" method="POST" modelAttribute="character">
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="name" class="form-control" readonly="true"/>
        </div>
        <div class="form-group">
            <label for="gender">Gender</label>
            <form:select path="gender" class="form-control">
                <form:option value="male">Male</form:option>
                <form:option value="female">Female</form:option>
                <form:option value="neutral">Neutral</form:option>
            </form:select>
            <form:errors path="gender"/>
        </div>
        <div class="form-group">
            <label for="origin">Origin</label>
            <form:input path="origin" class="form-control" value="${character.origin}"/>
            <form:errors path="origin"/>
        </div>
        <div class="form-group">
            <label for="meaning">Meaning</label>
            <form:textarea path="meaning" class="form-control" rows="5"></form:textarea>
            <form:errors path="meaning"/>
            </div>
            <button type="submit" class="btn btn-primary">Save Changes</button>
        </form:form>
        <a href="/character/${character.id}">Cancel</a>
        <c:if test="${isCurrentUser}">
            <form action="/character/${character.id}/delete" method="POST">
                <input type="hidden" name="_method" value="DELETE">
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </c:if>
</body>
</html>
