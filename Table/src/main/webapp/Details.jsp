<%@ page import="java.util.ArrayList" %>
<%@ page import="task.User" %>

<html>
<body>
<h2>Employee Details</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>Username</th>
        <th>Password</th>
    </tr>

    <%
        ArrayList<User> list = (ArrayList<User>) request.getAttribute("userList");

        if (list != null) {
            for (User e : list) {
    %>
                <tr>
                    <td><%= e.getUsername() %></td>
                    <td><%= e.getPassword() %></td>
                </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
