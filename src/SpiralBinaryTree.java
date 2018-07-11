/**
 * print spiral order traversal data in a binary tree
 * We can print spiral order traversal in O(n) time and O(n) extra space. The 
 * idea is to use two stacks. We can use one stack for printing from left to 
 * right and other stack for printing from right to left. In every iteration,
 * we have nodes of one level in one of the stacks. We print the nodes, and 
 * push nodes of next level in other stack.
 * O(n)
 */

public class SpiralBinaryTree {

	static Node root = null;

	public static void printSpiralNode(Node node) {
		if(node == null) {
			return;
		}

		/** 
		 * s1 stores node for left to right
		 * s2 from right to left
		 */
		GenericStack<Node> s1 = new GenericStack<Node>();
		GenericStack<Node> s2 = new GenericStack<Node>();

		/**
		 * push first on s1
		 */
		s1.push(node);

		/**
		 * keep printing until both stack empty
		 */
		while(!s1.isEmpty() || !s2.isEmpty()) {

			/**
			 * print nodes from current level to s1 and push nodes of next level to s2
			 */
			while(!s1.isEmpty()) {
				Node n = s1.peek();
				s1.pop();
				System.out.print(n.data + " ");

				/**
				 * push right before left
				 */
				if(n.right != null) {
					s2.push(n.right);
				}
				if(n.left != null) {
					s2.push(n.left);
				}
			}

			/**
			 * print current level nodes from s2 and push next level nodes to s1
			 */
			while(!s2.isEmpty()) {
				 
				Node n = s2.peek();
				s2.pop();
				System.out.print(n.data + " ");

				/**
				 * push left before right
				 */
				if(n.left != null) {
					s1.push(n.left);
				}
				if(n.right != null) {
					s1.push(n.right);
				}
			}
		}
	}
	
	 public static void main(String[] args) 
	    {
	        Node tree = new Node(1);
	        tree.left = new Node(2);
	        tree.right = new Node(3);
	        tree.left.left = new Node(7);
	        tree.left.right = new Node(6);
	        tree.right.left = new Node(5);
	        tree.right.right = new Node(4);
	        System.out.println("Spiral Order traversal of Binary Tree is ");
	        printSpiralNode(tree);
	    }
}
