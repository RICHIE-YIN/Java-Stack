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
    <title>Fruity Loops</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
            <!-- old method -->
            <!-- <h1>
                <c:out value="${name}"></c:out>
            </h1>
            <p>item name: ${itemName}</p>
            <p>price: ${price}</p>
            <p>description: ${description}</p>
            <p>vendor: ${vendor}</p> -->
            <h1>Fruit Store</h1>
            
            <c:forEach var="fruits" items="${fruits}"> <!-- var="item" is an iteration for items -->
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${fruits.name}</td>
                        <td>${fruits.price}</td>
                    </tr>
                </tbody>
            </table>
            <!-- <div class="card">

                <p>item name: ${fruits.name}</p>
                <p>price: ${fruits.price}</p>
            </div> -->
            </c:forEach>
    </div>
</body>
</html>

