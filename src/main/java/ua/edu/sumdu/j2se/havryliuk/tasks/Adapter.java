package ua.edu.sumdu.j2se.havryliuk.tasks;

import java.time.LocalDateTime;
import java.util.Scanner;

import static ua.edu.sumdu.j2se.havryliuk.tasks.SupportClass.scannerSwitch;

public class Adapter {

    Scanner altMethod = new Scanner(System.in);

    public static Task adapterAllTime () {
        System.out.println(" Enter name of the task ");
        String name = scannerSwitch.nextLine();
        LocalDateTime start = adapterStart();
        LocalDateTime end = adapterEnd();
        if (end.isBefore(start)) {
            System.out.println(" Incorrect date. ");
            return adapterAllTime();
        }
        System.out.println(" What about interval ?");
        int interval = inputNumMInterval();
        interval = interval * 120;
        return new Task(name,start,end,interval);
    }


    public static LocalDateTime adapterStart () {
        System.out.println(" Start Mount : ");
        int mount = inputNumMount();
        System.out.println(" Start Day : ");
        int day = inputNumDay();
        System.out.println(" Start Hours: ");
        int hoursStart = inputNumHours();
        System.out.println(" Start Minutes : ");
        int minutesStart = inputNumMinutes();
        LocalDateTime time = LocalDateTime.of(LocalDateTime.now().getYear(), mount, day,
                hoursStart, minutesStart, LocalDateTime.now().getSecond());
        return time;
    }
    public static LocalDateTime adapterEnd () {
        System.out.println(" End Mount : ");
        int mount = inputNumMount();
        System.out.println(" End Day : ");
        int day = inputNumDay();
        System.out.println(" End Hours: ");
        int hoursStart = inputNumHours();
        System.out.println(" End Minutes : ");
        int minutesStart = inputNumMinutes();
        LocalDateTime time = LocalDateTime.of(LocalDateTime.now().getYear(), mount, day,
                hoursStart, minutesStart, LocalDateTime.now().getSecond());
        return time;
    }


    public static LocalDateTime adapterTime () {
        int mount = LocalDateTime.now().getMonthValue();
        System.out.println("Day : ");
        int day = inputNumDay();
        if (day < LocalDateTime.now().getDayOfMonth()) {
            mount++;
        }
        System.out.println("Hours : ");
        int hours = inputNumHours();
        System.out.println("Minutes : ");
        int minutes = inputNumMinutes();
        LocalDateTime time = LocalDateTime.of(LocalDateTime.now().getYear(), mount, day,
                hours, minutes, LocalDateTime.now().getSecond());
        return time;
    }

    public static Task adapterLogicNoAlt () {

        System.out.println(" Enter the name of the task ");
        String nameOfTask = scannerSwitch.nextLine();
        int mount = LocalDateTime.now().getMonthValue();
        System.out.println("Day : ");
        int day = inputNumDay();
        if (day < LocalDateTime.now().getDayOfMonth()) {
            mount++;
        }
        System.out.println("Hours : ");
        int hours = inputNumHours();
        System.out.println("Minutes : ");
        int minutes = inputNumMinutes();
        LocalDateTime time = LocalDateTime.of(LocalDateTime.now().getYear(), mount, day,
                hours, minutes, LocalDateTime.now().getSecond());
        Task task = new Task(nameOfTask, time);
        System.out.println(" Create new Task is Successful \n");
        return task;

    }
    public static int inputNumMount () {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                int mount = in.nextInt();
                if (mount > 0 & mount < 13) {
                    return mount;
                }
            }
            System.out.println("Error, input correct int-value of mount!");
        }
    }
    public static int inputNumDay () {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                int numberDay = in.nextInt();
                if (numberDay > 0 & numberDay <= LocalDateTime.MAX.getDayOfMonth()) {
                    return numberDay;
                }
            }
            System.out.println("Error, input correct int-value of days!");
        }
    }
    public static int inputNumHours () {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                int numberHours = in.nextInt();
                if (numberHours >= 0 & numberHours < 24) {
                    return numberHours;
                }
            }
            System.out.println("Error, input correct int-value of hours!");
        }
    }

    public static int inputNumMinutes () {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                int numberMinutes = in.nextInt();
                if (numberMinutes >= 0 & numberMinutes < 60) {
                    return numberMinutes;
                }
            }
            System.out.println("Error, input correct  int-value of minutes!");
        }
    }
    public static int inputNumMInterval () {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                int interval = in.nextInt();
                if (interval > 0 ) {
                    return interval;
                }
            }
            System.out.println("Error, input correct int-value of minutes!");
        }
    }
}
