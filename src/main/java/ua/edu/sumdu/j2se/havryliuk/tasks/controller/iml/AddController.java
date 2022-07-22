package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.AbstractTaskList;
import ua.edu.sumdu.j2se.havryliuk.tasks.Task;
import ua.edu.sumdu.j2se.havryliuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.AddView;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.View;


import java.time.LocalDateTime;


public class AddController implements Controller {

    View view = new AddView();

    @Override
    public void execute(AbstractTaskList abstractTaskList) {

        String repeatedTask = view.requestDataFromUser(" Your Task is repeating ? ");
        repeatedTask = repeatedTask.toUpperCase()
                .replace(" ", "")
                .replace(".","");

        if (repeatedTask.equals("YES")) {
            abstractTaskList.add(adapterAllTime());
        } else if (repeatedTask.equals("NO"))  {
            abstractTaskList.add(adapterNoRepeat());
        } else {
            execute(abstractTaskList);
        }
    }

    public Task adapterAllTime() {
        String name = view.requestDataFromUser(" Enter name of the task : ");
        LocalDateTime start = adapterStart();
        LocalDateTime end = adapterEnd();
        if (end.isBefore(start)) {
            view.printCustomInfo(" Incorrect date. ");
            return adapterAllTime();
        }
        int interval = view.requestIntInterval(" Enter interval : ");
        interval = interval * 120;
        return new Task (name, start, end, interval);
    }
    public LocalDateTime adapterStart() {
        int mount = view.requestIntMount(" Enter start mount : ");
        int day = view.requestIntDay(" Enter start day : ");
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

    public Task adapterNoRepeat() {

        String nameOfTask = view.requestDataFromUser(" Enter the name of the task: ");
        int mount = LocalDateTime.now().getMonthValue();
        int day = view.requestIntDay(" Enter day: ");
        if (day < LocalDateTime.now().getDayOfMonth()) {
            mount++;
            view.printCustomInfo(" Moving to next mount...");
        }
        int hours = view.requestIntHour(" Enter hours: ");
        int minutes = view.requestIntMinute(" Enter minutes: ");
        LocalDateTime time = LocalDateTime.of(LocalDateTime.now().getYear(), mount, day,
                hours, minutes, LocalDateTime.now().getSecond());
        view.printCustomInfo(" Create new Task is Successful. \n");
        return new Task(nameOfTask, time);
    }
}
