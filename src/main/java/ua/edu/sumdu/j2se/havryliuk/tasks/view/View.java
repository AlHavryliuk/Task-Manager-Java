package ua.edu.sumdu.j2se.havryliuk.tasks.view;


//todo принцип DRY тут ты достаешь инт многоми действиями чего не стоит делать
// т.к. по факту это один и тот же код

public interface View {
    void printInfo();
    int requestInt(String date);

    String requestStringDate (String date);
    int requestIntInterval(String date);
    /*int requestIntMount (String date);
    int requestIntDay (String date);
    int requestIntHour (String date);
    int requestIntMinute (String date);*/
    void printCustomInfo (String info);

}
