package interfaces;

public interface IStack<T> {
	public void push(T dataT);
	public T pop();
	public T peek();
	public boolean isEmpty();

}
