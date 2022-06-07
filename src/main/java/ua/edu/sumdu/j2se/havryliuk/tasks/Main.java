package ua.edu.sumdu.j2se.havryliuk.tasks;


import java.util.Arrays;

public class Main {

	public static void main(String[] args) {


		Task TestTask1 = new Task("Sleep", 74);
		Task TestTask11 = new Task("Visiting friends", 50);
		Task TestTask2 = new Task("Running", 10, 100, 20);
		Task TestTask22 = new Task("Play football", 10, 20, 10);
		Task TestTask23 = new Task("Play football", 5);
		TestTask22.setTitle("Play football with friends");
		TestTask22.setTime(10,40,10);
		TestTask1.setTime(30);
		TestTask11.setActive(true);
		TestTask2.setActive(true);
		Task ex0 = new Task("ex 0", 5);
		Task ex1 = new Task("ex 1", 5);
		Task ex2 = new Task("ex 2", 5);
		Task ex3 = new Task("ex 3", 5);
		Task ex4 = new Task("ex 4", 5);

		System.out.println(TestTask22.getRepeatInterval());
		System.out.println(TestTask1.getTitle());
		System.out.println(TestTask1.nextTimeAfter(15));
		System.out.println(TestTask11.nextTimeAfter(30));
		System.out.println(TestTask2.nextTimeAfter(30));

		ArrayTaskList List = new ArrayTaskList();
		List.add(TestTask1);
		List.add(TestTask2);
		List.add(TestTask11);
		List.add(TestTask11);
		List.remove(TestTask1);

		System.out.println("result " + List.incoming(30,100).getTask(1).getTitle());
		System.out.println(List.getTask(2).getStartTime());
		System.out.println(List.getTask(2).getTitle());
		System.out.println(List.size());

		LinkedTaskList lLIst = new LinkedTaskList();
		lLIst.add(TestTask2);
		lLIst.add(TestTask11);
		lLIst.add(TestTask11);
		lLIst.add(TestTask1);

		System.out.println(lLIst.remove(TestTask1));
		System.out.println(lLIst.getTask(1).getTitle());

		System.out.println("Total size " + lLIst.size());
		System.out.println(lLIst.incoming(30,100).getTask(0).getTitle());
	}
}