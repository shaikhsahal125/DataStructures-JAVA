package implementations;

import interfaces.IResizableArray;

public class ResizableArray<T> extends Array<T> implements IResizableArray<T> {

	public ResizableArray() {
		this(0);
	}
	
	public ResizableArray(int size) {
		super(size);
		
	}

	@Override
	public void resize(int size) {
		// TODO Auto-generated method stub
		if (size < array.length) {
			throw new IllegalArgumentException();
		}
		
		Object[] oldArr = array;
		array = new Object[size];
		
		for (int i = 0; i < oldArr.length; i++) {
			array[i] = oldArr[i];
		}
		
	}

	@Override
	public void resize(int size, T init) {
		// TODO Auto-generated method stub
		if (size <= array.length) {
			throw new IllegalArgumentException();
		}
		
		Object[] oldArr = array;
		array = new Object[size];
		
		for (int i = 0; i < oldArr.length; i++) {
			array[i] = oldArr[i];
		}
		
		for (int i = oldArr.length; i < array.length; i++) {
			array[i] = init;
		}
		
	}

}
