package map;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class Test {

	public static void main(String[] args) {
		MyMap<Integer, String> hashMap = new MyHashMap<Integer, String>();
		for(int i=0;i<20;i++){
			hashMap.put(i, "值:"+i);
		}
		System.out.println(hashMap.get(12));
		hashMap.remove(12);
		System.out.println(hashMap.get(12));
	}
}
