package binaryTree;

public class BinaryTree {

	private TreeNode root;
	
	public BinaryTree(){
		root = null;
	}
	public int getRootValue(){
		return root.value;
	}
	//查找
	public boolean contains(int value){
		return contains(value, root);
	}
	private boolean contains(int value, TreeNode node) {
		if(node == null){
			return false;
		}
		if(value < node.value){
			return contains(value, node.left);
		}else if(value > node.value){
			return contains(value, node.right);
		}else 
			return true;
	}
	//查找最小值
	public int findMin() throws Exception{
		if(root == null) throw new Exception("root为空");
		return findMin(root).value;
	}
	private TreeNode findMin(TreeNode node) {
		if(node == null){
			return null;
		}else if(node.left == null){
			return node;
		}
		return findMin(node.left);
	}
	//查找最大值
	public int findMax() throws Exception{
		if(root == null) throw new Exception("root为空");
		return findMax(root).value;
	}
	private TreeNode findMax(TreeNode node) {
		if(node == null){
			return null;
		}else if(node.right == null){
			return node;
		}
		return findMax(node.right);
	}
	//插入
	public void insert( int value){
		root = insert(value, root);
	}
	private TreeNode insert(int value, TreeNode node) {
		if(node == null){
			System.out.print("插入："+value);
			return new TreeNode(value);
		}
		if(value < node.value){
			node.left = insert(value, node.left);
		}else if(value > node.value){
			node.right = insert(value, node.right);
		}
		return node;
	}
	//前序遍历
	public void preOrder(){
		preOrder(root);
	}
	private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print("输出："+node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    //中序遍历
    public void inOrder(){
    	inOrder(root);
    }
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print("输出："+node.value);
        inOrder(node.right);
 
    }
    //后序遍历
    public void postOrder(){
    	postOrder(root);
    }
    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print("输出："+node.value);
    }
    //删除
    public void remove(int value) throws Exception{
    	root = remove(value, root);
    }
	private TreeNode remove(int value, TreeNode node) throws Exception {
		if(node == null){
			return node;
		}
		if(value < node.value){
			node.left = remove(value, node.left);
		}else if(value > node.value){
			node.right = remove(value, node.right);
		}else if(node.left != null && node.right != null){ //两个儿子节点
			//先找到右子树的最小节点，用最小节点的数据代替此删除节点数据
			node.value = findMin(node.right).value;
			//然后递归删除右子树最小节点
			node.right = remove(node.value, node.right); 
		}else{
			//最多有一个儿子节点，如果是左节点，则左节点覆盖此删除节点，如果不是左节点，则右节点覆盖此删除节点，右节点可能为空
			node = (node.left != null) ? node.left : node.right;
		}
		return node;
	}
    
}
