package ua.edu.sumdu.j2se.havryliuk.tasks.view;



public class IncomeView extends AbstractView {

    @Override
    public void printInfo() {
        printCustomInfo(" Enter any key for continue ");
        requestDataFromUser(" ");
    }
}
