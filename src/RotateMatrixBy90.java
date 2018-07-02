
public class RotateMatrixBy90 {
	
	private static int[][] rotateAntiClockwise(int[][] arr) {
		int[][] res = new int[arr[0].length][arr.length];
		
		for (int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				res[arr[0].length - j - 1][i] = arr[i][j];
			}
		}
		
		return res;
	}

	private static int[][] rotateClockwise(int[][] arr) {
		int[][] res = new int[arr[0].length][arr.length];
		
		for (int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				res[j][arr.length - i - 1] = arr[i][j];
			}
		}
		
		return res;
	}

	private static void printArray(int[][] arr) {
		System.out.println("Print - ");
		for (int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int n = 3;
		
		int[][] arr = new int[n][n];
		
		int p = 0;
		
		for (int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = p;
				p++;
			}
		}
		
		printArray(arr);
		int[][] a = rotateClockwise(arr);
		printArray(a);
		int[][] ab = rotateAntiClockwise(arr);
		printArray(ab);
	}
}
