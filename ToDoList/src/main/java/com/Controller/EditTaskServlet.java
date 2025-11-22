package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Model.DAOClass;
import com.Model.Task;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editTask")
public class EditTaskServlet extends HttpServlet {

    
   
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String indexStr = req.getParameter("index");
        int index = Integer.parseInt(indexStr);

        List<Task> list = DAOClass.getAllTasks();
        Task t = list.get(index);

        req.setAttribute("index", index);
        req.setAttribute("taskName", t.getName());

        RequestDispatcher rd = req.getRequestDispatcher("ModifyTask.jsp");
        rd.forward(req, res);
    }

    
   
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int index = Integer.parseInt(req.getParameter("index"));
        String newName = req.getParameter("taskName");

        if (newName != null && !newName.trim().isEmpty()) {
            DAOClass.updateTask(index, newName.trim());
        }

        res.sendRedirect("viewTasks");
    }
}
