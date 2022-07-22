package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.AbstractTaskList;
import ua.edu.sumdu.j2se.havryliuk.tasks.Task;
import ua.edu.sumdu.j2se.havryliuk.tasks.TaskIO;
import ua.edu.sumdu.j2se.havryliuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.EscapeView;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.View;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;


import static ua.edu.sumdu.j2se.havryliuk.tasks.view.ViewCorrector.inputString;


public class EscapeController implements Controller {

    View view = new EscapeView();

    @Override
    public void execute(AbstractTaskList abstractTaskList) {
        checkEndTask(abstractTaskList);
        TaskIO.writeBinary(abstractTaskList, new File("saveBinary"));
        try {
            TaskIO.writeText(abstractTaskList, new File("saveText"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        view.printCustomInfo(" Program is finished. ");
        System.exit(0);
    }
    public static void checkActiveTask (AbstractTaskList abstractTaskList){
        int count = 0;
        for (Task task: abstractTaskList) {
            if (task.getStartTime().isBefore(LocalDateTime.now()) |
                    task.getTime().isBefore(LocalDateTime.now())) {
                count++;
            }
        }
        if (count > 0 ) {
            System.out.println("\n The list contains overdue tasks. Counts = " + count + "\n");
        }
    }
    public static void checkEndTask (AbstractTaskList abstractTaskList) {
        for (int i = 0; i < abstractTaskList.size(); i++) {
            if (abstractTaskList.getTask(i).isRepeated()) {
                if (abstractTaskList.getTask(i).getEndTime().isBefore(LocalDateTime.now())) {
                    System.out.println(" The list contains tasks that have expired. Do you want to remove them? ");
                    removeEndTask(abstractTaskList, i);
                }
            } else if (!abstractTaskList.getTask(i).isRepeated()) {
                if (abstractTaskList.getTask(i).getTime().isBefore(LocalDateTime.now())) {
                    System.out.println(" The list contains tasks that have expired. Do you want to remove them? ");
                    removeEndTask(abstractTaskList, i);
                }
            }
        }
    }
    public static boolean removeEndTask (AbstractTaskList abstractTaskList, int i) {

        String repeatedTask = inputString();
        repeatedTask = repeatedTask.toUpperCase()
                .replace(" ", "")
                .replace(".","");

        if (repeatedTask.equals("YES")) {
            String name = abstractTaskList.getTask(i).getTitle();
            abstractTaskList.remove(abstractTaskList.getTask(i));
            System.out.println(" Removal was successful: " + name);
            return true;
        } else if (repeatedTask.equals("NO"))  {
            return false;
        }
        return removeEndTask(abstractTaskList, i);
    }
}
