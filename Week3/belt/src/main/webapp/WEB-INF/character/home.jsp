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
    Hello ${user.userName}. Here are some name suggestions..
    <a href="/logout">logout</a>
    <a href="/names/new">new</a>
    <h1>Baby Names</h1>
    <table>
        <thead>
            <tr>
                <th>Upvote</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Origin</th>
                <th>Votes</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="character" items="${characters}">
                <tr>
                    <td>
                        <c:if test="${! character.upvoters.contains(user)}">
                            <form action="/character/upvote/${character.id}" method="POST">
                                <button type="submit" class="btn btn-primary">Upvote</button>
                            </form>
                        </c:if>
                    </td>
                    <td><a href="/character/${character.id}">${character.name}</a></td>
                    <td>${character.gender}</td>
                    <td>${character.origin}</td>
                    <td>${character.upvotes}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>