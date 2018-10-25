package list;

public class Test {

	public static void main(String[] args) {
		//测试MyArrayList
		MyList<Integer> list = new MyArrayList<Integer>();
		for(int i=0;i<20;i++){
			list.add(i);
		}
		list.add(1, 11);
		list.set(2, 22);
		System.out.println("15的index："+list.indexOf(15));
		System.out.println("List长度："+list.getSize());	
		list.remove(20);
		list.printAll();
		
		System.out.println("------------------------");
		
		//测试MyLinkList
		MyList<Integer> linkList = new MyLinkList<Integer>();
		for(int i=0;i<20;i++){
			linkList.add(i);
		}
		linkList.add(0, 11);
		linkList.set(2, 22);
		System.out.println("15的index："+linkList.indexOf(15));
		System.out.println("List长度："+linkList.getSize());
		linkList.remove(20);
		linkList.printAll();
	}
}
