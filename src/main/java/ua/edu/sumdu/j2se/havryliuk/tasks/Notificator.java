package ua.edu.sumdu.j2se.havryliuk.tasks;

import java.time.LocalDateTime;

public class Notificator implements Runnable {
    private AbstractTaskList abstractTaskList;
    public Notificator(AbstractTaskList abstractTaskList) {
        this.abstractTaskList = abstractTaskList;
    }

    public void run () {
        while (true) {
            for (Task task : abstractTaskList) {
                if (task.getStartTime().isBefore(LocalDateTime.now().plusMinutes(10)) & task.getStartTime().isAfter(LocalDateTime.now())|
                        task.getTime().isBefore(LocalDateTime.now().plusMinutes(10)) & task.getTime().isAfter(LocalDateTime.now())) {
                    if (task.isRepeated()) {
                        System.out.println("Warning !!! Task ''" + task.getTitle() + "'' will be active after: " +
                                (task.getTime().minusMinutes(LocalDateTime.now().getMinute()).getMinute()) + " minutes");
                    } else {
                        System.out.println("Warning !!! Task ''" + task.getStartTime() + "'' will be active after: " +
                                (task.getStartTime().minusMinutes(LocalDateTime.now().getMinute()).getMinute()) + " minutes");
                    }
                }
            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
