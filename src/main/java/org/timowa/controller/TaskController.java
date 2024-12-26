package org.timowa.controller;

import org.timowa.database.entity.Task;
import org.timowa.database.repository.TaskRepository;
import org.timowa.service.TaskService;
import org.timowa.util.HibernateUtil;

import java.util.Scanner;

public class TaskController {
    public static void main(String[] args) {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession();
             var scanner = new Scanner(System.in)) {
            boolean q = false;

            var taskRepository = new TaskRepository(session);
            var taskService = new TaskService(taskRepository);

            session.beginTransaction();

            while (!q) {
                switch (scanner.nextLine()) {
                    case "q":
                        q = true;
                        break;
                    case "add task":
                        System.out.println("description:");
                        taskService.addTask(Task.builder().description(scanner.nextLine()).completed(false).build());
                        System.out.println("Done.");
                        break;
                    case "delete task by id":
                        System.out.println("id:");
                        if (taskService.deleteTaskById(scanner.nextLong()))
                            System.out.println("Done.");
                        break;
                }
            }

            session.getTransaction().commit();
        }
    }
}
