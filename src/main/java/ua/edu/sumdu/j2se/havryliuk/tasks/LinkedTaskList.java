package ua.edu.sumdu.j2se.havryliuk.tasks;



import java.util.stream.Stream;

public class LinkedTaskList extends AbstractTaskList implements Cloneable {

    private Node head;
    private int size;


    private static class Node {
        Task element;
        Node next;

        public Node(Task element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }


    public void add(Task task) {
        if (task == null) {
            throw new NullPointerException("Task is empty");
        }

        Node newNode = new Node(task, null);
        if (!isEmpty()) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public boolean remove(Task task) {

        if (task != null) {
            Node currentNode = head;
            Node previousNode = null;
            int helpSize = 0;

            while (currentNode != null && currentNode.element != task) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                helpSize++;
                if (helpSize > size) {
                    return false;
                }
            }
            if (currentNode != null) {
                if (null == previousNode) {
                    head = head.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Task getTask(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Your index too much or too small. Check your index. ");
        }
        Node count = head;
        for (int i = 0; i < index; i++) {
            count = count.next;
        }
        return count.element;
    }

    public ListTypes.types getType() {
        return ListTypes.types.LINKED;
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
    public LinkedTaskList clone() throws CloneNotSupportedException {
        return (LinkedTaskList)
                super.clone();
    }


    @Override
    public int hashCode() {
        int hashCode = 1;
        for (Task task : this)
            hashCode = 31 * hashCode + (task==null ? 0 : task.hashCode());
        return hashCode;
    }


    @Override
    public String toString() {
        return "It`s Linked List includes " + size +
                " tasks. Last added task is: " + head.element.getTitle();
    }
}