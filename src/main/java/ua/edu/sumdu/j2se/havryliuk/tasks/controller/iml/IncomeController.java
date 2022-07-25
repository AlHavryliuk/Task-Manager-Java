package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.AbstractTaskList;
import ua.edu.sumdu.j2se.havryliuk.tasks.Task;
import ua.edu.sumdu.j2se.havryliuk.tasks.Tasks;
import ua.edu.sumdu.j2se.havryliuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.havryliuk.tasks.utility.TimeUtility;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.impl.IncomeView;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.View;

import java.time.LocalDateTime;

public class IncomeController extends TimeUtility implements Controller {

    View view = new IncomeView();
    @Override
    public void execute(AbstractTaskList abstractTaskList) {
        view.printCustomInfo(" Please, Enter start time ( Mount day hour minutes )");

        LocalDateTime adapterStart = adapterStart();
        view.printCustomInfo(" Please, Enter end time ( Mount day hour minutes )");

        LocalDateTime adapterEnd = adapterEnd();
        if (adapterStart.isAfter(adapterEnd)) {
            System.out.println(" Date of start is bigger than date of end ");
            execute(abstractTaskList);
        }
        for (Task task : abstractTaskList) {
            task.turnIsActiveTrue();
        }
        view.printCustomInfo(String.valueOf(Tasks.incoming(abstractTaskList, adapterStart, adapterEnd)));
        view.printInfo();
    }
}
