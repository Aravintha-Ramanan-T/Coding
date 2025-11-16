package task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	
	
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		

        String name = req.getParameter("uname");
        String password = req.getParameter("pwd");
        String role = "user";

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        try {
            
            Connection con = DbConnection.dbConnection();

            
            String query = "INSERT INTO employee (name,password,role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, role);

            
            int x = ps.executeUpdate();

            if (x > 0) {
                out.println("<h2>Employee Registered Successfully!</h2>");
                res.sendRedirect("Login.html");
            } else {
                out.println("<h2>Failed to register employee!</h2>");
            }

           // con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
}
        
        public void loadEmployees() {
          LoginServlet.list.clear();

            try {
                Connection con = DbConnection.dbConnection();
                String query = "SELECT * FROM employee";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                	 LoginServlet.list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("role")
                    ));
                }

               // con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    

          
	        
		}


