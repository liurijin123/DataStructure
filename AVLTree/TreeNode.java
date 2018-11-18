package AVLTree;

public class TreeNode {

	public int value;
	public int height;
	public TreeNode left;
	public TreeNode right;
 
    public TreeNode(int value) {
        this.value = value;
        this.height = 0;
        this.left = null;
        this.right = null;
    }
}
