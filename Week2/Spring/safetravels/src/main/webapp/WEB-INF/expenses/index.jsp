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
    <title>Expenses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<h1>Safe Travels</h1>
<table class="table">
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="expense" items="${expenses}"> <!-- allows us to iterate through using our JTSL tags; we can also name our var anything and our item is gonna be all of our ${books} -->
        <tr>
            <td><a href="/expenses/${expense.id}">${expense.name}</a></td>
            <td>${expense.vendor}</td>
            <td>$${expense.amount}</td>
            <td>
                <a href="/expenses/${expense.id}/edit">Edit</a>
                <form action="/expenses/${expense.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<h2>Add an expense:</h2>
<form:form action="/newexpenses" method="POST" modelAttribute="newExpense">
<div class="form-control">
    <form:label path="name">name</form:label>
    <form:errors path="name"/>
    <form:input path="name"></form:input>
</div>
<div class="form-control">
    <form:label path="vendor">vendor</form:label>
    <form:errors path="vendor"/>
    <form:input path="vendor"></form:input>
</div>
<div class="form-control">
    <form:label path="amount">amount</form:label>
    <form:errors path="amount"/>
    <form:input path="amount"></form:input>
</div>
<div class="form-control">
    <form:label path="description">description</form:label>
    <form:errors path="description"/>
    <form:textarea path="description"></form:textarea>
</div>
<input type="submit" name="submit">
</form:form>
</body>
</html>

