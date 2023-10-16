package sk.pavelmikuska.todoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoApp {
    private List<Task> tasks;
    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("                          >>>   TO-DO APP   <<<");
        System.out.println("==============================================================================");
        System.out.println(" # Instructions:");
        System.out.println(" # To navigate the app enter the option number to the console and press Enter");

        tasks = new ArrayList<>();
        String option = "";
        while (!option.equals("3")) {
            showMenu();
            showAllTasks();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    tasks.add(createTask());
                    break;
                case "2":
                    completeTask();
                    break;
                case "3":
                    System.out.println("Closing application...");
                    break;
                default:
                    System.out.println("Incorrect input. To select menu option enter number 1, 2 or 3.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n==============================================================================");
        System.out.println("OPTIONS:  [1] Add task,  [2] Mark completed,  [3] End");
        System.out.println("==============================================================================");
    }

    private Task createTask() {
        System.out.println("Enter task:");
        String task = scanner.nextLine();
        if (tasks.size() == 0)
            return new Task(1, task);
        return new Task(tasks.size()+1, task);
    }

    private void showAllTasks() {
        System.out.println("    NO.\t  STATUS   \t\tTASK");
        System.out.println("    --------------------------------------------------------------------------");
        for (Task task: tasks) {
            System.out.print("    " + task.getId() + "\t");
            if (task.isCompleted()) {
                System.out.print("[COMPLETED]");
            } else {
                System.out.print("[  to-do  ]");
            }
            System.out.print("\t\t" + task.getTask() + "\n");
        }
        System.out.println();
    }

    private void completeTask() {
        int id;
        boolean isSelected = false;
        if (tasks.size() == 0) {
            System.out.println("There are no tasks yet. First, create a task.");
            isSelected = true;
        }
        while (!isSelected) {
            System.out.println("Enter number of task you want to mark as completed and press Enter");
            String number = scanner.nextLine();
            try {
                id = Integer.parseInt(number);
                for (Task task : tasks) {
                    if (task.getId() == id) {
                        task.setCompleted(true);
                        isSelected = true;
                        break;
                    }
                }
                if (!isSelected) {
                    System.out.println("Incorrect task number");
                }
            } catch (Exception e) {
                System.out.println("Enter only whole numbers!");
            }
        }
    }
}
