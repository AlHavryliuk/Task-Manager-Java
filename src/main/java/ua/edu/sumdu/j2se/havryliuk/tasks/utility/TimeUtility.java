package ua.edu.sumdu.j2se.havryliuk.tasks.utility;

import ua.edu.sumdu.j2se.havryliuk.tasks.view.View;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.impl.AddView;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class TimeUtility {


    View view = new AddView();

    /*public LocalDateTime adapterStart() {

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
    }*/

    public LocalDateTime alternativeTimeProcessing () {
        while (true) {

            String tempTime = view.requestStringDate((" Enter your date in format: mm dd hh mm"));

            try {
                String[] timer = tempTime.split(" ");
                int year = LocalDateTime.now().getYear();
                int mount = Integer.parseInt(timer[0]);
                int day = Integer.parseInt(timer[1]);
                int hour = Integer.parseInt(timer[2]);
                int minutes = Integer.parseInt(timer[3]);
                return LocalDateTime.of(year, mount, day, hour, minutes);
            } catch (IllegalArgumentException | DateTimeException | ArrayIndexOutOfBoundsException ex) {
                System.out.println(" Incorrect format. Please try again. ");
            }
        }
    }
}
