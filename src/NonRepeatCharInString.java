/**
 * print first non repeating character in a string
 * Count array stores count and index
 * O(n)
 *
 */

import java.util.HashMap;
import java.util.Map;

public class NonRepeatCharInString {
	
	static Map<Character, CountIndex> hm = new HashMap<Character, CountIndex>(256);
	
	private static void fetchCount(String s) {
		for(int i=0; i<s.length(); i++) {
			if(hm.containsKey(s.charAt(i))) {
				hm.get(s.charAt(i)).incCount();
			} else {
				hm.put(s.charAt(i), new CountIndex(i));
			}
		}
	}

	private static int firstNRChar(String s) {
		
		fetchCount(s);
		int res = Integer.MAX_VALUE;
		
		for(int i=0; i<s.length(); i++) {
			if(hm.get(s.charAt(i)).count == 1 && res > hm.get(s.charAt(i)).index) {
				res = hm.get(s.charAt(i)).index;
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		String s = "cococohcpococo";
		
		System.out.println(s.charAt(firstNRChar(s)));
	}

}

class CountIndex
{
    int count;
    int index;
     
    public CountIndex(int index) {
        this.count = 1;
        this.index = index;
    }
     
    public void incCount() {
        this.count++;
    }
}
