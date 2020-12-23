package implementations;

import java.util.Iterator;

import interfaces.IArray;

public class Array<T> implements IArray<T>{
	
	protected Object[] array = null;
	
	public Array(int size) {
		if (size < 0) {
			throw new NegativeArraySizeException();
		}
		array = new Object[size];
	}


	@Override
	public T get(int index) {
		if (index < 0 || index >= getSize()) {
			throw new java.lang.ArrayIndexOutOfBoundsException();
		}
		return (T) array[index];
	}

	@Override
	public void set(int index, T data) {
		if (index < 0 || index >= getSize()) {
			throw new java.lang.ArrayIndexOutOfBoundsException();
		}
		array[index] = data;
	}

	@Override
	public int getSize() {
		return array.length;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	
	
	private class ArrayListIterator implements java.util.Iterator<T> {
		private int nextIndex = 0;
		@Override
		public boolean hasNext() {
			if (nextIndex > array.length - 1) {
				return false;
			}
			return true;
		}
		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			T data = (T) array[nextIndex];
			nextIndex++;
			return data;
		}
	}

}
