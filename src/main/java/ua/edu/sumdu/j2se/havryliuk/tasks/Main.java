package ua.edu.sumdu.j2se.havryliuk.tasks;


import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {


		Task TestTask1 = new Task("Sleep", 10);
		Task TestTask2 = new Task("Visiting friends", 50);
		Task TestTask3 = new Task("Running", 10, 30, 5);
		Task TestTask4 = new Task("Play football", 10, 20, 2);
		Task TestTask5 = new Task("Play football", 10, 20, 2);

		TestTask5.setTitle("Change");
		TestTask5.setActive(true);
		TestTask5.setTime(10);
		TestTask5.setTime(10, 20, 2);


		ArrayTaskList Array = new ArrayTaskList();
		Array.add(TestTask1);
		Array.add(TestTask2);
		Array.add(TestTask3);
		Array.add(TestTask4);

		System.out.println(" ARRAY ITERATOR ");
		Iterator <Task> arrayIter = Array.iterator();
		while (arrayIter.hasNext()){
			System.out.println(arrayIter.next());
		}

		System.out.println(" LINK ITERATOR ");

		LinkedTaskList Link = new LinkedTaskList();
		Link.add(TestTask1);
		Link.add(TestTask2);
		Link.add(TestTask3);
		Link.add(TestTask4);


		Iterator<Task> linkIter = Link.iterator();
		while (linkIter.hasNext()) {
			System.out.println(linkIter.next());}



		for (int i = 0; i < Array.incoming(20,100).size(); i++) {
			System.out.println("Incoming cycle for Array: " + Array.incoming(20,100).getTask(i) );

		}

		System.out.println("Incoming Array: " + Array.incoming(20, 100).getTask(1).getTitle());
		System.out.println("Incoming Link: " + Link.incoming(20,100).getTask(1).getTitle());

	}
}