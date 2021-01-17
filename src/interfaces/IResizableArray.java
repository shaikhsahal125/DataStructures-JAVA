package interfaces;

public interface IResizableArray<T> extends IArray<T> {
	public void resize(int size);
	public void resize(int size, T init);
}
