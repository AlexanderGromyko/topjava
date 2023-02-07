<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<div>
    <div>
        <h2>Meal list</h2>
    </div>
    <table>
        <tr>
            <th>Date/Time</th>
            <th>Description</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        <c:set var="dtf" value="${DateTimeFormatter.ofPattern('yyyy.MM.dd HH:mm:ss')}" />
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
            <tr id="${meal.excess ? "overdose" : "normal"}">
                <td>${meal.dateTime.format(dtf)}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="">Update</a></td>
                <td><a href="">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>