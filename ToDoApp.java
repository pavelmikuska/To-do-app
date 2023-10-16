package sk.pavelmikuska.referencie.todoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoApp {
    private List<Task> tasks;
    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println(">>>  TO-DO APP  <<<");

        tasks = new ArrayList<>();
        String option = "";
        while (!option.equals("3")) {
            showMenu();
            showAllTasks(tasks);
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    tasks.add(createTask());
                    break;
                case "2":
                    completeTask(tasks);
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
        System.out.println("\n=======================================================");
        System.out.println(" MENU: [1] - Add task, [2] - Mark completed, [3] - End");
        System.out.println("=======================================================");
    }

    public Task createTask() {
        System.out.println("Enter task:");
        String task = scanner.nextLine();
        return new Task(tasks.size()+1, task);
    }

    public void showAllTasks(List<Task> tasks) {
//        int id = 1;
//        boolean completed = false;
//        String task = "Vyniest smeti";
        System.out.println("    NO.\tCOMPLETED\tTASK");
        System.out.println("    ---------------------------------------------------");
        for (Task task: tasks) {
            System.out.print("    " + task.getId() + "\t");
            if (task.isCompleted()) {
                System.out.print("COMPLETED");
            } else {
                System.out.print(".........");
            }
            System.out.print("\t" + task.getTask() + "\n");
        }
        System.out.println();
    }

    private void completeTask(List<Task> tasks) {
        int id;
        boolean isSelected = false;
        while (!isSelected) {
            System.out.println("Enter number (No.) of task you want to mark complete");
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
