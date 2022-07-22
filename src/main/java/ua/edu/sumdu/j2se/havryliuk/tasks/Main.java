package ua.edu.sumdu.j2se.havryliuk.tasks;

import java.io.IOException;


import static ua.edu.sumdu.j2se.havryliuk.tasks.MainMenuView.mainMenu;

public class Main {

    public static Notificator notificator;

    public static void main(String[] args) throws IOException {

        notificator = new Notificator();
        notificator.start();

        new MainMenuView();
        mainMenu();
    }
}
