/** Time Complexity - O(h)
 * Case 1 - Node has right sub tree - 
 * Go deep to leftmost node in right subtree or find minimum in right subtree
 * Case 2 - No right sub tree - 
 * go to the nearest ancestor for which given node would be in left subtree
 * ## construct BST so that it can store address of the parent as well
 */

public class InorderBSTSuccessor {
	
	public static Node getSuccessor(Node root, int data) {
		Node curr = BinarySearchTree.search(root,data);
		if(curr == null) {
			return null;
		} 
		
		/**
		 * Case 1 - node has right sub tree
		 */
		if(curr.right != null) {
			Node temp = curr.right;
			while(temp.left != null) {
				temp = temp.left;
			}
			return temp;
		}
		
		/**
		 * Case 2 - No right sub tree
		 */
		else {
			Node successor = null;
			Node ancestor = root;
			while(ancestor != curr) {
				if(curr.data < ancestor.data) {
					successor = ancestor;
					ancestor = ancestor.left;
				} else {
					ancestor = ancestor.right;
				}
			}
			return successor;
		}
	}

	public static void main(String[] args) {
		
		Node root = null;
		root = BinarySearchTree.insert(root, 15);
		root = BinarySearchTree.insert(root, 10);
		root = BinarySearchTree.insert(root, 8);
		root = BinarySearchTree.insert(root, 6);
		root = BinarySearchTree.insert(root, 12);
		root = BinarySearchTree.insert(root, 11);
		root = BinarySearchTree.insert(root, 20);
		root = BinarySearchTree.insert(root, 17);
		root = BinarySearchTree.insert(root, 16);
		root = BinarySearchTree.insert(root, 25);
		root = BinarySearchTree.insert(root, 27);
		
		System.out.println(getSuccessor(root,12).data);
	}

}
