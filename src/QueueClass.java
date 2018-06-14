
public class QueueClass {
	//consist of LinkedList linear struc of nodes
	private static class Node {
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node head; //remove from the head
	private Node tail; //add things here
	
	public Boolean isEmpty() {
		return head == null;
	}
	
	//will throw an exception when head is null...handle it
	public int peek() {
		return head.data;
	}
	
	public void add(int data) {
		Node node = new Node(data);
		if(tail != null) {
			tail.next = node;
		}
		tail = node;
		if(head == null) {
			head = node;
		}
	}
	
	public int remove() {
		int data = head.data;
		head = head.next;
		if(head == null) {
			tail = null;
		}
		return data;
	}
}
