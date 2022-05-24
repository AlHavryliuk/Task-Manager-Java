package ua.edu.sumdu.j2se.havryliuk.tasks;


import java.util.Arrays;

public class ArrayTaskList {


    private Task [] ArrayTask;
    private int size = 0;


    public ArrayTaskList () {
        ArrayTask = new Task [5];
    }


    public void add (Task task){

        if (size == ArrayTask.length ){
            ArrayTask = Arrays.copyOf(ArrayTask, size * 2);                                                     // в середені copyOf знаходиться звичайний цикл схожий на  for (int = 0; i < ArrayTask.length; i ++) { tempArrayTask [i] = ArrayTask[i]}
        }
        ArrayTask[size] = task;
        size++;
    }

    public boolean remove (Task task){
        if (task != null) {
            for (int i = 0; i < size; i++) {
                if (ArrayTask[i].getTitle().equals(task.getTitle())) {
                    System.arraycopy(ArrayTask, (i + 1), ArrayTask, i, size() - (i + 1));
                    ArrayTask[size - 1] = null;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public int size (){
        return size;
    }

    public Task getTask (int index){
        return ArrayTask[index];
    }

    public ArrayTaskList incoming(int from, int to){
        ArrayTaskList ArrayTime = new ArrayTaskList();
        for (int i = 0; i <size; i++) {
            if (ArrayTask[i].nextTimeAfter(from) < to && ArrayTask[i].nextTimeAfter(from) >= from) {
                ArrayTime.add(ArrayTask[i]);
            }
        }
        return ArrayTime;
    }
}
