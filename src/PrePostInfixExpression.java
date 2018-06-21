
public class PrePostInfixExpression {
	
	final int RADIX = 10;
	
	/**
	 * Need to handle delimiters as space or commas
	 * @param s
	 * @return
	 */
	public int evaluatePostfixExpression(String s) {
		GenericStack<Character> stack  = new GenericStack<Character>();
		char[] arr = s.toCharArray();
		for(int i=0; i<s.length()-1; i++) {
			if((arr[i] != '+') || (arr[i] != '-') || (arr[i] != '*') || (arr[i] != '/') || (arr[i] != '^')) {
				stack.push(arr[i]);
			} else {
				int x = Integer.parseInt(String.valueOf(stack.pop()));
				int y = Integer.parseInt(String.valueOf(stack.pop()));
				stack.push(performOperation(x,y,arr[i]));
			}
		}
		return Integer.parseInt(String.valueOf(stack.peek()));
	}

	private Character performOperation(int x, int y, char c) {
		switch(c) {
			case '+' :
				return Character.forDigit(x+y, RADIX);
			case '-' :
				return Character.forDigit(x-y, RADIX);
			case '*' :
				return Character.forDigit(x*y, RADIX);
			case '/' :
				return Character.forDigit(x/y, RADIX);
			case '^' :
				return Character.forDigit(x^y, RADIX);
			default:
				return null;
		}
	}
}
