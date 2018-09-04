package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> containsMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            containsMap.put(nums[i], i);
        }
        if(containsMap.size() > k ){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ContainsDuplicateII test = new ContainsDuplicateII();
        int[] num = {1,2,3,1};
        int k = 3;
        test.containsNearbyDuplicate(num, k);
    }
}
