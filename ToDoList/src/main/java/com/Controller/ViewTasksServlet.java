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

@WebServlet("/viewTasks")
public class ViewTasksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<Task> list = DAOClass.getAllTasks();
        req.setAttribute("tasks", list);

        RequestDispatcher rd = req.getRequestDispatcher("TaskList.jsp");
        rd.forward(req, res);
    }
}
