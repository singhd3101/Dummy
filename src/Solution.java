import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class Solution {

	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n==1) {
			return 1;
		}
		else {
			return (fibonacci(n-1) + fibonacci(n-2));
		}
	}

	public static void bubbleSort(int[] arr) {
		int numSwaps = 0;
		boolean isSorted = false;
		int lastSorted = arr.length - 1;

		while(!isSorted) {
			isSorted = true;
			for(int i=0; i<lastSorted; i++) {
				if(arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					isSorted = false;
					numSwaps++;
				}
			}
			lastSorted--;
		}

		int firstElement = arr[0];
		int lastElement = arr[arr.length-1];

		System.out.println("Array is sorted in "+numSwaps+" swaps.");
		System.out.println("First Element: " + firstElement);
		System.out.println("Last Element: " + lastElement);
	}

	private static void leftRotationArray(int k, int[] a, int n) {

		int[] b = new int[n];

		for(int i = 0; i < n; i++) {
			b[(i + (n - k)) % n] = a[i];
		}

		for(int i=0; i<a.length; i++) {
			System.out.print(b[i]);
			System.out.print(" ");
		}
	}

	private static void createAnagram(String a, String b) {

		int deletions = 0;

		List<String> aList = convertToList(a);
		List<String> bList = convertToList(b);

		for(int i=0; i<aList.size(); i++) {
			if(bList.contains(aList.get(i))) {
				bList.remove(aList.get(i));
			}
			else {
				deletions++;
			}
		}

		deletions = deletions + bList.size();

		System.out.println(deletions);
	}

	private static List<String> convertToList(String str) {
		List<String> charList = new ArrayList<String>();      
		for(int i = 0; i<str.length();i++){
			charList.add(Character.toString(str.charAt(i)));
		}
		return charList;
	}

	/*
    Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

    A Node1 is defined as: 
        class Node1 {
            int data;
            Node1 next;
        }
	 */

	boolean hasCycle(Node1 head) {
		if (head == null) {
            return false;
        }
		Set<Node1> s = new HashSet<Node1>();
		while(head != null) {
			if (s.contains(head)) {
				return true;
			}
			else {
				s.add(head);
				head = head.next;
			}
		}
		return false;
	}
	
	boolean hasCycleLinkedList(Node1 head) {
	    if(head == null){
	        return false;
	    }
	    Node1 fast = head;
	    while(head.next != null && fast != null){
	        head = head.next;
	        fast = fast.next.next;
	        if(head == fast){
	            return true;
	        }
	    }
	    return false;
	}

	static int[] solve(int[] a, int[] b) {
		int[] sol = new int[2];
		for(int i=0; i<3; i++) {
			if (a[i] > b[i]) {
				sol[0]++;
			}
			else if (a[i] < b[i]){
				sol[1]++;
			}
		}
		return sol;
	}

	private static void calculateCost(double meal_cost, int tip_percent, int tax_percent) {
		double totalCost = 0;
		totalCost = meal_cost + tip_percent*meal_cost/100 + tax_percent*meal_cost/100;
		System.out.println("The total meal cost is "+ Math.round(totalCost) +" dollars.");
	}

	private static void ransomNote(int m, int n, String mag, String ran) {
		Map<String, Integer> hashTable = new HashMap<String, Integer>();
		Boolean flag = true;

		for (String a : mag.split(" ")) {
			Integer i = hashTable.get(a);
			if (i == null) {
				hashTable.put(a, 1);
			} else {
				hashTable.put(a, i + 1);
			}
		}

		for (String b : ran.split(" ")) {
			Integer i = hashTable.get(b);
			if (i == null || hashTable.get(b) == 0) {
				flag = false;
				break;
			} else {
				hashTable.put(b, i - 1);
			}
		}
		System.out.println(flag ? "Yes" : "No");
	}

	public static boolean isBalanced(String expression) {
		Stack<Character> expressionStack = new Stack<Character>();
		if(expression.length() == 0) return false;

		for(int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			switch(c) {
			case ')':
				if(expressionStack.isEmpty() || (Character)expressionStack.pop() != '(') 
					return false; 
				break;
			case '}':
				if(expressionStack.isEmpty() || (Character)expressionStack.pop() != '{') 
					return false; 
				break;
			case ']':
				if(expressionStack.isEmpty() || (Character)expressionStack.pop() != '[') 
					return false; 
				break;
			default:
				expressionStack.push(c);
			}
		}
		if(!expressionStack.isEmpty()) return false;
		return true;
	}

	private static void reviewLoop(List<String> list) {
		for(String s : list) {
			char[] arr = s.toCharArray();
			String odd = "";
			String even = "";
			for(int i=0; i<arr.length; i++) {
				if((i%2) == 0) {
					even = even + Character.toString(arr[i]);
				}
				else {
					odd = odd + Character.toString(arr[i]);
				}
			}
			System.out.println(even + " " + odd);
		}
	}

	boolean checkBST(Node root) {
		return binarySearchTree(root,  Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean binarySearchTree(Node node, int m, int n) {
		if (node == null) return true;
		return  m < node.data && node.data < n && 
				binarySearchTree(node.left, m, node.data) && 
				binarySearchTree(node.right, node.data, n);
	}

	static BigInteger factorial(int n) {
		BigInteger b = new BigInteger("1");
		for(int i=1;i<=n;i++){
			b = b.multiply(new BigInteger(String.valueOf(i)));
		}
		return b;
	}

	private static void isPrime(BigInteger n) {
		System.out.println(n.isProbablePrime(1) ? "prime" :"not prime");
	}

	public static int lonelyInteger(int[] a) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i=0; i<a.length;i++){
			if (!set.add(a[i])){
				set.remove(a[i]);
			}
		}
		Integer[] array = null;
		array= set.toArray(new Integer[1]);
		return array[0].intValue();
	}

	private static void decimalToBinary(int n) {

		List<Integer> list = new ArrayList<Integer>();

		while(n > 0) {
			int remainder = n%2;
			n = n/2;
			list.add(remainder);
		}
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i));
		} 
		System.out.println();

		int counter = 0;
		int max = 0;
		Boolean flag = false;

		for(int i=list.size()-1; i>=0; i--) {
			if((list.get(list.size()-1) == 1) && (i == list.size()-1)) {
				counter ++;
				if (counter > max) {
					max = counter;
				}
				flag = true;
			}
			else if(list.get(i) == 1) {
				if(flag) {
					counter ++;
					flag = true;
					if (counter > max) {
						max = counter;
					}
				}
				else {
					counter = 1;
					flag = true;
				}
			}
			else {
				counter = 0;
				flag = false;
			}
		}
		System.out.println("max: "+max);
	}

	private static void maxHourglass(int[][] arr) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if(i>0 && i<5 && j>0 && j<5) {
					sum = arr[i][j] + arr[i-1][j] + arr[i+1][j] + arr[i-1][j-1] + arr[i-1][j+1]
							+ arr[i+1][j-1] + arr[i+1][j+1];
					if(sum > max) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}

	private static void secondLargest(int[] arr) {
		int l = 0;
		int s = 0;

		for(int i=0; i<arr.length; i++) {
			if(arr[i] > l) {
				s = l;
				l = arr[i];
			}
			if((l > arr[i]) && (arr[i] > s)) {
				s = arr[i];
			}
		}

		System.out.println(s);
	}

	private static void computeDifference (int[] elements) {
		int max = 0;
		int min = 100;
		for(int i=0 ;i<elements.length; i++) {
			if(elements[i] > max) {
				max = elements[i];
			}
			if(elements[i] < min) {
				min = elements[i];
			}
		}
		System.out.println(Math.abs(max - min));
	}
	
	public static String reverseStringInConstanctSpace(String s) {
		char[] charArray = s.toCharArray();
		int j=charArray.length-1;
		int i = 0;
		while(i<j) {
			char c = charArray[j];
			charArray[j] = charArray[i];
			charArray[i] = c;
			i++;
			j--;
		}
		return String.valueOf(charArray);
	}
	
	private static Boolean checkBalParanth(String s) {
		int n = s.length();
		GenericStack<Character> stack = new GenericStack<Character>();
		for(int i =0; i<s.length(); i++) {
			if(Character.toString(s.charAt(i)).equals("(") ||
			   Character.toString(s.charAt(i)).equals("{") ||
			   Character.toString(s.charAt(i)).equals("[") ) {
				stack.push(s.charAt(i));
			}
			else if(Character.toString(s.charAt(i)).equals(")") ||
					   Character.toString(s.charAt(i)).equals("}") ||
					   Character.toString(s.charAt(i)).equals("]") ) {
				if(stack.isEmpty()) {
					return false;
				}
				else if(!(Character.toString(s.charAt(i)).equals(")")) &&
						(Character.toString(stack.peek()).equals("("))) {
					return false;
				}
				else if(!(Character.toString(s.charAt(i)).equals("}")) &&
						(Character.toString(stack.peek()).equals("{"))) {
					return false;
				}
				else if(!(Character.toString(s.charAt(i)).equals("]")) &&
						(Character.toString(stack.peek()).equals("["))) {
					return false;
				}
				else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
	//	System.out.println(reverseStringInConstanctSpace("testing"));
	//	System.out.println(checkBalParanth(")("));
		
		/*int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 5;

		computeDifference(arr);*/

		/*int[] arr = new int[5];
		arr[0] = 2;
		arr[1] = 3;
		arr[2] = 6;
		arr[3] = 6;
		arr[4] = 5;

		secondLargest(arr);*/

		/*int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        maxHourglass(arr);
        scanner.close();*/

		/*decimalToBinary(11);*/

		/*int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
       for (int i = 0; i < n; i++) {
        	int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        System.out.println(lonelyInteger(a));
        scanner.close();*/

		/*Scanner in = new Scanner(System.in);
		BigInteger n = in.nextBigInteger();
		in.close();
		System.out.println(n.isProbablePrime(1) ? "prime" :"not prime");*/

		/*Scanner in = new Scanner(System.in);

		Map<String,Integer> phoneBook = new HashMap<String,Integer>();

        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            if(phoneBook.get(s) != null) {
            	System.out.println(s+"="+phoneBook.get(s));
            }
            else {
            	System.out.println("Not Found");
            }
        }
        in.close();*/

		/*Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        List<String> list = new ArrayList<String>();

        for(int i=0; i<n; i++) {
        	String s = scan.nextLine();
        	list.add(s);
        }

        reviewLoop(list);

        scan.close();*/

		/*Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }*/


		/*GenericQueue<Integer> queue = new GenericQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peekFirst());
            }
        }
        scan.close();*/

		/*int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            System.out.println(isBracketBalanced(expression) ? "YES" : "NO");
        }

        scanner.close();*/

		/*Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		String mag = in.nextLine();
		String ran = in.nextLine();*/

		/*int m = 1;
		int n = 1;
		String mag = "One  give me grand today night";
		String ran = "give one grand today";

		ransomNote(m,n,mag,ran);*/

		/*Scanner in = new Scanner(System.in);
        double meal_cost = in.nextDouble();
        int tip_percent = in.nextInt();
        int tax_percent = in.nextInt();
        in.close();

        calculateCost(meal_cost,tip_percent,tax_percent);*/

		/*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] a = new int[3];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] b = new int[3];

        String[] bItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b[i] = bItem;
        }*/

		/*int[] a = new int[3];
    	a[0] = 5;
    	a[1] = 6;
    	a[2] = 7;

    	int[] b = new int[3];
    	b[0] = 3;
    	b[1] = 6;
    	b[2] = 10;

        int[] result = solve(a, b);*/

		/*for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();*/

		scanner.close();

		/*int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        int i2 = 0;
        double d2 = 0.0;
        String s2 = "";

        i2 = scan.nextInt();
        d2 = scan.nextDouble();
        scan.nextLine();
        s2 = scan.nextLine();

        System.out.println(s2);

        System.out.println(i + i2);
        System.out.println(d + d2);
        System.out.println(s.concat(s2));

        scan.close();*/

		/*String a = scanner.nextLine();

        String b = scanner.nextLine();

        scanner.close();

        createAnagram(a,b);*/

		/*String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);    
        int k = Integer.parseInt(nk[1]);
        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            System.out.println(aItem);
            a[i] = aItem;
        }

        scanner.close();

        long startTime = System.nanoTime();        
        leftRotationArray(k,a,n);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;

        System.out.println("Time: "+ duration);*/

		/*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
        	arr[i] = scanner.nextInt();
        }
        scanner.close();

        bubbleSort(arr);*/
	}
}

class Calculator{
	public int power(int n, int p) throws Exception {
		if((n < 0) || (p < 0)) {
			throw new Exception("n and p should be non-negative");
		} else {
			return (int)Math.pow(n, p);
		}
	}
}