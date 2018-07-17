import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		Set<String> tree = new TreeSet<>();
		for(int i=0; i<nums.length-2; i++){
			int j=i+1;
			int k = nums.length-1;
			while(j<k){
				int sum = nums[i]+nums[j]+nums[k];
				if(sum == 0){
					String trip = nums[i]+":"+nums[j]+":"+nums[k];
					if(!tree.contains(trip)){
						List<Integer> triplets = new ArrayList<>();
						triplets.add(nums[i]);
						triplets.add(nums[j]);
						triplets.add(nums[k]);
						tree.add(trip);
						list.add(triplets);
					}
					k--;
					j++;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}        

		return list;
	}
}
