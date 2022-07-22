package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.*;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.impl.MainView;

import java.io.File;
import java.io.IOException;




public class MainController implements ua.edu.sumdu.j2se.havryliuk.tasks.controller.MainController {

    MainView mainView = new MainView();
    public AbstractTaskList array = new ArrayTaskList();




    /*public static void defaultView () throws IOException {
        System.out.println(" Check your number! \n");
        mainMenu();
    }*/
    public void mainLoading() throws IOException {
        while (true) {
            mainView.printInfo();
            int  number = mainView.requestInt(" Please select number ");
            switch (number){
                case (1) :
                    new AddController().execute(array);
                    break;
                case (2) :
                    new RemoveController().execute(array);
                    break;
                case (3) :
                    new EditController().execute(array);
                    break;
                case (4) :
                    new ListController().execute(array);
                    break;
                case (5) :
                    new IncomeController().execute(array);
                    break;
                case (6) :
                    new EscapeController().execute(array);
                default:
                    mainView.printCustomInfo(" Enter correct number. ");
            }
        }
    }

    @Override
    public void execute() {


        try {
            TaskIO.readBinary(array, new File("saveBinary"));
        } catch (NullPointerException ex) {
            array = new ArrayTaskList();
        }

        try {
            Thread thread = new Thread(new Notificator(array));
            thread.start();


            mainLoading();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // TODO: 22.07.2022 инициализация Task Менеджера и обработать выбор пользователя


    }
}
