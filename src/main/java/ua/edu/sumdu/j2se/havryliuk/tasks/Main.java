package ua.edu.sumdu.j2se.havryliuk.tasks;

import java.io.File;
import java.io.IOException;

import static ua.edu.sumdu.j2se.havryliuk.tasks.SupportClass.*;

public class Main {

    public static Notificator notificator;

    public static void main(String[] args) throws IOException {

        notificator = new Notificator();
        notificator.start();

        try {
            TaskIO.readBinary(array, new File("saveBinary"));
        } catch (NullPointerException ex){
            array = new ArrayTaskList();
        }
        mainSwitch((ArrayTaskList) array);
    }
}
