package ua.edu.sumdu.j2se.havryliuk.tasks.view.impl;

import java.time.LocalDateTime;
import java.util.Scanner;


public class ViewCorrector {
    public int inputNum () {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                //todo remove in.nextInt();
                int number = in.nextInt();
                return number;
            }
            System.out.println("Error, input int-value!");
        }
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
    public int inputNumDay () {
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
    public int inputNumHours () {
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

    public int inputNumMinutes () {
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
    public int inputNumMInterval () {
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

    public String inputString () {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextLine()) {
                String name = in.nextLine();
                if (!name.isEmpty() ) {
                    return name;
                }
            }
            System.out.println("Error, input correct String - value!");
        }
    }
}
