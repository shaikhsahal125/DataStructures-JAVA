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
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLast(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
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
