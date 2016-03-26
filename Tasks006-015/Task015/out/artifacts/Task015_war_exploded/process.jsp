<%--
  Created by IntelliJ IDEA.
  User: neil
  Date: 26.03.16
  Time: 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prcess</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/process" method="POST">
    <p><textarea rows="10" cols="45" name="text"></textarea></p>
    <select name="operation">
        <option value="symbols">Количество символов</option>
        <option value="words">Количество слов</option>
        <option value="sentences">Количество предложений</option>
        <option value="pargraphs">Количество абзацей</option>
    </select>
    <p><input type="submit" value="Отправить"></p>
</form>
</body>
</html>
