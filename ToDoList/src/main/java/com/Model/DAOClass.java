package com.Model;

import java.util.ArrayList;
import java.util.List;

public class DAOClass {

    // In-memory storage
    private static ArrayList<Task> tasks = new ArrayList<>();

    // Add a new task
    public static void addTask(String name) {
        tasks.add(new Task(name));
    }

    // Get all tasks
    public static List<Task> getAllTasks() {
        return tasks;
    }

    // Update task at index
    public static void updateTask(int index, String newName) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setName(newName);
        }
    }

    // Delete task at index
    public static void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
}