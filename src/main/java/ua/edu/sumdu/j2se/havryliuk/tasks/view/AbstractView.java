package ua.edu.sumdu.j2se.havryliuk.tasks.view;


import ua.edu.sumdu.j2se.havryliuk.tasks.myexeptions.IncorrectIntervalEnteredException;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.impl.ViewCorrector;

import java.util.Scanner;

public abstract class AbstractView extends ViewCorrector implements View {

    static Scanner scanner = new Scanner(System.in);

    public String requestStringDate(String date) {
        System.out.println(date);
        return inputString();
    }
    public int requestInt(String date) {
        System.out.println(date);
        return inputNum();
    }
    public int requestIntInterval(String date) {
        System.out.println(date);
        try {
            return inputNumMInterval();
        } catch (IncorrectIntervalEnteredException e) {
            System.err.println(" The entered value is zero or less. The interval took the default value of 8 hours. ");

        }
        return 8;
    }
    /*public int requestIntMount(String date) {
        System.out.println(date);
        return inputNumMount();
    }
    public int requestIntDay(String date) {
        System.out.println(date);
        return inputNumDay();
    }
    public int requestIntHour(String date) {
        System.out.println(date);
        return inputNumHours();
    }
    public int requestIntMinute(String date) {
        System.out.println(date);
        return inputNumMinutes();
    }
*/
    public void printCustomInfo(String info) {
        System.out.println(info);
    }

}
