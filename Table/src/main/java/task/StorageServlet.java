package task;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/storage")
public class StorageServlet extends HttpServlet {
	
	public static ArrayList <User> list = new ArrayList<>();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("nam");
		String password = request.getParameter("pwd");
		
		
		
		User u1 = new User(username, password);
		StorageServlet.list.add(u1);
		System.out.println(StorageServlet.list);
		response.sendRedirect("index.jsp");
		
//		 request.setAttribute("userList", list);
//	        request.getRequestDispatcher("Details.jsp").forward(request, response);
//		
	}
	
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
//	ArrayList <User> list1 = StorageServlet.list;
//		 response.sendRedirect("Details.jsp");
			System.out.println("do Get called");
		 request.setAttribute("userList", StorageServlet.list);
        request.getRequestDispatcher("Details.jsp").forward(request, response);
		
	}

}
