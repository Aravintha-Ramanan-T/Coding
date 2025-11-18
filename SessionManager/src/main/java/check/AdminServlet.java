package check;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet 
{	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		
		if(session == null || session.getAttribute("username") == null)
		{
			res.sendRedirect("login.html");
			return;
		}
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String username = (String) session.getAttribute("username");
		out.println(String.format("<h1> welcome admin  %s </h1>",username));
		out.println("<a href='logout'>Logout</a>");
	}
}

