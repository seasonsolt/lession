package leetcode;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2] Example 2:
 * <p>
 * Input: nums = [1], k = 1 Output: [1] Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements. Your
 * algorithm's time complexity must be better than O(n log n), where n is the
 * array's size.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

        // ((TreeMap<Integer, Integer>) sumMap).tailMap();
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            sumMap.put(nums[i], sumMap.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(sumMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            // 升序排序
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }

        });

        System.out.println(list);

        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements test = new TopKFrequentElements();
        int[] arr1 = { 1, 1, 1, 2, 2, 3 };
        int[] arr2 = { -1, -1 };
        int[] arr3 = { 4, 1, -1, 2, -1, 2, 3 };

        // System.out.println(test.topKFrequent(arr1, 2));
        // System.out.println(test.topKFrequent(arr2, 1));
        System.out.println(test.topKFrequent(arr3, 2));

    }

}
