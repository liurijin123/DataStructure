package list;

public class MyArrayList<E> implements MyList<E> {
	private Object[] elementData;
	private int maxSize;
	private int size;
	
	public MyArrayList(){
		this(10);
	}
	public MyArrayList(int maxSize){
		this.maxSize = maxSize;
		elementData = new Object[maxSize];
		size = 0;
	}

	@Override
	public void add(E e) {
		if(size>=maxSize){
			addMaxSize();
		}
		elementData[size] = e;
		size++;
	}

	@Override
	public void add(int index, E e) {
		if(size>=maxSize){
			addMaxSize();
		}
		for(int i=size;i>index;i--){
			elementData[i] = elementData[i-1];
		}
		elementData[index] = e;
		size++;
	}

	@Override
	public void remove(int index) {
		if(index>size-1){
			System.out.println("索引越界");
			return;
		}
		for(int i=index;i<size-1;i++){
			elementData[i] = elementData[i+1];
		}
		size--;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void set(int index, E e) {
		elementData[index] = e;
	}

	@Override
	public E get(int index) {
		return (E) elementData[index];
	}

	@Override
	public int indexOf(E e) {
		for(int i=0;i<elementData.length;i++){
			if(elementData[i]==e){
				return i;
			}
		}
		return -1;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public void addMaxSize() {
		maxSize *= 2; 
		Object[] newElementData = new Object[maxSize];
		for(int i=0;i<size;i++){
			newElementData[i] = elementData[i];
		}
		elementData = newElementData;
	}
	@Override
	public void printAll() {
		for(int i=0;i<size;i++){
			System.out.println(elementData[i]);
		}
	}

}
