package implementations;

import interfaces.IDoublyLinkedList;
import interfaces.ISinglyLinkedList;
import interfaces.IStack;

@SuppressWarnings("unused")
public class Stack<T> implements IStack<T> {
	
	private ISinglyLinkedList<T> theList = new SinglyLinkedList<>();
//	private IDoublyLinkedList<T> theList = new DoublyLinkedList<>();
	

	@Override
	public void push(T dataT) {
		// TODO Auto-generated method stub
		theList.addFirst(dataT);
		
	}

	@Override
	public T pop() {
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
