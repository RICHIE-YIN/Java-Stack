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
    ${character.name}
    <p>(added by ${character.user.userName})</p>
    <h1>Character Details</h1>
    <p>Gender: ${character.gender}</p>
    <p>Origin: ${character.origin}</p>

    <c:if test="${hasUpvoted}">
        <p>You upvoted this character!</p>
    </c:if>    
    <c:if test="${! hasUpvoted}">
        <form action="/character/upvote/${character.id}" method="POST">
            <button type="submit" class="btn btn-primary">Upvote</button>
        </form>
    </c:if>
    <p>Meaning: ${character.meaning}</p>
    <c:if test="${canEdit}">
    <a href="/character/${character.id}/edit">Edit</a>
    </c:if>

</body>
</html>
