
public class MaxWeightBinaryTree {
	
	private static int maxWeight(Node node) {
		
		if(node != null) {
			return node.data + maxWeight(node.left) + maxWeight(node.right);
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		Node node = new Node(2);
		node.left = new Node(-1);
		node.right = new Node(3);
		
		System.out.println(maxWeight(node));

	}

}
