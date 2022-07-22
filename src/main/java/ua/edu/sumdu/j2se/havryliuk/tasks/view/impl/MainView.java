package ua.edu.sumdu.j2se.havryliuk.tasks.view.impl;

import ua.edu.sumdu.j2se.havryliuk.tasks.view.AbstractView;


public class MainView extends AbstractView {


    @Override
    public void printInfo() {
        String startBlock = """
                1. Add task.\s
                2. Remove task.\s
                3. Edit task.\s
                4. Get task list.\s
                5. Get Calendar.
                6. Exit.""".indent(1);
        System.out.println(startBlock);
    }


}
