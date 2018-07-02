
public class LeftRightViewBinaryTree {
	
	static int  max_level = 0;
	static Max_level max = new Max_level();
	
	private static void leftView(Node root) {
		leftViewUtil(root, 1);
	}
	
	private static void leftViewUtil(Node node, int level) {
	
        if (node==null) return;
 
        if (max_level < level) {
            System.out.print(" " + node.data);
            max_level = level;
        }
        
        leftViewUtil(node.left, level+1);
        leftViewUtil(node.right, level+1);
	}
	
	private static void rightView(Node node) {
		rightViewUtil(node, 1, max);
	}

	private static void rightViewUtil(Node node, int level, Max_level max_level) {
		
		if (node == null) return;
 
        if (max_level.max_level < level) {
            System.out.print(node.data + " ");
            max_level.max_level = level;
        }
 
        rightViewUtil(node.right, level + 1, max_level);
        rightViewUtil(node.left, level + 1, max_level);
	}

	public static void main(String[] args) {
		
		Node tree = new Node(12);
        
		tree.left = new Node(10);
        tree.right = new Node(30);
        tree.right.left = new Node(25);
        tree.right.right = new Node(40);
 
        System.out.print("Left view: ");
        leftView(tree);
        System.out.println();
        System.out.print("Right view: ");
        rightView(tree);
	}
}

class Max_level {
	 
    int max_level;
}
