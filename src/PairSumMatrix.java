import java.util.HashSet;
import java.util.Set;

public class PairSumMatrix {

	private static int[][] findPairSum(int[][] a, int k) {
		Set<Integer> s = new HashSet<Integer>();
		int[][] result = new int[10][2];
		int p = 0;
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				if(s.contains(k-a[i][j])) {
					result[p][0] = k-a[i][j];
					result[p][1] = a[i][j];
					p++;
				} else {
					s.add(a[i][j]);
				}
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		int[][] array = new int[4][4];
		int nos = 0;
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				array[i][j] = nos;
				nos++;
			}
		}
		
		int[][] s = findPairSum(array,5);
		
		for(int i=0; i<s.length; i++) {
			System.out.println(s[i][0]+ " " + s[i][1]);
		}

	}

}
