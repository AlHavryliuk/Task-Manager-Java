package ua.edu.sumdu.j2se.havryliuk.tasks.view.impl;


import ua.edu.sumdu.j2se.havryliuk.tasks.view.AbstractView;

public class IncomeView extends AbstractView {

    @Override
    public void printInfo() {
        printCustomInfo(" Enter any key for continue ");
        requestStringDate(" ");
    }
}
