package queue;

public class Test {

	public static void main(String[] args) {
		final MyQueue<Integer> queue = new MyQueue<Integer>(5);
		queue.put(0);
		queue.put(1);
		queue.put(2);
		queue.put(3);
		queue.put(4);
		System.out.println("当前长度："+queue.getSize());
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				queue.put(5);
				queue.put(6);
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				queue.take();
				queue.take();
			}
		}, "t2");
		t1.start();
		t2.start();
	}

}
