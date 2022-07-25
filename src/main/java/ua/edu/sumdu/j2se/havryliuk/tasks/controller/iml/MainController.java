package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.havryliuk.tasks.*;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.impl.MainView;

import java.io.IOException;




public class MainController implements ua.edu.sumdu.j2se.havryliuk.tasks.controller.MainController {

    public final static Logger logger = Logger.getLogger(MainController.class);
    MainView mainView = new MainView();
    public AbstractTaskList abstractTaskList = new ArrayTaskList();


    public void mainLoading() throws IOException {
        while (true) {
            mainView.printInfo();
            int  number = mainView.requestInt(" Please select number ");
            switch (number){
                case (1) :
                    new AddController().execute(abstractTaskList);
                    break;
                case (2) :
                    new RemoveController().execute(abstractTaskList);
                    break;
                case (3) :
                    new EditController().execute(abstractTaskList);
                    break;
                case (4) :
                    new ListController().execute(abstractTaskList);
                    break;
                case (5) :
                    new IncomeController().execute(abstractTaskList);
                    break;
                case (6) :
                    new EscapeController().execute(abstractTaskList);
                default:
                    mainView.printCustomInfo(" Enter correct number. ");
            }
        }
    }

    @Override
    public void runApp() {


        new InitializationController().execute(abstractTaskList);

        try {
            Thread thread = new Thread(new Notificator(abstractTaskList));
            thread.start();
            mainLoading();
        } catch (IOException ex) {
            logger.error(" RunApp error. " , ex);
            new EscapeController().execute(abstractTaskList);
            throw new RuntimeException(ex);
        }

        // TODO: 22.07.2022 инициализация Task Менеджера и обработать выбор пользователя

    }
}
