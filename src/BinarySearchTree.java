
public class BinarySearchTree {
	
	public static Node insert(Node root, int data) {
		return insertData(root, data);
	}

	public static Node insertData(Node root, int data){
		if(root == null) {
			return new Node(data);
		} 
		else if(data < root.data) {
			root.left = insertData(root.left,data);
		}
		else if(data > root.data){
			root.right = insertData(root.right, data);
		}
		return root;
	}

	public static int minElementinBST(Node root) {
		if(root == null) {
			return -1;
		}
		if(root.left == null) {
			return root.data;
		}
		return minElementinBST(root.left);
	}

	public static int maxElementinBST(Node root) {
		if(root == null) {
			return -1;
		}
		if(root.right == null) {
			return root.data;
		}
		return maxElementinBST(root.right);
	}
	
	/**
	 * deleting a node can be done in 2 ways - 
	 * 1) find node, find min in node.right subtree, copy the value in targeted node, delete duplicate node from right sub tree
	 * 2) find node, find max in node.left subtree, copy the value in targeted node, delete duplicate node from left sub tree
	 */
	
	public static Node delete(Node root, int data) {
		if(root == null) {
			return root;
		} else if(data < root.data) {
			return delete(root.left, data);
		} else if(data > root.data) {
			return delete(root.right, data);
		} else {
			if(root.left == null && root.right == null) {
				root = null;
			}
			else if(root.left == null) {
				root = root.right;
			}
			else if(root.right == null) {
				root = root.left;
			}
			else {
				int minData = minElementinBST(root.right);
				root.data = minData;
				root.right = delete(root.right,minData);
			}
		}
		return root;
	}
	
	public static void print(Node node) {
		
		if(node == null) {
			return;
		}
		System.out.println(node.data);
		print(node.left);
		print(node.right);
	}
	
	// Runtime - O(h)
	public static Node search(Node root, int data)
	{
	    if (root==null || root.data==data) {
	    	return root;
	    }
	       
	    if (root.data > data) {
	    	return search(root.left, data);
	    } 
	 
	    return search(root.right, data);
	}

	public static void main(String[] args) {
		Node node = null;
		node = insert(node,4);
		node = insert(node,1);
		node = insert(node,2);
		/*node = insert(node,3);
		node = insert(node,6);
		node = insert(node,5);
		node = insert(node,7);*/
		
		System.out.println("Min: " + minElementinBST(node));
		 
		System.out.println("Max: " + maxElementinBST(node));
		
		//print(node);
		
		LevelOrderTraversalBFS.levelOrderTraversalBFS(node);
		System.out.println();
		/*node = delete(node,5);
		
		LevelOrderTraversalBFS.levelOrderTraversalBFS(node);*/
		
		System.out.println("print root data: " + node.data);
	}

}
