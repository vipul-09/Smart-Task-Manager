import java.util.ArrayList;
import java.io.*;

public class TaskManager {
    private ArrayList<Task> tasks;
    private int nextId;
    private final String FILE_NAME = "tasks.txt";

    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasks();
    }

    public void addTask(String title) {
        Task task = new Task(nextId++, title);
        tasks.add(task);
        saveTasks();
        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void markTaskCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markCompleted();
                saveTasks();
                System.out.println("Task marked as completed!");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                saveTasks();
                System.out.println("Task deleted successfully!");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // Save tasks to file
    private void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    // Load tasks from file
    private void loadTasks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            nextId = 1;
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int maxId = 0;

            while ((line = reader.readLine()) != null) {
                Task task = Task.fromFileString(line);
                tasks.add(task);
                if (task.getId() > maxId) {
                    maxId = task.getId();
                }
            }

            nextId = maxId + 1;

        } catch (IOException e) {
            System.out.println("Error loading tasks.");
        }
    }
}

    
