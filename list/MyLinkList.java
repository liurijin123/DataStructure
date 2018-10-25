package list;

public class MyLinkList<E> implements MyList<E> {
	private static class Entry<E>{
		E data;
		Entry<E> next;
		Entry<E> previous;
		
		Entry(E data, Entry<E> next, Entry<E> previous){
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
	}
	private Entry<E> head;
	private Entry<E> node;
	private int size;
	
	public MyLinkList(){
		head = new Entry<E>(null, null, null);
		head.next = head;
		head.previous = head;
		node = head;
	}

	@Override
	public void add(E e) {
		Entry<E> entry = new Entry<E>(e, head, node);
		node.next = entry;
		head.previous = entry;
		node = node.next;
		size++;
	}

	@Override
	public void add(int index, E e) {
		Entry<E> nodeOfIndex= getNode(index);
		Entry<E> entry = new Entry<E>(e, nodeOfIndex.next, nodeOfIndex);
		nodeOfIndex.next.previous = entry;
		nodeOfIndex.next = entry;
		size++;
	}

	private Entry<E> getNode(int index) {
		if(index<0||index>size){
			//不存在
			return null;
		}
		Entry<E> temp = head;
		if(index < (size>>1)){
			for(int i=0;i<=index;i++){
				temp = temp.next;
			}
		}else{
			for(int i=size;i>index;i--){
				temp = temp.previous;
			}
		}
		return temp;
	}

	@Override
	public void remove(int index) {
		Entry<E> nodeOfIndex= getNode(index);
		nodeOfIndex.previous.next = nodeOfIndex.next;
		nodeOfIndex.next.previous = nodeOfIndex.previous;
		nodeOfIndex.next = null;
		nodeOfIndex.previous = null;
		size++;
	}

	@Override
	public void clear() {
		Entry<E> temp = head.next;
		while(temp != head){
			Entry<E> next = temp.next;
			temp.data = null;
			temp.next = null;
			temp.previous = null;
			temp = next;
		}
		head.next = head;
		head.previous = head;
		size = 0;
	}

	@Override
	public void set(int index, E e) {
		Entry<E> nodeOfIndex = getNode(index);
		nodeOfIndex.data = e;
	}

	@Override
	public E get(int index) {
		return getNode(index).data;
	}

	@Override
	public int indexOf(E e) {
		Entry<E> temp = head.next;
		int i = 0;
		while(temp != head){
			if(temp.data == e){
				return i;
			}
			temp = temp.next;
			i++;
		}
		return -1;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void printAll() {
		Entry<E> temp = head.next;
		while(temp != head){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	@Override
	public boolean isEmpty() {
		if(head.next == null && head.previous == null){
			return false;
		}
		return true;
	}

}
