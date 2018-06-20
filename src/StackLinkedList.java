/**
 * Stack implemented as LL with all operation at head because inserting
 * accessing, deleting from tail will happen in constant time instead 
 * of constant time.(Stack has all 4 operations in constant time)
 * No need to worry about memory overflow as in the case of Stack implementation
 * using array. Only some amount of memory used to store next node.
 * But the stack can be dynamically increased or decreased as per user requirement
 * @author Divya Singh
 *
 */

public class StackLinkedList {
	private static class Node {
		private String data;
		private Node next;
		private Node(String data) {
			this.data = data;
		}
	}
	
	private Node top;
	
	public Boolean isEmpty() {
		return top == null;
	}
	
	//add null pointer check when head null
	public String peek() {
		if(top == null) {
			return null;
		}
		else {
			return top.data;
		}
	}
	
	public void push(String data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	//add null pointer check
	public String pop() {
		String data = top.data;
		top = top.next;
		return data;
	}
}
