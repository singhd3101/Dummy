
public class BinarySearchTree {

	public static Node insert(Node root, int data){
		if(root == null) {
			return new Node(data);
		} 
		else if(data <= root.data) {
			root.left = insert(root.left,data);
		}
		else {
			root.right = insert(root.right, data);
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

	public static void main(String[] args) {
		Node node = null;
		node = insert(node,1);
		node = insert(node,2);
		node = insert(node,3);
		node = insert(node,4);
		node = insert(node,5);
		node = insert(node,6);
		node = insert(node,7);
		node = insert(node,8);
		
		System.out.println("Min: " + minElementinBST(node));
		
		System.out.println("Max: " + maxElementinBST(node));
	}

}
