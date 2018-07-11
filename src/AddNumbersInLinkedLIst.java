/**
 * Given two numbers represented by two lists, write a function that returns 
 * sum list. The sum list is list representation of addition of two input 
 * numbers.
 * Case 1: left to right addition
 * First List: 5->6->3  // represents number 365
 * Second List: 8->4->2 //  represents number 248
 * Resultant list: 3->1->6  // represents number 613
 * case 2: right to left addition
 */
public class AddNumbersInLinkedLIst {
	/**
	 * Traverse both lists. One by one pick nodes of both lists and add the values.
	 * If sum is more than 10 then make carry as 1 and reduce sum. If one list has
	 * more elements than the other then consider remaining values of this list as 0
	 */
	
	public Node1 addTwoLists(Node1 first, Node1 second) {
		Node1 res = null;
		Node1 prev = null;
		Node1 temp = null;
		int carry = 0;
		int sum = 0;
		
		while(first != null || second != null) {
			sum = carry + (first != null ? first.data : 0)
					    + (second != null ? second.data : 0);
			carry = (sum >= 10 ? 1 : 0);
			
			sum = sum % 10;
			temp = new Node1(sum);
			if (res==null) {
				res = temp;
			} else {
				prev.next = temp;
			}
			
			prev = temp;
			
			if(first != null) {
				first = first.next;
			}
			
			if(second != null) {
				second = second.next;
			}
		}
		
		if(carry > 0) {
			temp.next = new Node1(carry);
		}
		
		return res;
	}
}
