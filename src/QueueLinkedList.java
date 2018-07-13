
public class QueueLinkedList {
	
	private Node1 front = null;
	private Node1 rear = null;
	
	public QueueLinkedList() {
		
	}
	
	public void enqueue(int x) {
		Node1 temp = new Node1(x);
		if(front==null && rear==null) {
			front = temp;
			rear = temp;
			return;
		}
		rear.next = temp;
		rear = temp;
	}
	
	public Node1 dequeue() {
		Node1 temp = front;
		if(front == null) {
			return null;
		}
		if(front == rear) {
			front = null;
			rear = null;
		} else {
			front = front.next;
		}
		return temp;
	}
	
	public Node1 front() {
		return front;
	}
	
	public Boolean isEmpty() {
		return (front == null && rear == null ? true : false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
