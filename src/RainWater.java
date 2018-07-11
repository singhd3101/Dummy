public class RainWater {
	
	public static void main(String[] args) 
    {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = arr.length;
         
        System.out.println("Maximum water that can be accumulated is " + findWater(arr, n));
    }

	private static int findWater(int[] arr, int n) {
		
		int result = 0;
		int leftMax = 0;
		int rightMax = 0;
		int lo = 0;
		int hi = n-1;
		
		while(lo <= hi) {
			if (arr[lo] < arr[hi]) {
				if(arr[lo] > leftMax) {
					leftMax = arr[lo];
				} else {
					result = result + leftMax - arr[lo]; 
					lo++;
				}
			} else {
				if(arr[hi] > rightMax) {
					rightMax = arr[hi];
				} else {
					result = result + rightMax - arr[hi];
					hi--;
				}
			}
		}
		
		return result;
	}

}
