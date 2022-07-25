package ua.edu.sumdu.j2se.havryliuk.tasks.view.impl;


import ua.edu.sumdu.j2se.havryliuk.tasks.view.AbstractView;

public class RemoveView extends AbstractView {

    @Override
    public void printInfo() {
        System.out.println("Select number of task than you want to delete, or enter number more: ");
    }
}
