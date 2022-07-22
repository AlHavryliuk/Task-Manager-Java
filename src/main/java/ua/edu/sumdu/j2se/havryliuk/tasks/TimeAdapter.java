package ua.edu.sumdu.j2se.havryliuk.tasks;

import java.time.LocalDateTime;

import static ua.edu.sumdu.j2se.havryliuk.tasks.ControllerCorrector.*;

public class TimeAdapter {
    public static class Adapter {


        public static Task adapterAllTime() {
            System.out.println(" Enter name of the task ");
            String name = inputString();
            LocalDateTime start = adapterStart();
            LocalDateTime end = adapterEnd();
            if (end.isBefore(start)) {
                System.out.println(" Incorrect date. ");
                return adapterAllTime();
            }
            System.out.println(" What about interval ?");
            int interval = inputNumMInterval();
            interval = interval * 120;
            return new Task (name, start, end, interval);
        }


        public static LocalDateTime adapterStart() {
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

        public static LocalDateTime adapterEnd() {
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


        public static LocalDateTime adapterTime() {
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

        public static Task adapterLogicNoAlt() {

            System.out.println(" Enter the name of the task ");
            String nameOfTask = inputString();
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
    }
}
