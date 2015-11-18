import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class LinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head;
    private T last;

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
        }

        Node<T> temp = new Node<>(data);
        Node<T> curr = head;

        if (curr != null) {
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
        last = data;
        size++;
    }

    public boolean contains(T needle) {
        if (head == null) {
            return false;
        }
        if (head.data == needle) {
            return true;
        }
        Node<T> curr = head;

        if (curr != null) {
            while (curr.next != null) {
                curr = curr.next;
                if (curr.data == needle) {
                    return true;
                }
            }
        }

        return false;
    }

    public T get(int index) {
        if (index <= 0) {
            return null;
        }
        Node<T> curr;
        if (head != null) {
            curr = head.next;
            for (int i = 0; i < index; i++) {
                if (curr.next == null)
                    return null;

                curr = curr.next;
            }
            return curr.data;
        }
        return null;

    }

    public boolean remove(int index) {
        if (index < 0 || index > size())
            return false;

        if (index == 0 && size > 0) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> curr = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (curr.next == null)
                    return false;

                curr = curr.next;
            }
            curr.next = curr.next.next;
            size--;
            if (index == size) {
                last = curr.data;
            }
            return true;

        }
        return false;
    }

    public int size() {
        return size;
    }

    public T getLast() {
        return last;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Node<Type> {
        Node<Type> next;
        Type data;

        public Node(Type dataValue) {
            next = null;
            data = dataValue;
        }
    }

    private class Itr implements Iterator<T> {
        private int nextIndex = 0;
        private Node<T> lastReturned = head;
        private Node<T> next = head.next;

        public boolean hasNext() {
            return nextIndex != size;
        }

        public T next() {
            if (nextIndex == size) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        public void remove() {
            LinkedList.this.remove(nextIndex - 1);
            nextIndex--;
        }
    }
}
