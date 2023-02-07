<%@ page import="ru.javawebinar.topjava.model.MealTo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Edit meal</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div>
    <h2>Edit meal</h2>
</div>
<form method="post" action="meals" enctype="application/x-www-form-urlencoded">
    <input type="hidden" name="id" value="${meal.id}">
    <dl>
        <dt>DateTime:</dt>
        <dd><input type="datetime-local" name="DateTime" size="50" value="${meal.dateTime}"></dd><br>
        <dt>Description:</dt>
        <dd><input type="text" name="Description" size="100" value="${meal.description}"></dd><br>
        <dt>Calories:</dt>
        <dd><input type="number" name="Calories" size="50" value="${meal.calories}"></dd><br>
    </dl>
    <button type="submit">Save</button>
    <button onclick="window.history.back()" type="button">Cancel</button>
</form>
</body>
</html>