package binaryTree;

public class Test {

	public static void main(String[] args) throws Exception {
		BinaryTree bTree = new BinaryTree();
		System.out.println("添加数据：");
		for(int i=0; i<10; i++){
			bTree.insert((int)(1+Math.random()*100));
		}
		System.out.println("\r\n前序遍历：");
		bTree.preOrder();
		System.out.println("\r\n中序遍历：");
		bTree.inOrder();
		System.out.println("\r\n后序遍历：");
		bTree.postOrder();
		System.out.println("\r\n是否存在50：" + bTree.contains(50));
		System.out.println("查找最小值：" + bTree.findMin());
		System.out.println("查找最大值：" + bTree.findMax());
		System.out.println("删除最大值和最小值：");	
		bTree.remove(bTree.findMax());
		bTree.remove(bTree.findMin());
		System.out.println("新的最小值：" + bTree.findMin());
		System.out.println("新的最大值：" + bTree.findMax());
	}
}
