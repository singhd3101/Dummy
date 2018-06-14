
public class StackArray {

	int[] stack;
	private int top;

	public StackArray() {
		top = -1;
		stack = new int[100];
	}

	//done in constant time
	public void push(int data) {
		
		//in case of overflow increase the size of array
		//this will take O(n)
		//n = stack.length
		if(top == stack.length-1) {
			int[] newStack = new int[2*stack.length];
			System.arraycopy(stack,0,newStack,0,stack.length);
			stack = newStack;
		}
		
		top = top + 1;
		stack[top] = data;
	}

	//done in constant time
	public int pop() {
		if(top == -1) {
			System.out.println("Stack is empty");
			return 0; 
		}
		int data = stack[top];
		top = top - 1;
		return data;
	}

	//done in constant time
	public int peek() {
		return stack[top];
	}

	//done in constant time
	public boolean isEmpty() {
		return (top == -1 ? true : false);
	}

}
