package ua.edu.sumdu.j2se.havryliuk.tasks.view;



public interface View {
    void printInfo ();
    String requestDataFromUser (String date);
    int requestInt(String date);
    int requestIntInterval(String date);
    int requestIntMount(String date);
    int requestIntDay(String date);
    int requestIntHour(String date);
    int requestIntMinute(String date);
    void printCustomInfo (String info);
}
