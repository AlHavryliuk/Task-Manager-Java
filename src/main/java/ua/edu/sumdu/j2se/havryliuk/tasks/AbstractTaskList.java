package ua.edu.sumdu.j2se.havryliuk.tasks;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;


public abstract class AbstractTaskList implements Iterable<Task> , Serializable {



    public Iterator <Task> iterator(){
        return new Itr();
    }
    public abstract void add(Task task);
    public abstract boolean remove(Task task);
    public abstract int size ();
    public abstract Task getTask(int index) throws IndexOutOfBoundsException;
    protected abstract ListTypes.types getType();
    public abstract Stream <Task> getStream();




    public final AbstractTaskList incoming (LocalDateTime from, LocalDateTime to) {
        AbstractTaskList incTask = TaskListFactory.createTaskList(getType());
        {
            Stream <Task> incStream = getStream();
            incStream.filter(task -> task.nextTimeAfter(from).isAfter(from))
                    .filter(task -> task.nextTimeAfter(to).isBefore(to))
                    .forEach(incTask::add);
        }
        return incTask;
    }


    @Override
    public boolean equals(Object obj) {
        boolean answer = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractTaskList that = (AbstractTaskList) obj;
        if (this.size() != that.size()) {
            return false;
        }
        for (int i = 0; i < that.size(); i++) {
            answer = this.getTask(i).equals(that.getTask(i));
            if (!answer) {
                break;
            }
        }
        return answer;
    }


    private class Itr implements Iterator<Task>{

        int cursor = 0;
        int lastCurs = -1;


        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public Task next() {
            int i = cursor;
            if (i >= size()) {
                throw new NoSuchElementException("Can`t found next task");
            }
            Task next = getTask(i);
            lastCurs = i;
            cursor = i + 1;
            return next;
        }


        @Override
        public void remove() {
            if (lastCurs < 0)
                throw new IllegalStateException();

            try {
                AbstractTaskList.this.remove(getTask(lastCurs));
                if (lastCurs < cursor)
                    cursor--;
                lastCurs = -1;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }
    }

}