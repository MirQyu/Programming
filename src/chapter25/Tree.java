package chapter25;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {

	
	public boolean search(E e);
	
	public boolean insert(E e);
	
	public boolean delete(E e);
	
	public void inorder();
	
	public void preorder();
	
	public void postorder();
	
	public int getSize();
	
	public boolean isEmpty();

	@Override
	default Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
