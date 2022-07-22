package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.AbstractTaskList;
import ua.edu.sumdu.j2se.havryliuk.tasks.Task;
import ua.edu.sumdu.j2se.havryliuk.tasks.Tasks;
import ua.edu.sumdu.j2se.havryliuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.IncomeView;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.View;

import java.time.LocalDateTime;

public class IncomeController implements Controller {

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
    public LocalDateTime adapterStart() {
        int mount = view.requestIntMount(" Enter start mount: ");
        int day = view.requestIntDay(" Enter start day: ");
        int hoursStart = view.requestIntHour(" Enter start hours: ");
        int minutesStart = view.requestIntMinute(" Enter start minutes: ");
        LocalDateTime time = LocalDateTime.of(LocalDateTime.now().getYear(), mount, day,
                hoursStart, minutesStart, LocalDateTime.now().getSecond());
        return time;
    }

    public LocalDateTime adapterEnd() {

        int mount = view.requestIntMount(" Enter end mount: ");
        int day = view.requestIntDay(" Enter end day: ");
        int hoursStart = view.requestIntHour(" Enter end hours: ");
        int minutesStart = view.requestIntMinute(" Enter end minutes: ");
        LocalDateTime time = LocalDateTime.of(LocalDateTime.now().getYear(), mount, day,
                hoursStart, minutesStart, LocalDateTime.now().getSecond());
        return time;
    }
}
