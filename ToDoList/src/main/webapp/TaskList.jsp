<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.Model.Task"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task List</title>
</head>

<body>

<h2 align="center">This is your task list</h2>

<table border="1" align="center" cellpadding="5">
    <tr>
        <th>Task</th>
        <th>Modify</th>
        <th>Remove</th>
    </tr>

    <%
        List<Task> list = (List<Task>) request.getAttribute("tasks");
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Task t = list.get(i);
    %>

    <tr>
        <td><%= t.getName() %></td>

        <td>
            <!-- Modify button -->
            <form action="editTask" method="get">
                <input type="hidden" name="index" value="<%= i %>">
                <input type="submit" value="Modify">
            </form>
        </td>

        <td>
            <!-- Delete button -->
            <form action="DeleteConfirmation.jsp" method="post">
                <input type="hidden" name="index" value="<%= i %>">
                <input type="hidden" name="name" value="<%=t.getName()%>">
                <input type="submit" value="Remove">
            </form>
        </td>
    </tr>

    <%      }
        } else {
    %>

    <tr><td colspan="3">No tasks found.</td></tr>

    <% } %>

</table>

<br><br>
<div align="center">
    <a href="index.jsp">Back to Home</a>
</div>

</body>
</html>
