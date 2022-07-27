package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.AbstractTaskList;
import ua.edu.sumdu.j2se.havryliuk.tasks.Task;
import ua.edu.sumdu.j2se.havryliuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.havryliuk.tasks.utility.TimeUtility;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.impl.AddView;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.View;



import java.time.LocalDateTime;


public class AddController extends TimeUtility implements Controller {

    View view = new AddView();

    @Override
    public void execute(AbstractTaskList abstractTaskList) {

        view.printInfo();
        String repeatedTask = view.requestStringDate(" Yes or no ? ");
        repeatedTask = repeatedTask.toUpperCase()
                .replace(" ", "")
                .replace(".","");

        if (repeatedTask.equals("YES")) {
            adapterAllTime(abstractTaskList);
        } else if (repeatedTask.equals("NO"))  {
            adapterNoRepeat(abstractTaskList);
        } else {
            execute(abstractTaskList);
        }
    }


    public void adapterAllTime(AbstractTaskList abstractTaskList) {
        String nameOfTask = view.requestStringDate(" Enter name of the task : ");
        view.printCustomInfo(" Start time :");
        LocalDateTime start = alternativeTimeProcessing() /*adapterStart()*/;
        view.printCustomInfo(" End time :");
        LocalDateTime end = alternativeTimeProcessing() /*adapterEnd()*/;
        if (end.isBefore(start)) {
            view.printCustomInfo(" Incorrect date. ");
            adapterAllTime(abstractTaskList);
            return;
        }
        int interval = view.requestIntInterval(" Enter interval : ");
        interval = interval * 120;
        Task task = new Task(nameOfTask, start, end, interval);
        abstractTaskList.add(task);
    }


    public void adapterNoRepeat(AbstractTaskList abstractTaskList) {

        String nameOfTask = view.requestStringDate(" Enter the name of the task: ");
        LocalDateTime time = alternativeTimeProcessing();
        /*int mount = LocalDateTime.now().getMonthValue();
        int day = view.requestIntDay(" Enter day: ");
        if (day < LocalDateTime.now().getDayOfMonth()) {
            mount++;
            view.printCustomInfo(" Moving to next mount...");
        }
        int hours = view.requestIntHour(" Enter hours: ");
        int minutes = view.requestIntMinute(" Enter minutes: ");
        LocalDateTime time = LocalDateTime.of(LocalDateTime.now().getYear(), mount, day,
                hours, minutes, LocalDateTime.now().getSecond());*/
        view.printCustomInfo(" Create new Task is Successful. \n");
        Task task = new Task (nameOfTask, time);
        abstractTaskList.add(task);
    }
}
