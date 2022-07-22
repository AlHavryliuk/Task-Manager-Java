package ua.edu.sumdu.j2se.havryliuk.tasks;

import java.io.File;
import java.io.IOException;


import static ua.edu.sumdu.j2se.havryliuk.tasks.IsActiveController.checkActiveTask;
import static ua.edu.sumdu.j2se.havryliuk.tasks.ControllerCorrector.inputNum;
import static ua.edu.sumdu.j2se.havryliuk.tasks.MainController.*;


public class MainMenuView {

    public static ArrayTaskList array = new ArrayTaskList();

    public MainMenuView() {
        try {
            TaskIO.readBinary(array, new File("saveBinary"));
        } catch (NullPointerException ex) {
            array = new ArrayTaskList();
        }
    }

    public static void mainMenu() throws IOException {

        checkActiveTask();

        String startBlock = """
                1. Add task.\s
                2. Remove task.\s
                3. Edit task.\s
                4. Get task list.\s
                5. Get Calendar.
                6. Exit.""".indent(1);
        System.out.println(startBlock);

        int number = inputNum();

        switch (number){
            case (1) :
                addView();
            case (2) :
                removeView();
            case (3) :
                editView();
            case (4) :
                getListView();
            case (5) :
                calendarView();
            case (6) :
                escapeView();
            default:
                defaultView();
        }
    }


}
