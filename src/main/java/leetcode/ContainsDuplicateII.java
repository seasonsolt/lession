package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> containsMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            Integer preVal = containsMap.put(nums[i], i);
            if(preVal != null && Math.abs(preVal - i) <= k ){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII test = new ContainsDuplicateII();
        int[] num1 = {1,2,3,1};
        int[] num2 = {1,0,1,1};
        int[] num3 = {1,2,3,1,2,3};
        int[] num4 = {99,992};
        int k1 = 3;
        int k2 = 1;
        int k3 = 2;
        int k4 = 2;
        System.out.println(test.containsNearbyDuplicate(num1, k1));
        System.out.println(test.containsNearbyDuplicate(num2, k2));
        System.out.println(test.containsNearbyDuplicate(num3, k3));
        System.out.println(test.containsNearbyDuplicate(num4, k4));
    }
}
