import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList implements Iterable
{
	private int size = 0;
	private Node head;
	private Object last;
	
	public void add(Object data) {
		if (head == null) {
			head = new Node(data);
		}
		
		Node temp = new Node(data);
		Node curr = head;
		
		if (curr != null) {
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = temp;
		}
		last = data;
		size++;
	}
	
	public boolean contains(Object needle) {
		if (head == null) {
			return false;
		}
		if (head.data == needle) {
			return true;
		}
		Node curr = head;
		
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
	
	public Object get(int index) {
		if (index <= 0) {
			return null;
		}
		
		Node curr;
		if (head != null) {
			curr = head.next;
			for (int i = 0; i < index; i++) {
				if (curr.next == null) {
					return null;
				}
				curr = curr.next;
			}
			return curr.data;
		}
		return null;
	}
	
	public Object get( Object o )
	{
		return this.get(this.getIndex(o));
	}
	
	public int getIndex( Object o )
	{
		if( !this.contains(o) )
		{
			return -1;
		}
		
		int index = 0;
		Node curr = head;
		
		while (curr.next != null)
		{
			curr = curr.next;
			if (curr.data == o)
			{
				return index;
			}
			index++;
		}
		return -1;
	}
	
	public boolean remove(int index) {
		if (index < 0 || index > size()) {
			return false;
		}
		
		if (index == 0 && size > 0) {
			head = head.next;
			size--;
			return true;
		}
		
		Node curr = head;
		if (head != null) {
			for (int i = 0; i < index; i++) {
				if (curr.next == null) {
					return false;
				}
				
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
	
	public boolean remove( Object o )
	{
		return this.remove(this.getIndex(o));
	}
	
	public int size() {
		return size;
	}
	
	public Object getLast() {
		return last;
	}
	
	@Override
	public Iterator iterator() {
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
	
	private class Itr implements Iterator {
		private int nextIndex = 0;
		private Node lastReturned = head;
		private Node next = head.next;
		
		@Override
		public boolean hasNext() {
			return nextIndex != size;
		}
		
		@Override
		public Object next() {
			if (nextIndex == size) {
				throw new NoSuchElementException();
			}
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		
		@Override
		public void remove() {
			LinkedList.this.remove(nextIndex - 1);
			nextIndex--;
		}
	}
}
