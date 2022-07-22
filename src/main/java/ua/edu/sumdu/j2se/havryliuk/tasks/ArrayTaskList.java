package ua.edu.sumdu.j2se.havryliuk.tasks;



import java.util.*;
import java.util.stream.Stream;


public class ArrayTaskList extends AbstractTaskList implements Cloneable {


    private Task[] ArrayTask;
    private int size;


    public ArrayTaskList() {
        ArrayTask = new Task[0];
    }


    public void add(Task task) throws NullPointerException {
        if (task == null) { throw new NullPointerException();}
        if (size == ArrayTask.length) {
            ArrayTask = Arrays.copyOf(ArrayTask, size + 1);
        }
        ArrayTask[size] = task;
        size++;
    }



    public boolean remove(Task task) {
        if (task != null) {
            for (int i = 0; i < size; i++) {
                if (ArrayTask[i].getTitle().equals(task.getTitle()) && ArrayTask[i].getTime() == task.getTime()
                        | ArrayTask[i].getStartTime() == task.getStartTime()) {
                    System.arraycopy(ArrayTask, (i + 1), ArrayTask, i, size() - (i + 1));
                    ArrayTask[size - 1] = null;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }


    public int size() {
        return size;
    }

    public Task getTask(int index) {
        if (index > size) {
            try {
                throw new ArrayIndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("List is smaller than your index. Please, try again.");
            }
        }
        return ArrayTask[index];
    }

    public void printTaskAll() {

        for (int i = 0; i < ArrayTask.length; i++) {
            System.out.println(" Task " + i + ". " + ArrayTask[i]);
        }
    }

    public ListTypes.types getType() {
        return ListTypes.types.ARRAY;
    }

    public void optimization (){
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (!(ArrayTask[i].equals(null))) {
                count++;
            }
        }
        Task[] temp = new Task[count];
        int indexTemp = 0;
        for (int i = 0; i < size; i++) {
            if (ArrayTask[i].equals(null)) {
                continue;
            }
            temp[indexTemp] = ArrayTask[i];
            indexTemp++;
        }
        ArrayTask = Arrays.copyOf(temp, count);
        size = count;
    }

    @Override
    public Stream<Task> getStream() {
        Stream.Builder<Task> stream = Stream.builder();
        for (Task nowTask : this) {
            if (nowTask == null) {
                continue;
            }
            stream.add(nowTask);
        }
        return stream.build();
    }

    @Override
    public ArrayTaskList clone() {
        try {
            ArrayTaskList clone = (ArrayTaskList) super.clone();
            clone.ArrayTask = Arrays.copyOf(ArrayTask, size);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(ArrayTask);
        return result;
    }

    @Override
    public String toString() {
        return "It`s ArrayList includes " + size +
                " tasks. Last added task is: " + ArrayTask[size -1].getTitle();
    }




}