package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.AbstractTaskList;
import ua.edu.sumdu.j2se.havryliuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.havryliuk.tasks.utility.TimeUtility;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.impl.EditView;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.View;

import java.time.LocalDateTime;




public class EditController extends TimeUtility implements Controller {

    View view = new EditView();


    @Override
    public void execute(AbstractTaskList abstractTaskList) {
        for (int i = 0; i < abstractTaskList.size(); i++) {
            System.out.println(" Task " + i + ". " + abstractTaskList.getTask(i));
        }
        view.printInfo();
        int scNumber = view.requestInt(" ");
        if (scNumber >= 0 & scNumber < abstractTaskList.size()) {
            String name = view.requestStringDate(" Write new name: ");
            abstractTaskList.getTask(scNumber).setTitle(name);
            if (abstractTaskList.getTask(scNumber).isRepeated()){
                view.printCustomInfo(" Write new Start time ");
                LocalDateTime start = alternativeTimeProcessing() /*adapterStart()*/;
                view.printCustomInfo(" Write new End time ");
                LocalDateTime end = alternativeTimeProcessing() /*adapterEnd()*/;
                view.printCustomInfo(" Write new Interval ");
                int interval = view.requestIntInterval(" ");
                interval = interval * 60 * 60;
                abstractTaskList.getTask(scNumber).setTime(start,end,interval);
                view.printCustomInfo(" Successful !!!");
            }
            view.printCustomInfo(" Write new Time ");
            LocalDateTime time = alternativeTimeProcessing() /*adapterTime()*/;
            abstractTaskList.getTask(scNumber).setTime(time);
            view.printCustomInfo(" Successful !!!");
        }
    }
}
