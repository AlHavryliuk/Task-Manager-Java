package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.AbstractTaskList;
import ua.edu.sumdu.j2se.havryliuk.tasks.controller.Controller;

import ua.edu.sumdu.j2se.havryliuk.tasks.view.ListView;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.View;



public class ListController implements Controller {

    View view = new ListView();


    @Override
    public void execute(AbstractTaskList abstractTaskList) {
        for (int i = 0; i < abstractTaskList.size(); i++) {
            System.out.println(" Task " + i + ". " + abstractTaskList.getTask(i));
        }
        view.printInfo();
        if (abstractTaskList.size() == 0) {
            System.out.println(" List is empty. ");
        }

    }
}
