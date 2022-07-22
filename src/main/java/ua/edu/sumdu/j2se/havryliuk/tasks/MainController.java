package ua.edu.sumdu.j2se.havryliuk.tasks;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;


import static ua.edu.sumdu.j2se.havryliuk.tasks.TimeAdapter.Adapter.*;
import static ua.edu.sumdu.j2se.havryliuk.tasks.IsActiveController.checkEndTask;
import static ua.edu.sumdu.j2se.havryliuk.tasks.ControllerCorrector.*;
import static ua.edu.sumdu.j2se.havryliuk.tasks.MainMenuView.array;
import static ua.edu.sumdu.j2se.havryliuk.tasks.MainMenuView.mainMenu;

public class MainController implements Controller{
    public static void addView() throws IOException {


        System.out.println("\n You choice create 'New task'. Your Task is repeating?\n");
        String repeatedTask = inputString();
        repeatedTask = repeatedTask.toUpperCase()
                .replace(" ", "")
                .replace(".","");

        if (repeatedTask.equals("YES")) {
            array.add(adapterAllTime());
            mainMenu();
        } else if (repeatedTask.equals("NO"))  {
            array.add(adapterLogicNoAlt());
            mainMenu();
        } else {
            System.out.println(" Try again. Yes or no ?");
            addView();
        }
    }

    public static void removeView () throws IOException {

        array.getTaskAll();
        System.out.println("Select number of task than you want to delete, or enter number more: " + array.size() + "" +
                ", for back to Main Menu. ");
        int remove = inputNum();
        if (remove < array.size() & remove >= 0) {
            array.remove(array.getTask(remove));
            array.optimization();
            System.out.println("\n Successful. \n ");
            mainMenu();
        } else {
            mainMenu();
        }
    }

    public static void editView () throws IOException {
        array.getTaskAll();
        System.out.println(" What task you want change ? If you want back to main menu, enter any number. ");
        int scNumber = inputNum();
        if (scNumber >= 0 & scNumber < array.size()) {
            System.out.println(" Write new name ");
            String name = inputString();
            array.getTask(scNumber).setTitle(name);
            if (array.getTask(scNumber).isRepeated()){
                System.out.println(" Write new Start time ");
                LocalDateTime start = adapterStart();
                System.out.println(" Write new End time ");
                LocalDateTime end = adapterEnd();
                System.out.println(" Write new Interval ");
                int interval = inputNumMInterval();
                interval = interval * 60 * 60;
                array.getTask(scNumber).setTime(start,end,interval);
                System.out.println(" Successful !!!");
                mainMenu();
            }
            System.out.println(" Write new Time ");
            LocalDateTime time = adapterTime();
            array.getTask(scNumber).setTime(time);
            System.out.println(" Successful !!!");
            mainMenu();
        } else {
            mainMenu();
        }
    }
    public static void getListView () throws IOException {
        array.getTaskAll();
        if (array.size() == 0) {
            System.out.println(" List is empty. ");
        }
        inputBack();
    }
    public static void calendarView() throws IOException {

        System.out.println(" Please, Enter start time ( Mount day hour minutes )");

        LocalDateTime adapterStart = adapterStart();
        System.out.println(" Please, Enter end time ( Mount day hour minutes )");

        LocalDateTime adapterEnd = adapterEnd();
        if (adapterStart.isAfter(adapterEnd)) {
            System.out.println(" Date of start is bigger than date of end ");
            calendarView();
        }
        for (Task task : array) {
            task.turnIsActiveTrue();
        }
        System.out.println(Tasks.incoming(array, adapterStart, adapterEnd));
        inputBack();
    }
    public static void escapeView() throws IOException {

        checkEndTask();
        TaskIO.writeBinary(array, new File("saveBinary"));
        TaskIO.writeText(array, new File("saveText"));
        System.out.println(" Program is finish ");
        System.exit(0);
    }

    public static boolean removeEndTask (int i) {

        String repeatedTask = inputString();
        repeatedTask = repeatedTask.toUpperCase()
                .replace(" ", "")
                .replace(".","");

        if (repeatedTask.equals("YES")) {
            String name = array.getTask(i).getTitle();
            array.remove(array.getTask(i));
            System.out.println(" Removal was successful: " + name);
            return true;
        } else if (repeatedTask.equals("NO"))  {
            return false;
        }
        return removeEndTask(i);
    }

    public static void defaultView () throws IOException {
        System.out.println(" Check your number! \n");
        mainMenu();
    }
}
