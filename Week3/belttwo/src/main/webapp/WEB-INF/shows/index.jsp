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
    Welcome ${user.userName}. 
    <a href="/logout">logout</a>
    <a href="/shows/new">new</a>
    <h4>TV Shows</h4>
    <table>
        <thead>
            <tr>
                <th>Show</th>
                <th>Network</th>
                <th>Average Rating</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="show" items="${shows}">
                <tr>
                    <td><a href="/shows/${show.id}">${show.title}</a></td>
                    <td>${show.network}</td>
                    <td>-------</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>