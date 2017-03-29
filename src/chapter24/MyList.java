package chapter24;

public interface MyList<E> extends java.lang.Iterable<E> {
	
	public void add(E e);
	
	public void add(int index, E e);
	
	public void clear();
	
	public boolean contains(E e);
	
	public E get(int index);
	
	public int indexOf(E e);
	
	public boolean isEmpty();
	
	public int lastIndexOf(E e);
	
	
	/**
	 * Remove the first occurrence of the element e from this list
	 * Shift any subsequent elements to the left
	 * @param e
	 * @return true if the element is removed
	 */
	public boolean remove(E e);
	
	/**
	 * Remove the element at the specified position in this list
	 * Shift any subsequent elements to the left
	 * @param index
	 * @return
	 */
	public E remove(int index);
	
	public int size();

	public E set(int index, E e);
}
