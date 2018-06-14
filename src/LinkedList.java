import java.util.HashSet;
import java.util.Set;

public class LinkedList {
	
	/**
	 * match two linked list if they are equal = same data in same number of nodes
	 * @param head1
	 * @param head2
	 * @return
	 */
	
	static boolean compareLists(Node1 head1, Node1 head2) {
        if((head1 == null) && (head2 == null)) {
            return true;
        }
        if(((head1 != null) && (head2 == null)) ||
           ((head2 != null) && (head1 == null))) {
            return false;
        }
        if(head1.data == head2.data) {
            return compareLists(head1.next, head2.next);
        }
        else {
            return false;
        }
    }
	
	/**
	 * Delete a node form linked list
	 * @param head
	 * @param position
	 * @return
	 */
	
	static Node1 deleteNode(Node1 head, int position) {
        if(head == null) {
            return head;
        }
        int ctr = 0;
        Node1 tmp = head;
        Node1 prev = null;
        while(tmp != null) {
            if(ctr == position) {
                if(ctr == 0) {
                    head = head.next;
                    break;
                } else {
                    prev.next = tmp.next;
                    break;
                }
            }
            else {
                ctr++;
                prev = tmp;
                tmp = tmp.next;
            }
        }
        return head;
    }	
	
	/**
	 * Insert node at head of the linked list
	 * @param head
	 * @param data
	 * @return
	 */
	
	static Node1 insertNodeAtHead(Node1 head, int data) {
		Node1 n = new Node1(data);
        if(head != null) {
            n.next = head;
        }
        return n;
    }
	
	/**
	 * Insert node at tail of linked list
	 * @param head
	 * @param data
	 * @return
	 */
	
	static Node1 insertNodeAtTail(Node1 head, int data) {
        if (head == null) {
        	Node1 n = new Node1(data);
            return n;
        }
        addNode(head,data);       
        return head;
    }

    static void addNode(Node1 head, int data) {
        if(head.next == null) {
        	Node1 n = new Node1(data);
            head.next = n;
        }
        else {
            insertNodeAtTail(head.next,data);
        }
    }
	
	/**
	 * Add node a t a certain position in Linked List
	 * @param head
	 * @param data
	 * @param position
	 * @return
	 */
	
	static Node1 insertNodeAtPosition(Node1 head, int data, int position) {
		Node1 node = new Node1(data);
        int ctr = 0;
        Node1 tmp = head;
        Node1 prev = null;
        while(tmp != null){
            if (ctr == position) {
                prev.next = node;
                node.next = tmp;
                break;
            } else {
                ctr++;
                prev = tmp;
                tmp = tmp.next;
            }
        }
        return head;
    }
	
	/**
	 * Remove Node from Linked List
	 * @param head
	 * @return
	 */
	
	public static Node1 removeDuplicates(Node1 head) {
        if(head == null) {
            return head;
        }
        if(head.next == null) {
            return head;
        }
        Set<Integer> s = new HashSet<Integer>();
        s.add(head.data);
        checkNodes(s, head, head.next);
        return head;
    }

    public static void checkNodes(Set<Integer> s, Node1 first, Node1 second) {
        while(second != null) {
            if(s.contains(second.data)) {
                first.next = second.next;
                second = second.next;
            } else {
                s.add(second.data);
                first = second;
                second = second.next;
            }
        }
    }
	
	/*
	 * Iterative Solution - Traverse the whole list and at each node, adjust 
	 * link part of the node to point to previous node instead of next node
	 */
	
	public Node1 reverseLinkedList(Node1 head) {
		Node1 next = null;
		Node1 prev = null;
		Node1 current = head;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
	
	/*
	 * Recursive Solution - 
	 */
	
	public static Node1 head;

	public void revLinkedList(Node1 p) {
		if(p.next == null) {
			head = p;
			return;
		}
		revLinkedList(p.next);
		Node1 q = p.next;
		q.next = p;
		p.next = null;
	}
	
	/*
	 * Print elements of a list in recursive fashion
	 */
	public void print(Node1 head) {
		if(head == null) {
			return;
		}
		System.out.println(head.data);
		print(head.next);
	}
	
	/*
	 * Print elements of a list in reverse order in recursive fashion
	 */
	public void printReverse(Node1 head) {
		if(head == null) {
			return;
		}
		printReverse(head.next);
		System.out.println(head.data);
	}
	
}
