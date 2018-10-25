package list;

public interface MyList<E> {

	//增
	public void add(E e);
	public void add(int index,E e);
	
	//删
	public void remove(int index);
	public void clear();
	
	//改
	public void set(int index,E e);
	
	//查
	public E get(int index);
	public int indexOf(E e);
	public int getSize();
	public void printAll();
	
	//判断
	public boolean isEmpty();
	
	
	
}
