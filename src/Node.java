import java.util.LinkedList;
import java.util.Queue;

//Binary Search Tree


public class Node {
	int data;
	Node left;
	Node right;
	
	/**
	 * Print elements of BST in BFS order or level-order traversal	
	 * @param root
	 */
	
	static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(n.data + " ");
            if(n.left != null) {
                q.add(n.left);
            }
            if(n.right != null) {
                q.add(n.right);
            }
        }
    }
	
	/**
	 * MEthod to get height of the Binary tree
	 * @param root
	 * @return
	 */
	
	public int getHeight(Node root){
	    int heightLeft = 0;
	    int heightRight = 0;

	    if (root.left != null) {
	        heightLeft = getHeight(root.left) + 1;
	    }
	    if (root.right != null) {
	        heightRight = getHeight(root.right) + 1;
	    }

	  return (heightLeft > heightRight ? heightLeft : heightRight);
	}

	public Node(int data) {
		this.data = data;
	}

	//in O(log n)
	public void insert(int value) {
		if(value <= data) {
			if(left == null) {
				left = new Node(value);
			}
			else {
				left.insert(value);
			}
		}
		else {
			if (right == null) {
				right = new Node(value);
			}
			else {
				right.insert(value);
			}
		}
	}

	//in O(log n)
	public boolean contains(int value) {
		if(value == data) {
			return true;
		}
		else {
			if (value < data) {
				if(left == null) {
					return false;
				}
				else {
					return left.contains(value);
				}
			}
			else {
				if(right == null) {
					return false;
				}
				else {
					return right.contains(value);
				}
			}
		}
	}

	//in order traversal
	public void printInOrder() {
		if(left != null) {
			left.printInOrder();
		}
		System.out.println(data);
		if(right != null) {
			right.printInOrder();
		}
	}

	//pre-order traversal
	public void printPreOrder() {
		System.out.println(data);
		if(left != null) {
			left.printInOrder();
		}
		if(right != null) {
			right.printInOrder();
		}
	}

	//post-order traversal
	public void printPostOrder() {
		if(left != null) {
			left.printInOrder();
		}
		if(right != null) {
			right.printInOrder();
		}
		System.out.println(data);
	}
}
