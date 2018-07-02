
public class LocalMaximaMinima {
	
	private static int localMaxima(int[] arr, int n) {
		return findLocalMaxima(arr, 0, n-1, n);
	}

	private static int findLocalMaxima(int[] arr, int low, int high, int n) {
		
        int mid = low + (high - low)/2;  
 
        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 ||
             arr[mid+1] <= arr[mid])) {
        	return mid;
        }
            
        else if (mid > 0 && arr[mid-1] > arr[mid]) {
            return findLocalMaxima(arr, low, (mid -1), n);
        }
 
        else return findLocalMaxima(arr, (mid + 1), high, n);
	}
	
	private static int localMinima(int[] arr, int n) {
		return findLocalMinima(arr, 0, n-1, n);
	}

	private static int findLocalMinima(int[] arr, int low, int high, int n) {
		int mid = low + (high - low)/2;  
		 
        if ((mid == 0 || arr[mid-1] >= arr[mid]) && (mid == n-1 ||
             arr[mid+1] >= arr[mid])) {
        	return mid;
        }
            
        else if (mid > 0 && arr[mid-1] < arr[mid]) {
            return findLocalMinima(arr, low, (mid -1), n);
        }
 
        else return findLocalMinima(arr, (mid + 1), high, n);
	}

	public static void main(String[] args) {
		int arr[] = {1, 3, 20, 4, 1, 0, 1};
        int n = arr.length;
        System.out.println("Index of a maxima is " + localMaxima(arr, n));
        System.out.println("Index of a minima is " + localMinima(arr, n));
	}

}
