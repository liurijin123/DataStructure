package AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

	TreeNode root ;
	
	//获取高度
	private int height(TreeNode node) {
		return  (node == null)? -1 : node.height;
	}
	//插入
	public void insert(int value){
		root = insert(value, root);
	}
	private TreeNode insert(int value, TreeNode node) {
		if(node == null){
			System.out.print("插入：" + value);
			return new TreeNode(value);
		}else{
			if(value < node.value){
				node.left = insert(value, node.left);
			}else if(value > node.value){
				node.right = insert(value, node.right);
			}
		}
		return balance(node);
	}
	//平衡
	private TreeNode balance(TreeNode node) {
		if(node == null){
			return node;
		}
		if(height(node.left) - height(node.right) > 1){ //插入点在node的左子树上
			if(height(node.left.left) >= height(node.left.right)){ //插入点在node的左子树的左子树上LL
				node = leftLeftRotation(node);
			}else{  //插入点在node的左子树的右子树上LR
				node = leftRightRotation(node);
			}
		}else if(height(node.right) - height(node.left) > 1){ //插入点在node的右子树上
			if(height(node.right.right) >= height(node.right.left)){ //插入点在node的右子树的右子树上RR
				node = rightRightRotation(node);
			}else{  //插入点在node的右子树的左子树上RL
				node = rightLeftRotation(node);
			}
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}
	//LL旋转
	private TreeNode leftLeftRotation(TreeNode node2){
		TreeNode node1 = node2.left;
		node2.left = node1.right;
		node1.right = node2;
		node2.height = Math.max(height(node2.left), height(node2.right)) + 1;
		node1.height = Math.max(height(node1.left), height(node1.right)) + 1;
		return node1;
	}
	//RR旋转
	private TreeNode rightRightRotation(TreeNode node2){
		TreeNode node1 = node2.right;
		node2.right = node1.left;
		node1.left = node2;
		node2.height = Math.max(height(node2.left), height(node2.right)) + 1;
		node1.height = Math.max(height(node1.left), height(node1.right)) + 1;
		return node1;
	}
	//LR旋转
	private TreeNode leftRightRotation(TreeNode node2){
		node2.left = rightRightRotation(node2.left);
		return leftLeftRotation(node2);
	}
	//RL旋转
	private TreeNode rightLeftRotation(TreeNode node2){
		node2.right = leftLeftRotation(node2.right);
		return rightRightRotation(node2);
	}
	//层序遍历
	public void levelTraverse(){
        levelTraverse(root);
    }
    private void levelTraverse(TreeNode node){
        if(node == null)
            return;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//层序遍历时保存结点的队列
        queue.offer(node);//初始化
        while(!queue.isEmpty()){
        	TreeNode temp = queue.poll();
            System.out.print(temp.value + " ");//访问节点
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
    }
}
