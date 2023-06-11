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
    <title>Omikuji</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<h1>Send an Omikuji!</h1>

<form action="/routetohandleformdata" method="POST">
    <p><label for="number">Pick any number from 5 to 25</label></p>
    <input type="number" name="number" step="1" min="5" max="25">

    <p><label for="nameofcity">Enter the name of any city.</label></p>
    <input type="text" name="nameofcity">

    <p><label for="nameofperson">Enter the name of any real person</label></p>
    <input type="text" name="nameofperson">

    <p><label for="activity">Enter professional endeavor or hobby:</label></p>
    <input type="text" name="activity">

    <p><label for="livingthing">Enter a type of living thing.</label></p>
    <input type="text" name="livingthing">

    <p><label for="somethingnice">Say something nice to someone</label></p>
    <textarea name="somethingnice" rows="4" cols="50"></textarea>

    <p><label for="submit">Send and show a friend</label></p>
    <input type="submit" name="submit" value="Submit">

</form>
</body>
</html>

