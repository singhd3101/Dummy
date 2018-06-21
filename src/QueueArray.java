/**
 * All operations performed in constant time
 * Circular Array - current position = i, n is size of array
 * Next position = (i+1) % n
 * Prev position = (i + n-1) % n
 * @author Divya Singh
 *
 */
public class QueueArray {
	
	int[] a = new int[50];
	int rear = -1;
	int front = -1;
	
	public void dequeue() {
		if(isEmpty()) {
			return; //or throw an error
		}
		else if(front == rear){
			rear = -1;
			front = -1;
		}
		else {
			//front++;
			front = (front+1) % a.length; 
		}
	}
	
	public void enqueue(int x) {
		//add case to handle overflow by using circular array
		//if (rear == a.length-1) {
		if ((rear+1)%a.length == front) {
			return;
		}
		else if(isEmpty()) {
			front = 0;
			rear = 0;
		}
		else {
			//rear++;
			rear = (rear+1)%a.length;
		}
		a[rear] = x;
	}
	
	public int peek() {
		if(front == -1) {
			return -1;
		}
		return a[front];
	}
	
	public Boolean isEmpty() {
		return ((front == -1) && (rear == -1));
	}
	
}
