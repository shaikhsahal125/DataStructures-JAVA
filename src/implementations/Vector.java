package implementations;



import interfaces.IArray;
import interfaces.IVector;

public class Vector<T> implements IVector<T> {
	private IArray<T> theArray = null;
	private int size = 0;
	private int capacity;
	
	public Vector() {
		this(0, 1);
	}
	
	public Vector(int size) {
		this(size, size);
	}
	
	public Vector(int size, int capacity) {
		this(size, capacity < size ? size : capacity, false);
	}

	public Vector(int size, int capacity, boolean debug) {
		this.size = size;
		this.capacity = capacity < size ? size : capacity;
		theArray = new Array<T>(capacity);
	}

	
	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		checkBounds(index);
		return theArray.get(index);
	}

	@Override
	public void set(int index, T data) {
		// TODO Auto-generated method stub
		checkBounds(index);
		theArray.set(index, data);
		size++;
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void pushBack(T data) {
		// TODO Auto-generated method stub
		if (getSize() < getCapacity()) {
			theArray.set(getSize(), data);
			size++;
		} else {
			capacity = capacity * 2;
			IArray<T> oldArray = theArray;
			theArray = new Array<>(capacity);
			
			for (int i = 0; i < size; i++) {
				T item = oldArray.get(i);
				theArray.set(i, item);
			}
			theArray.set(size, data);
			size++;
			
		}
		
	}

	@Override
	public void popBack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T back() {
		// TODO Auto-generated method stub
		return theArray.get(size-1);
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	@Override
	public void shrinkToFit() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getSize() + " " + getCapacity() + " ");
		sb.append("[ ");
		for (int i = 0; i < getSize(); i++) {
			sb.append(get(i).toString() + " ");
		}
		sb.append("]");
		return sb.toString();
	}
	@Override
	public java.util.Iterator<T> iterator() {
		return new VectorIterator();
	}
	private class VectorIterator implements java.util.Iterator<T> {
		private int nextIndex = 0;
		@Override
		public boolean hasNext() {
			return nextIndex < getSize();
		}
		@Override
		public T next() {
			return get(nextIndex++);
		}
	}
	private void checkBounds(int index) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
	}

}
