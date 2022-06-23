package ua.edu.sumdu.j2se.havryliuk.tasks;


import java.time.LocalDateTime;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {


		/*Task TestTask1 = new Task("Sleep", 10);
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
		for (Task task : Array) {
			System.out.println(task);
		}

		System.out.println(" LINK ITERATOR ");

		LinkedTaskList Link = new LinkedTaskList();
		Link.add(TestTask1);
		Link.add(TestTask2);
		Link.add(TestTask3);
		Link.add(TestTask4);


		for (Task task : Link) {
			System.out.println(task);
		}



		for (int i = 0; i < Array.incoming(20,100).size(); i++) {
			System.out.println("Incoming cycle for Array: " + Array.incoming(20,100).getTask(i) );

		}

		System.out.println("Incoming Array: " + Array.incoming(20, 100).getTask(1).getTitle());
		System.out.println("Incoming Link: " + Link.incoming(20,100).getTask(1).getTitle());*/


        /*Task TestTask = new Task("Task title", LocalDateTime.now().plusSeconds(42));
        System.out.println(TestTask.getTitle());*/

        for (int i = 0; i < 18; i++) {


            if (i == 6) {
                System.out.print("\n");
            }
            if (i == 7 || i == 10) {
                System.out.print("         ");
                continue;
            }
            if (i == 8){
                System.out.print("  NASTYA");
                continue;
            }
            if (i == 9){
                System.out.print("   KULAI  ");
                continue;
            }
            if (i == 12) {
                System.out.print("\n");
            }


            System.out.print("Love you ");
        }

    }
}