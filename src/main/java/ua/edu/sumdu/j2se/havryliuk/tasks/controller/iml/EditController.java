package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.AbstractTaskList;
import ua.edu.sumdu.j2se.havryliuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.EditView;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.View;

import java.time.LocalDateTime;




public class EditController implements Controller {

    View view = new EditView();


    @Override
    public void execute(AbstractTaskList abstractTaskList) {
        for (int i = 0; i < abstractTaskList.size(); i++) {
            System.out.println(" Task " + i + ". " + abstractTaskList.getTask(i));
        }
        view.printInfo();
        int scNumber = view.requestInt(" ");
        if (scNumber >= 0 & scNumber < abstractTaskList.size()) {
            String name = view.requestDataFromUser(" Write new name: ");
            abstractTaskList.getTask(scNumber).setTitle(name);
            if (abstractTaskList.getTask(scNumber).isRepeated()){
                view.printCustomInfo(" Write new Start time ");
                LocalDateTime start = adapterStart();
                view.printCustomInfo(" Write new End time ");
                LocalDateTime end = adapterEnd();
                view.printCustomInfo(" Write new Interval ");
                int interval = view.requestIntInterval(" ");
                interval = interval * 60 * 60;
                abstractTaskList.getTask(scNumber).setTime(start,end,interval);
                view.printCustomInfo(" Successful !!!");
            }
            view.printCustomInfo(" Write new Time ");
            LocalDateTime time = adapterTime();
            abstractTaskList.getTask(scNumber).setTime(time);
            view.printCustomInfo(" Successful !!!");
        }
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
    public LocalDateTime adapterTime() {
        int mount = LocalDateTime.now().getMonthValue();
        int day = view.requestIntDay(" Enter day: ");
        if (day < LocalDateTime.now().getDayOfMonth()) {
            mount++;
        }
        int hours = view.requestIntHour(" Enter hours: ");
        int minutes = view.requestIntMinute(" Enter minutes: ");
        LocalDateTime time = LocalDateTime.of(LocalDateTime.now().getYear(), mount, day,
                hours, minutes, LocalDateTime.now().getSecond());
        return time;
    }
}
