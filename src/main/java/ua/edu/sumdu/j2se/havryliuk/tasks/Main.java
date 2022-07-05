package ua.edu.sumdu.j2se.havryliuk.tasks;


import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws IOException {


        Task TestTask  = new Task("Task 1", LocalDateTime.now().plusSeconds(0));
        Task TestTask1 = new Task("Task 2", LocalDateTime.now().plusSeconds(0));
        Task TestTask2 = new Task("Task 3", LocalDateTime.now().plusSeconds(0));
        Task TestTask3 = new Task("Task 4", LocalDateTime.now().plusSeconds(0));

        AbstractTaskList arrayWrite = new ArrayTaskList();
        AbstractTaskList arrayRead = new ArrayTaskList();

        arrayWrite.add(TestTask);
        arrayWrite.add(TestTask1);
        arrayWrite.add(TestTask2);
        arrayWrite.add(TestTask3);

        TaskIO.writeText(arrayWrite, new File("TestArrayWithLocalDate"));
        System.out.println("Write successful");
        TaskIO.readText(arrayRead, new File("TestArrayWithLocalDate"));

    }
}
