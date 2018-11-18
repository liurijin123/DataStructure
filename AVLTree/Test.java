package AVLTree;

public class Test {

	public static void main(String[] args) {
		AVLTree avlTree = new AVLTree();
		System.out.println("添加数据：");
		for(int i=0; i<10; i++){
			avlTree.insert((int)(1+Math.random()*100));
		}
		System.out.println("\r\n层序遍历：");
		avlTree.levelTraverse();
	}
}
