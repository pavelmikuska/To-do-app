package sk.pavelmikuska.todoapp;

public class Task {
    private int id;
    private String task;
    private boolean completed;

    public Task(int id, String task) {
        this.id = id;
        this.task = task;
        completed = false;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
