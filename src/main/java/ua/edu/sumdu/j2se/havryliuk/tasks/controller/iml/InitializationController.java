package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.AbstractTaskList;
import ua.edu.sumdu.j2se.havryliuk.tasks.TaskIO;
import ua.edu.sumdu.j2se.havryliuk.tasks.controller.Controller;

import java.io.File;

public class InitializationController implements Controller {



    @Override
    public void execute(AbstractTaskList abstractTaskList) {
        TaskIO.readBinary(abstractTaskList, new File("saveBinary"));
        if (abstractTaskList.size() == 0) {
            System.out.println(" Task list not found. A new task list has been created. \n");
        } else {
            System.out.println(" The task list completed successfully. And it was loaded. \n");
        }
    }
}
