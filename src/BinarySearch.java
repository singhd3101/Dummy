
public class BinarySearch {

	//Recursive Implementation
	public static Boolean binarySearchRecursive(int[] array, int x, int left, int right) {
		if(left > right) {
			return false;
		}

		/**
		 * left + right might overflow with java integers, to handle that
		 * mid = left + ((right - left) / 2);
		 */

		int mid = (left + right)/2;

		if(array[mid] == x) {
			return true;
		}
		else if(x < array[mid]) {
			return binarySearchRecursive(array, x, left, mid - 1);
		}
		else {
			return binarySearchRecursive(array, x, mid + 1, right);
		}
	}

	public static Boolean binarySearchRecursive(int[] array, int x) {
		return binarySearchRecursive(array, x, 0, array.length - 1);
	}

	//Iterative Implementation
	public static Boolean binarySearchIterative(int[] array, int x) {
		int left = 0;
		int right = array.length - 1;

		while( left <= right) {
			/**
			 * left + right might overflow with java integers, to handle that
			 * mid = left + ((right - left) / 2);
			 */

			int mid = (left + right)/2;

			if(array[mid] == x) {
				return true;
			}
			else if(x < array[mid]) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		return false;
	}
}
