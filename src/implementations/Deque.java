package implementations;

import interfaces.IDeque;
import interfaces.IDoublyLinkedList;

public class Deque<T> implements IDeque<T> {
	private IDoublyLinkedList<T> theList = new DoublyLinkedList<>();

	@Override
	public void enqueueFirst(T data) {
		// TODO Auto-generated method stub
		theList.addFirst(data);
		
	}

	@Override
	public void enqueueLast(T data) {
		// TODO Auto-generated method stub
		theList.addLast(data);
		
	}

	@Override
	public T peekFirst() {
		// TODO Auto-generated method stub
		return theList.getFirst();
	}

	@Override
	public T peekLast() {
		// TODO Auto-generated method stub
		return theList.getLast();
	}

	@Override
	public T dequeueFirst() {
		// TODO Auto-generated method stub
		return theList.removeFirst();
	}

	@Override
	public T dequeueLast() {
		// TODO Auto-generated method stub
		return theList.removeLast();
	}

	@Override
	public IDoublyLinkedList<T> asList() {
		// TODO Auto-generated method stub
		return theList;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return theList.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return theList.isEmpty();
	}

	@Override
	public String toString() {
		return theList.toString();
	}

}
