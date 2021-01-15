package implementations;

import interfaces.IOrderedList;

public class OrderedList<T> extends DoublyLinkedList<T> implements IOrderedList<T> {
		     // might add extends Comparable<T> 	

	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		addLast(data);
		
//		System.out.println(data.compareTo(head.getData()) == 1 );
		
	}

	@Override
	public boolean contains(T data) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return false;
		} else {
			DNode tempNode = head;
			
			while (tempNode != null) {
				if (data == tempNode.getData()) {
					return true;
				}
				tempNode = tempNode.getNextNode();
			}
		}
		return false;
	}
	

}
