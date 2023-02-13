<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>Users</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Users</h2>
<br>
<form method="post" action="users">
    <p>Выбор пользователя:</p>
    <p><select name="selectedUser">
        <option disabled selected>Select user</option>
        <option value="1">admin</option>
        <option value="2">user</option>
    </select></p>
    <p><input type="submit" value="Подтвердить"></p>
    <button onclick="window.history.back()" type="button">Cancel</button>
</form>
</body>
</html>