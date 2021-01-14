package implementations;

import interfaces.ISinglyLinkedList;
import interfaces.IStack;

public class Stack<T> implements IStack<T> {
	
	private ISinglyLinkedList<T> theList = new SinglyLinkedList<>();

	@Override
	public void push(T dataT) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
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
