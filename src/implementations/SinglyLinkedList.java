package implementations;

import java.util.Iterator;

import interfaces.ISinglyLinkedList;

public class SinglyLinkedList<T> implements ISinglyLinkedList<T>{
	
	protected class SNode {
		private SNode nextNode;
		private T data;
		public SNode(T data) {
			setData(data);
		}
		public SNode getNextNode() {
			return nextNode;
		}
		public void setNextNode(SNode nextNode) {
			this.nextNode = nextNode;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
	}
	
	
	
	protected SNode head = null;
	protected SNode tail = null;
	private int size = 0;
	

	@Override
	public void addFirst(T data) {
		if (size == 0) {
			head = new SNode(data);
			tail = head;
			size++;
		} else {
			SNode tempNode = head;
			head = new SNode(data);
			head.setNextNode(tempNode);
			size++;
		}
		
	}

	@Override
	public T getFirst() {
		if (size == 0) {
			throw new java.util.NoSuchElementException();
		} else {
			return head.getData();
		}
		
	}

	@Override
	public T removeFirst() {
		if (size == 0) {
			 throw new java.util.NoSuchElementException();
		} else {
			SNode tempNode = head;
			head = head.getNextNode();
			tempNode.setNextNode(null);
			size--;
			return tempNode.getData();
		}
	}

	@Override
	public void addLast(T data) {
		if (size == 0) {
			head = new SNode(data);
			tail = head;
			size++;
		} else {
			SNode tempNode = new SNode(data);
			tail.setNextNode(tempNode);
			tail = tempNode;
			size++;
		}
		
		
	}

	@Override
	public T getLast() {
		if (size == 0) {
			throw new java.util.NoSuchElementException();
		} else {
			return tail.getData();
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SNode node = head;
		System.out.print("[ ");
		while (node != null) {
			System.out.print(node.getData().toString() + ", ");
			node = node.getNextNode();
		}
		System.out.print("]");
		return sb.toString();
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new SIterator();
	}
	
	private class SIterator implements java.util.Iterator<T> {
		private SNode next = head;
		@Override
		public boolean hasNext() {
			if (next == null) {
				return false;
			}
			return true;
		}
		@Override
		public T next() {
			if (next == null) {
				throw new java.util.NoSuchElementException();
			}
			T data = next.getData();
			next = next.getNextNode();
			return data;
		}
	}
	
}
