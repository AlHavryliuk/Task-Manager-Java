package ua.edu.sumdu.j2se.havryliuk.tasks;


import java.io.*;


import java.time.LocalDateTime;
import java.util.Scanner;

import static ua.edu.sumdu.j2se.havryliuk.tasks.Adapter.*;


public class SupportClass {


    public static AbstractTaskList array = new ArrayTaskList();
    static Scanner scannerSwitch = new Scanner(System.in);


    public static Task addScanner() {


        String repeatedTask = scannerSwitch.nextLine();
        repeatedTask = repeatedTask.toUpperCase()
                .replace(" ", "")
                .replace(".","");

        if (repeatedTask.equals("YES")) {
            return adapterAllTime();
        } else if (repeatedTask.equals("NO"))  {
            return adapterLogicNoAlt();
        }
        System.out.println(" Yes or no ? ");
        return addScanner();
    }

    public static void removeScanner (ArrayTaskList array) throws IOException {

        int remove = inputNum();

        int back = array.size();

        if (remove > array.size()) {
            System.out.println(" Your number bigger than Task size. Please, try again. \n"
            + " You can enter '' " + back + " '' for back to main menu. ");
            removeScanner(array);
        } else if (back == remove) {
            mainSwitch(array);
        }
        array.remove(array.getTask(remove));
        array.Optimization();
        System.out.println("\n Successful. \n ");
    }

    public static void editScanner (ArrayTaskList array) throws IOException {

        Scanner editScanner = new Scanner(System.in);
        int scNumber = inputNum();

        if (scNumber >= 0 & scNumber < array.size()) {
            System.out.println(" Write new name ");
            String name = editScanner.nextLine();
            array.getTask(scNumber).setTitle(name);
            if (array.getTask(scNumber).isRepeated()){
                System.out.println(" Write new Start time ");
                LocalDateTime start = adapterStart();
                System.out.println(" Write new End time ");
                LocalDateTime end = adapterEnd();
                System.out.println(" Write new Interval ");
                int interval = editScanner.nextInt();
                interval = interval * 60 * 60;
                array.getTask(scNumber).setTime(start,end,interval);
                mainSwitch(array);
                System.out.println(" Successful !!!");
            }
            System.out.println(" Write new Time ");
            LocalDateTime time = adapterTime();
            array.getTask(scNumber).setTime(time);
            System.out.println(" Successful !!!");
        } else {
            mainSwitch(array);
        }
    }
    public static void calendar () {

        System.out.println(" Please, Enter start time ( Mount day hour minutes )");

        LocalDateTime adapterStart = adapterStart();
        System.out.println(" Please, Enter end time ( Mount day hour minutes )");

        LocalDateTime adapterEnd = adapterEnd();
        if (adapterStart.isAfter(adapterEnd)) {
            System.out.println(" Date of start is bigger than date of end ");
            calendar();
        }
        for (Task task : array) {
            task.turnIsActiveTrue();
        }
        System.out.println(Tasks.incoming(array, adapterStart, adapterEnd));
    }

    public static void checkEndTask (ArrayTaskList array) {
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

    public static boolean removeEndTask (int i) {
        Scanner endScanner = new Scanner(System.in);
        String repeatedTask = endScanner.nextLine();
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
    public static void checkActiveTask (){
        int count = 0;
        for (Task task: array) {
            if (task.getStartTime().isBefore(LocalDateTime.now()) |
                    task.getTime().isBefore(LocalDateTime.now())) {
                count++;
            }
            /*if (task.getStartTime().isBefore(LocalDateTime.now().plusMinutes(10)) & task.getStartTime().isAfter(LocalDateTime.now()) |
                    task.getTime().isBefore(LocalDateTime.now().plusMinutes(10)) & task.getTime().isAfter(LocalDateTime.now())) {
                System.out.println("Warning !!! Task ''" + task.getTitle() + "'' will be active soon !!! \n");
            }*/
        }
        if (count > 0 ) {
            System.out.println("\n The list contains overdue tasks. Counts = " + count + "\n");
        }
    }

    public static int inputNum () {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                int number = in.nextInt();
                return number;
            }
            System.out.println("Error, input int-value!");
        }
    }

    public static void mainSwitch(ArrayTaskList array) throws IOException {

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
                System.out.println("\n You choice create 'New task'. \n");
                System.out.println(" Your Task is repeating? ");
                array.add(addScanner());
                mainSwitch(array);
            case (2) :
                array.getTaskAll();
                System.out.println("Select number of task than you want to delete: \n");
                removeScanner(array);
                mainSwitch(array);
            case (3) :
                array.getTaskAll();
                System.out.println(" What task you want change ? If you want back to main menu, enter any number. ");
                editScanner(array);
            case (4) :
                System.out.println(" Your Task List : \n");
                array.getTaskAll();
                System.out.println(" What need doing ? \n");
                mainSwitch(array);
            case (5) :
                calendar();
                System.out.println(" Enter any number for continue ");
                inputNum();
                mainSwitch(array);
            case (6) :
                checkEndTask(array);
                TaskIO.writeBinary(array, new File("saveBinary"));
                TaskIO.writeText(array, new File("saveText"));
                System.out.println(" Program is finish ");
                System.exit(0);

            default:
                System.out.println(" Check your number! \n");
                mainSwitch(array);
        }

    }

}

