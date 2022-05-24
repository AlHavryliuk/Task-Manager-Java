package ua.edu.sumdu.j2se.havryliuk.tasks;


import java.util.Arrays;

public class Main {

	public static void main(String[] args) {


		Task TestTask1 = new Task("Visiting doctor", 30);
		Task TestTask11 = new Task("Visiting friends", 50);
		Task TestTask2 = new Task("Running", 10, 100, 20);
		Task TestTask22 = new Task("Play football", 10, 20, 10);
		TestTask22.setTitle("Play football with friends");
		TestTask22.setTime(10,40,10);
		TestTask1.setTime(30);
		TestTask11.setActive(true);
		TestTask2.setActive(true);
		System.out.println(TestTask22.getRepeatInterval());
		System.out.println(TestTask1.nextTimeAfter(15));
		System.out.println(TestTask11.nextTimeAfter(30));
		System.out.println(TestTask2.nextTimeAfter(30));

		ArrayTaskList List = new ArrayTaskList();
		List.add(TestTask1);
		List.add(TestTask2);
		List.add(TestTask11);
		List.add(TestTask11);
		List.remove(TestTask1);

		System.out.println(List.incoming(30,100));

		System.out.println(List.getTask(2));
		System.out.println(List.size());
		System.out.println(List.getTask(1));


	}
}