<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Task</title>
</head>
<body>
<form align="center" action="editTask" method="post">
    <h2>You can modify your task here!</h2>

    <%
        Integer index = (Integer) request.getAttribute("index");
        String taskName = (String) request.getAttribute("taskName");
    %>

    <input type="hidden" name="index" value="<%= index %>">
    <input type="text" name="taskName" value="<%= taskName %>" required />
    <br><br>
    <input type="submit" value="Save Changes"/>
    <br><br>
    <a href="viewTasks">Back to List</a>
</form>
</body>
</html>
