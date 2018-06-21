/**
 * Conversion of infix to prefix and postfix expressions
 * @author Divya Singh
 *
 */

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
				stack.push(performOperation(y,x,arr[i]));
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

	/**
	 * Need to handle delimiters as space or commas
	 * @param s
	 * @return
	 */
	public int evaluatePrefixExpression(String s) {
		GenericStack<Character> stack  = new GenericStack<Character>();
		char[] arr = s.toCharArray();
		for(int i=s.length()-1; i>=0; i--) {
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

	public String infixToPostfix(String s) {
		String postfixString = "";
		GenericStack<Character> stack  = new GenericStack<Character>();
		char[] arr = s.toCharArray();
		for(int i=0; i<s.length()-1; i++) {
			if((arr[i] != '+') || (arr[i] != '-') || (arr[i] != '*') || (arr[i] != '/')) {
				postfixString = postfixString+arr[i];
			} 
			else if((arr[i] == '+') || (arr[i] == '-') || (arr[i] == '*') || (arr[i] == '/')) {
				while(!stack.isEmpty() && !isOpeningParathesis(stack.peek())
						&& hasHigherPrecedence(stack.peek(), arr[i])) {
					postfixString = postfixString + stack.peek();
					stack.pop();
				}
				stack.push(arr[i]);
			}
			else if(isOpeningParathesis(arr[i])) {
				stack.push(arr[i]);
			}
			else if(isClosingParathesis(arr[i])) {
				while(!stack.isEmpty()  && !isOpeningParathesis(stack.peek())) {
					postfixString = postfixString + stack.peek();
					stack.pop();
				}
				stack.pop();
			}
		}
		while(!stack.isEmpty()) {
			postfixString = postfixString + stack.peek();
			stack.pop();
		}
		return postfixString;
	}

	/**
	 * Parenthesis can be modified to {} or []
	 * @param c
	 * @return
	 */
	private boolean isClosingParathesis(char c) {
		return (c == ')') ;
	}

	private boolean isOpeningParathesis(Character peek) {
		return (peek == '(') ;
	}

	private boolean hasHigherPrecedence(Character peek, char c) {
		if((c == '+') || (c == '-')) {
			return true;
		}
		if(c == '*') {
			if((peek == '+') || (peek == '-')) {
				return false;
			}
			if((peek == '*') || (peek == '/')) {
				return true;
			}
		}
		if(c == '/') {
			if((peek == '+') || (peek == '*') || (peek == '-')) {
				return false;
			}
			if(peek == '/') {
				return true;
			}
		}
		return false;
	}
}
