package ua.edu.sumdu.j2se.havryliuk.tasks.controller.iml;

import ua.edu.sumdu.j2se.havryliuk.tasks.AbstractTaskList;
import ua.edu.sumdu.j2se.havryliuk.tasks.controller.Controller;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.RemoveView;
import ua.edu.sumdu.j2se.havryliuk.tasks.view.View;



public class RemoveController implements Controller {

    View view = new RemoveView();


    @Override
    public void execute(AbstractTaskList abstractTaskList) {
        for (int i = 0; i < abstractTaskList.size(); i++) {
            System.out.println(" Task " + i + ". " + abstractTaskList.getTask(i));
        }
        view.printInfo();
        int remove = view.requestInt(" ");
        if (remove < abstractTaskList.size() & remove >= 0) {
            abstractTaskList.remove(abstractTaskList.getTask(remove));
            view.printCustomInfo(" Successful \n");
        }
    }
}
