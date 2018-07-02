/**
 * Reverse linked list for k chunk of nodes
 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
 * Output:  3->2->1->6->5->4->8->7->NULL. 
 * Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
 * Output:  5->4->3->2->1->8->7->6->NULL. 
 */
public class RevLinkedListForKNodes {

	private static Node1 reverse(Node1 head, int k) {
		Node1 curr = head;
		Node1 prev = null;
		Node1 next = null;
		
		int count = 0;
		
		while(count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(next != null) {
			head.next = reverse(next,k);
		}
		
		return prev;
	}

	private static void printList(Node1 head) {
		Node1 temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
	}
	
	public static void main(String[] args) {
		
		LinkedListClass llist = new LinkedListClass();
		Node1 head = null;

		/* Constructed Linked List is 1->2->3->4->5->6->
	           7->8->8->9->null */
		head = llist.insertNodeAtHead(head, 9);
		head = llist.insertNodeAtHead(head, 8);
		head = llist.insertNodeAtHead(head, 7);
		head = llist.insertNodeAtHead(head, 6);
		head = llist.insertNodeAtHead(head, 5);
		head = llist.insertNodeAtHead(head, 4);
		head = llist.insertNodeAtHead(head, 3);
		head = llist.insertNodeAtHead(head, 2);
		head = llist.insertNodeAtHead(head, 1);

		System.out.println("Given Linked List");
		printList(head);

		head = reverse(head, 3);

		System.out.println("Reversed list");
		printList(head);

	}
}
