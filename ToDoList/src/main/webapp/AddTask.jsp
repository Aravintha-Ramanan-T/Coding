<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Task</title>
</head>
<body>
<form align="center" action="addTask" method="post">
    <h2>You can add your new task here!</h2>
    <label>Mention your task</label>
    <input type="text" name="taskName" required /> <br><br>
    <input type="submit" value="Add Task"/>
    <br><br>
    <a href="Home.jsp">Back to Home</a>
</form>
</body>
</html>
