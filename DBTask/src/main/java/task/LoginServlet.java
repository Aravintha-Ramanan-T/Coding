package task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    static ArrayList<Employee> list = new ArrayList<>();  // ALWAYS initialized

    public void init() {

        try {
            String query = "SELECT * FROM employee";

        
            Connection con = DbConnection.dbConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pass = rs.getString("password");
                String role = rs.getString("role");

                Employee emp = new Employee(id, name, pass, role);
                list.add(emp);
//                rs.close();
//                ps.close();
//                con.close();
            }
        }
           
         
         catch (Exception e) {
            System.out.println("Error in init(): " + e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String username = req.getParameter("nam");
        String password = req.getParameter("pwd");

        // SAFETY CHECK
        if (list == null || list.isEmpty()) {
            System.out.println("Employee list is empty or null!");
            res.sendRedirect("Login.html");
            return;
        }

        for (Employee emp : list) {

            if (emp.getName().equals(username) && emp.getPassword().equals(password)) {

                if (emp.getRole().equals("admin")) {
                    res.sendRedirect("AdminHome.html");
                } else {
                    res.sendRedirect("UserHome.html");
                }
                return; 
            }
        }

        res.sendRedirect("Login.html");   // wrong credentials
    }
}
