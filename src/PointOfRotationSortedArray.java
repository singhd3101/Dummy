/**
 * You are given a sorted array. However, there is a problem. Someone just 
 * rotated the sorted array by K spaces and we do not know the value of K. 
 * Write a program to find the value of K by which the array is rotated.
 * O(n)     - brute force
 * O(log n) - binary search
 */
public class PointOfRotationSortedArray {
	
	public static void bruteForce(int[] A) {
		for (int i = 1; i < A.length; i++) {
			if(A[i] < A[i-1]){
				System.out.println(A[i]);
				break;
			}
		}
	}
	
	public static void findRotationPoint(int[] A) {
		int start = 0, end = A.length - 1, mid;
		mid = start + (end - start) / 2;
		int last = A[A.length - 1];
		while (start <= end) {
			if (A[mid] > last) {
				start = mid + 1;
			} else if (A[mid] < last) {
				end = mid - 1;
			} else
				break;
			mid = start + (end - start) / 2;
		}
		System.out.println(A[mid]);
	}

}
