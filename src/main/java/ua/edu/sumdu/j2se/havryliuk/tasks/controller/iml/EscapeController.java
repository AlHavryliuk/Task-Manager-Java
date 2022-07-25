package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.AbstractTaskList;
import ua.edu.sumdu.j2se.havryliuk.tasks.TaskIO;
import ua.edu.sumdu.j2se.havryliuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.View;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.impl.EscapeView;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import static ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml.MainController.logger;


public class EscapeController implements Controller {

    View view = new EscapeView();

    @Override
    public void execute(AbstractTaskList abstractTaskList) {
        checkEndTask(abstractTaskList);
        TaskIO.writeBinary(abstractTaskList, new File("saveBinary"));
        try {
            TaskIO.writeText(abstractTaskList, new File("saveText"));
        } catch (IOException e) {
            logger.error("Serialization error." , e);
            throw new RuntimeException(e);
        }
        view.printInfo();
        System.exit(0);
    }


    public void checkEndTask (AbstractTaskList abstractTaskList) {
        for (int i = 0; i < abstractTaskList.size(); i++) {
            if (abstractTaskList.getTask(i).isRepeated()) {
                if (abstractTaskList.getTask(i).getEndTime().isBefore(LocalDateTime.now())) {
                    view.printCustomInfo(" The list contains tasks that have expired. Do you want to remove them? ");
                    removeEndTask(abstractTaskList, i);
                }
            } else if (!abstractTaskList.getTask(i).isRepeated()) {
                if (abstractTaskList.getTask(i).getTime().isBefore(LocalDateTime.now())) {
                    view.printCustomInfo(" The list contains tasks that have expired. Do you want to remove them? ");
                    removeEndTask(abstractTaskList, i);
                }
            }
        }
    }

    public void removeEndTask (AbstractTaskList abstractTaskList, int i) {

        String repeatedTask = view.requestStringDate ( " Yes or no ? ");
        repeatedTask = repeatedTask.toUpperCase()
                .replace(" ", "")
                .replace(".","");

        if (repeatedTask.equals("YES")) {
            String name = abstractTaskList.getTask(i).getTitle();
            abstractTaskList.remove(abstractTaskList.getTask(i));
            view.printCustomInfo(" Removal was successful: " + name);
        } else if (repeatedTask.equals("NO"))  {
        }
    }
}
