package check;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/sample")
public class SampleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		Cookie a = new Cookie("password1", "123");
		a.setMaxAge(4);
		a.setHttpOnly(true);
		a.setPath("/admin"); 
		a.setSecure(true);
		
		
		res.addCookie(a);
	}

}
