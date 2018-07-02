/**
 * print level order traversal of trees also known as bfs
 *
 */

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalBFS {
	
	public static void levelOrderTraversalBFS(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while(!q.isEmpty()) {
			
			Node temp = q.poll();
			System.out.print(temp.data + " ");
			
			// Enqueue temp_node’s children (first left then right children) to q
			
			if(temp.left != null) {
				q.add(temp.left);
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		Node tree_level = new Node(1);
        tree_level.left = new Node(2);
        tree_level.right = new Node(3);
        tree_level.left.left = new Node(4);
        tree_level.left.right = new Node(5);
 
        System.out.println("Level order traversal of binary tree is - ");
        levelOrderTraversalBFS(tree_level);

	}

}
