package ua.edu.sumdu.j2se.havryliuk.tasks;



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


		LinkedTaskList Link = new LinkedTaskList();
		Link.add(TestTask1);
		Link.add(TestTask2);
		Link.add(TestTask3);
		Link.add(TestTask4);



		System.out.println("Incoming Array: " + Array.incoming(20, 100).getTask(1).getTitle());
		System.out.println("Incoming Link: " + Link.incoming(20,100).getTask(1).getTitle());

	}
}