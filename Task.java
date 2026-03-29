import java.io.Serializable;

public class Task implements Serializable {
    private int id;
    private String title;
    private boolean isCompleted;

    public Task(int id, String title, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public Task(int id, String title) {
        this(id, title, false);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return id + ". " + title + " [" + (isCompleted ? "Completed" : "Pending") + "]";
    }

    // Convert task to file format
    public String toFileString() {
        return id + "," + title + "," + isCompleted;
    }

    // Convert file line to task
    public static Task fromFileString(String line) {
        String[] parts = line.split(",");
        return new Task(
            Integer.parseInt(parts[0]),
            parts[1],
            Boolean.parseBoolean(parts[2])
        );
    }
}
}
