import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;
    private int nextId;

    public TaskManager() {
        tasks = new ArrayList<>();
        nextId = 1;
    }

    public void addTask(String title) {
        Task task = new Task(nextId++, title);
        tasks.add(task);
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
                System.out.println("Task deleted successfully!");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}