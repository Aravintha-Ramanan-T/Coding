package check;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req ,HttpServletResponse res) throws IOException, ServletException
	{	
		HttpSession session = req.getSession(false);
		
		if(session != null && session.getAttribute("username") != null)
		{
			res.sendRedirect("admin");
		}
		else
		{
			res.sendRedirect("Login.html");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(username != null && password != null)
		{
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(10);
			
			session.setAttribute("username", username);
			
			res.sendRedirect("admin");
		}
		else 
        {
            res.getWriter().println("<h3>Invalid username or password</h3>");
            req.getRequestDispatcher("login.html").include(req, res);
        }
	}
}





