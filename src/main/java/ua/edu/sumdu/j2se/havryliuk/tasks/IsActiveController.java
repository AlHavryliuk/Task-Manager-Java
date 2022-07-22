package ua.edu.sumdu.j2se.havryliuk.tasks;

import java.time.LocalDateTime;

import static ua.edu.sumdu.j2se.havryliuk.tasks.MainMenuView.array;
import static ua.edu.sumdu.j2se.havryliuk.tasks.MainController.removeEndTask;


public class IsActiveController {
    public static void checkActiveTask (){
        int count = 0;
        for (Task task: array) {
            if (task.getStartTime().isBefore(LocalDateTime.now()) |
                    task.getTime().isBefore(LocalDateTime.now())) {
                count++;
            }
        }
        if (count > 0 ) {
            System.out.println("\n The list contains overdue tasks. Counts = " + count + "\n");
        }
    }
    public static void checkEndTask () {
        for (int i = 0; i < array.size(); i++) {
            if (array.getTask(i).isRepeated()) {
                if (array.getTask(i).getEndTime().isBefore(LocalDateTime.now())) {
                    System.out.println(" The list contains tasks that have expired. Do you want to remove them? ");
                    removeEndTask(i);
                }
            } else if (!array.getTask(i).isRepeated()) {
                if (array.getTask(i).getTime().isBefore(LocalDateTime.now())) {
                    System.out.println(" The list contains tasks that have expired. Do you want to remove them? ");
                    removeEndTask(i);
                }
            }
        }
    }
}
