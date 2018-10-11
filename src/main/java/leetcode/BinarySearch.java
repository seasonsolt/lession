package leetcode;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 2:47 PM 2018/10/10
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 *
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Note:
 *
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int begin = 0;
        int end = len - 1;
        int find = -1;
        while(find == -1 && begin <= end){
            int mid = (end + begin)/2;
            if(nums[mid] == target){
                find = mid;
                return find;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                begin = mid + 1;
            }
        }

        return find;
    }
    public static void main(String[] args){
        BinarySearch test = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int[] nums1 = {-1,0,3,5,9,12};
        int target2 = 2;
        int find = test.search(nums1, target2);
        System.out.println(find);

    }
}
