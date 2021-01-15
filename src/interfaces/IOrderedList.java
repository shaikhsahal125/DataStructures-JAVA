package interfaces;

public interface IOrderedList<T> extends IDoublyLinkedList<T>, java.lang.Iterable<T> {
	public void add(T data);
	public boolean contains(T data);
}
