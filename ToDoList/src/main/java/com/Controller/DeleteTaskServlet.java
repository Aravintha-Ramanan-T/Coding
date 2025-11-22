package com.Controller;

import java.io.IOException;

import com.Model.DAOClass;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String indexStr = req.getParameter("index");
        int index = Integer.parseInt(indexStr);

        DAOClass.deleteTask(index);

        res.sendRedirect("viewTasks");
    }
}
