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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Expenses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <h1>Home Page</h1>
    <a href="/products/new">New Product</a>
    <a href="/categories/new">New Category</a>
    <table>
        <thead>
            <tr>
                <th>Products</th>
                <th>Categories</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <ul>
                        <c:forEach var="product" items="${products}">
                            <li><a href="products/${product.id}">${product.name}</a></li>
                        </c:forEach>
                    </ul>
                </td>
                <td>
                    <ul>
                        <c:forEach var="category" items="${categories}">
                            <li><a href="categories/${category.id}">${category.name}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </tbody>
    </table>
    <!-- <table class="table">
        <thead>
            <tr>
                <th>Product</th>
                <th>Categories</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>
                        <a href="/products/${product.id}">${product.name}</a>
                    </td>
                    <td></td>
                </tr>
            </c:forEach>
            <c:forEach var="category" items="${categories}">
                <tr>
                    <td></td>
                    <td>
                        <a href="/categories/${category.id}">${category.name}</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table> -->
</body>
</html>