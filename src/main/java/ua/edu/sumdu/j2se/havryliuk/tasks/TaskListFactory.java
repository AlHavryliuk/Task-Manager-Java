package ua.edu.sumdu.j2se.havryliuk.tasks;

public class TaskListFactory {
    public static AbstractTaskList createTaskList (ListTypes.types types) {
        return switch (types) {
            case LINKED -> new LinkedTaskList();
            case ARRAY -> new ArrayTaskList();
        };
    }
}
