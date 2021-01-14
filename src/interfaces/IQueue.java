package interfaces;

public interface IQueue<T> {
	public void enqueue(T data);
	public T dequeue();
	public T peek();
	public boolean isEmpty();

}
