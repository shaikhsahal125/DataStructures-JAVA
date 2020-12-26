package implementations;

import java.util.Iterator;

import interfaces.IDoublyLinkedList;

public class DoublyLinkedList<T> implements IDoublyLinkedList<T>{

	protected class DNode {
		private DNode nextNode;
		private DNode prevNode;
		private T data;
		public DNode(T data) {
			setData(data);
		}
		public DNode getNextNode() {
			return nextNode;
		}
		public void setNextNode(DNode nextNode) {
			this.nextNode = nextNode;
		}
		public DNode getPrevNode() {
			return prevNode;
		}
		public void setPrevNode(DNode prevNode) {
			this.prevNode = prevNode;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
	}
	
	protected DNode head = null;
	protected DNode tail = null;
	private int size = 0;

	@Override
	public void addFirst(T data) {
		if (isEmpty()) {
			head = new DNode(data);
			tail = head;
			size++;
		} else {
			DNode temp = new DNode(data);
			temp.setNextNode(head);
			head.setPrevNode(temp);
			head = temp;
			size++;
		}
		
	}

	@Override
	public T getFirst() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		} else {
			return head.getData();
		}
	}

	@Override
	public T removeFirst() {
		DNode tempNode = head;
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		} else if (getSize() == 1) {
			head = tail = null;
		} else {
			head = tempNode.getNextNode();
			head.setPrevNode(null);
		}
		size--;
		return tempNode.getData();
	}

	@Override
	public void addLast(T data) {
		if (isEmpty()) {
			head = new DNode(data);
			tail = head;
			size++;
		} else {
			DNode temp = new DNode(data);
			tail.setNextNode(temp);
			temp.setPrevNode(tail);
			tail = temp;
			size++;
		}
	}

	@Override
	public T getLast() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		} else {
			return tail.getData();
		}
	}

	@Override
	public T removeLast() {
		DNode temNode = tail;
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		} else if (getSize() == 1) {
			head = tail = null;
		} else {
			tail = temNode.getPrevNode();
			tail.setNextNode(null);
		}
		size--;
		return temNode.getData();
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
		DNode node = head;
		sb.append("[ ");
		while (node != null) {
			sb.append(node.getData().toString() + " ");
			node = node.getNextNode();
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public Iterator<T> reverseIterator() {
		return new ReverseIterator();
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ForwardIterator();
	}
	
	private class ForwardIterator implements java.util.Iterator<T> {
		private DNode node = null;
		private DNode nextNode = head;
		@Override
		public boolean hasNext() {
			if (nextNode == null) {
				return false;
			}
			return true;
		}
		@Override
		public T next() {
			if (nextNode == null) {
				throw new java.util.NoSuchElementException();
			}
			node = nextNode;
			T data = nextNode.getData();
			nextNode = nextNode.getNextNode();
			return data;
		}
		@Override
		public void remove() {
			if (node == null) {
				throw new java.util.NoSuchElementException();
			}
			if (node.getNextNode() == null && node.getPrevNode() == null) {
				head = null;
				tail = null;
			} else {
				if (node.getNextNode() == null) {
					node.getPrevNode().setNextNode(null);
					tail = null;
				} else {
					if (node.getPrevNode() == null) {
						node.getNextNode().setPrevNode(null);
						head = null;
					} else {
						node.getPrevNode().setNextNode(node.getNextNode());
						node.getNextNode().setPrevNode(node.getPrevNode());
					}
				}
			}
			node = null;
			size--;
		}
	}
	
	private class ReverseIterator implements java.util.Iterator<T> {
		private DNode nextNode = tail;
		@Override
		public boolean hasNext() {
			if (nextNode == null) {
				return false;
			}
			return true;
		}
		@Override
		public T next() {
			if (nextNode == null) {
				throw new java.util.NoSuchElementException();
			}
			T data = nextNode.getData();
			nextNode = nextNode.getPrevNode();
			return data;
		}
	}
	
	
	

}
