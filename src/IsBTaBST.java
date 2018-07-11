/**
 * BST is a BT iff for each node in BT left.data <= node.data and right.data > node.data
 *
 */
public class IsBTaBST {
	
	/**
	 * O(n)
	 * @param root
	 * @return
	 */
	public static boolean isBinarySearchTree(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isBST(Node root, int min, int max) {
		if(root == null) {
			return true;
		}
		
		if((root.data < min) || (root.data > max)) {
			return false;
		}
		
		return (isBST(root.left, min, root.data-1) &&
                isBST(root.right, root.data+1, max));
	}
	
	public static void main(String[] args) {
		Node tree_level = new Node(1);
        tree_level.left = new Node(2);
        tree_level.right = new Node(3);
        tree_level.left.left = new Node(4);
        tree_level.left.right = new Node(5);
        tree_level.right.left = new Node(6);
        tree_level.right.right = new Node(7);
 
        System.out.println("Tree 1: " + isBinarySearchTree(tree_level));
        
        Node tree = new Node(4);
        tree.left = new Node(2);
        tree.right = new Node(6);
        tree.left.left = new Node(1);
        tree.left.right = new Node(3);
        tree.right.left = new Node(5);
        tree.right.right = new Node(7);
        
		System.out.println("Tree 2: " + isBinarySearchTree(tree));
		
		Node node = null;
		node = BinarySearchTree.insert(node,1);
		node = BinarySearchTree.insert(node,2);
		node = BinarySearchTree.insert(node,3);
		node = BinarySearchTree.insert(node,4);
		node = BinarySearchTree.insert(node,5);
		node = BinarySearchTree.insert(node,6);
		node = BinarySearchTree.insert(node,7);
		node = BinarySearchTree.insert(node,8);
		
		System.out.println("Tree 3: " + isBinarySearchTree(node));
	}

}
