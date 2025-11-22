package com.Controller;

import java.io.IOException;

import com.Model.DAOClass;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String taskName = req.getParameter("taskName");

        if (taskName != null && !taskName.trim().isEmpty()) {
            DAOClass.addTask(taskName.trim());
        }

        
        res.sendRedirect("viewTasks");
    }
}
