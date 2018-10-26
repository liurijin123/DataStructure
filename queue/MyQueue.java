package queue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue<E> {

	private LinkedList<E> list;
	private AtomicInteger count = new AtomicInteger();
	private final int minSize = 0;
    private int maxSize ;
    
	public MyQueue( int maxSize) {
		list = new LinkedList<E>();
		this.maxSize = maxSize;
	}
	
	//入队
    public synchronized void put(E e){
    	if(count.get() == maxSize){
    		try {
				wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
    	}
    	list.add(e);
    	count.incrementAndGet();
    	notify();
    	System.out.println("添加新元素："+e);
    }
    
    //出队
    public synchronized E take(){
    	if(count.get() == minSize){
    		try {
				wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
    	}
    	E e = list.removeFirst();
    	count.decrementAndGet();
    	System.out.println("出队："+e);
    	notify();
    	return e;
    }
    
    //返回个数
    public int getSize(){
    	return count.get();
    }
}
