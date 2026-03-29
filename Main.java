import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n==== Task Manager ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    manager.addTask(title);
                    break;

                case 2:
                    manager.viewTasks();
                    break;

                case 3:
                    System.out.print("Enter task ID to mark complete: ");
                    int completeId = scanner.nextInt();
                    manager.markTaskCompleted(completeId);
                    break;

                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteTask(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}