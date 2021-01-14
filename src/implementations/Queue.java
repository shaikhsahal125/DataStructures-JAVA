package implementations;

import interfaces.IQueue;
import interfaces.ISinglyLinkedList;

public class Queue<T> implements IQueue<T>{
	private ISinglyLinkedList<T> theList = new SinglyLinkedList<>();

	@Override
	public void enqueue(T data) {
		// TODO Auto-generated method stub
		theList.addLast(data);
		
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return theList.removeFirst();
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return theList.getFirst();
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
