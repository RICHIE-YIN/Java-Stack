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
    <title>login and reg</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <a href="/show">Back to Dashboard</a>
    <h1>${show.title}</h1>
    <h2>Posted by: ${show.user.userName}</h2>
    <h3>Network: ${show.network}</h3>
    <h3>Description: ${show.description}</h3>
    <table>
        <thead>
            <tr>
                <th>User</th>
                <th>Ratings</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <c:if test="${canEdit}">
        <a href="/shows/${show.id}/edit">Edit</a>
    </c:if>
</body>
</html>