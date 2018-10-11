package leetcode;

import org.junit.Assert;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 2:54 PM 2018/10/11
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 * Search in Rotated Sorted Array
 * Go to Discuss
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length < 1){
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        int startPos = -1;
        int startPosValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (startPosValue > nums[i]) {
                startPos = i;
                startPosValue = nums[i];
            }
        }
        if (startPos > begin) {
            int r1 = posSearch(nums, startPos, end, target);
            int r2 = posSearch(nums, begin, startPos - 1, target);
            return r1 > r2 ? r1 : r2;
        } else {
            return posSearch(nums, begin, end, target);
        }

    }

    public int posSearch(int[] nums, int begin, int end, int target) {
        while (begin <= end) {
            int mid = (end + begin) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray test = new SearchinRotatedSortedArray();
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(test.search(nums, target));
        Assert.assertEquals(test.search(nums, 0), 4);
        Assert.assertEquals(test.search(nums, 3), -1);
    }


}
