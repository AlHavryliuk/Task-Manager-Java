package ua.edu.sumdu.j2se.havryliuk.tasks;


import java.util.Arrays;
import java.util.Objects;


public class ArrayTaskList extends AbstractTaskList implements Cloneable {


    private Task[] ArrayTask;
    private int size;


    public ArrayTaskList() {
        ArrayTask = new Task[5];
    }


    public void add(Task task) throws NullPointerException {

        if (task == null) {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                System.out.println("ERROR. Task can not be empty. ");
            }
        }
        if (size == ArrayTask.length) {
            ArrayTask = Arrays.copyOf(ArrayTask, size * 2);
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


    public ListTypes.types getType() {
        return ListTypes.types.ARRAY;
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