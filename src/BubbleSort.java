
public class BubbleSort {

	public void bubbleSort(int[] arr) {
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
	
}
