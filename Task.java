package sk.pavelmikuska.todoapp;

public class Task {
    private int id;
    private String task;
    private boolean isCompleted;

    public Task(int id, String task) {
        this.id = id;
        this.task = task;
        isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }
}
