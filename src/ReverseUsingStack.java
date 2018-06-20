/**
 * Reverse String or Linked List or collection using stack
 * @author Divya Singh
 *
 */

public class ReverseUsingStack {

	/**
	 * Time complexity = O(n)
	 * Space complexity = O(n)
	 * @param s
	 * @return
	 */
	public String reverseStringUsingStack(String s) {
		GenericStack<Character> stack = new GenericStack<Character>();
		char[] charArray = s.toCharArray();
		for(Character c : charArray) {
			stack.push(c);
		}
		String o = "";
		while(!stack.isEmpty()) {
			o = o + Character.toString(stack.pop());
		}
		return o;
	}
	
}
