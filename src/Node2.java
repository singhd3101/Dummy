/**
 * Doubly linked list
 * @author D
 * provides forward and reverse lookup, uses extra memory in Node to point 
 * to previous node, helps in deleting nodes
 */


public class Node2 {
	
	int data;
	Node2 next;
	Node2 prev;
	
	public Node2(int data) {
		this.data = data;
		next = null;
		prev = null;
	}
	
}
