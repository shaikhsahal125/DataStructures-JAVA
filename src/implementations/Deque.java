package implementations;

import interfaces.IDeque;
import interfaces.IDoublyLinkedList;

public class Deque<T> implements IDeque<T> {
	private IDoublyLinkedList<T> theList = new DoublyLinkedList<>();

	@Override
	public void enqueueFirst(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enqueueLast(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T peekFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peekLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T dequeueFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T dequeueLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDoublyLinkedList<T> asList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return theList.toString();
	}

}
