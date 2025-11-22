<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm task deletion</title>
</head>
<body>

<h2 align="center">Are you sure you want to delete this task?</h2>

<table border="1" align="center" cellpadding="5">

    <tr>
        <td>
            <h3><%= request.getParameter("name") %></h3>
        </td>
    </tr>

    <tr>
        <td align="center">

            <!-- YES (Delete) -->
            <form action="deleteTask" method="post">
    <input type="hidden" name="index" value="<%= request.getParameter("index") %>">
    <input type="submit" value="Yes">
</form>

            <!-- NO (Cancel) -->
            <form action="TaskList.jsp" method="post">
                <input type="submit" value="No">
            </form>

        </td>
    </tr>

</table>

</body>
</html>
