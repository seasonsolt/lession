package leetcode;

import java.util.*;

public class IntersectionofTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> outList = new LinkedList<Integer>();
        Map<Integer, Integer> interMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            Integer oldVal = interMap.get(nums1[i]);
            if (null != oldVal) {
                interMap.put(nums1[i], ++oldVal);
            } else {
                interMap.put(nums1[i], 1);
            }
        }
        for (int j = 0; j < nums2.length; j++) {
            Integer num1Val = interMap.get(nums2[j]);
            if (null == num1Val) {
                continue;
            } else if (1 == num1Val) {
                interMap.remove(nums2[j]);
            }else {
                interMap.put(nums2[j],--num1Val);
            }
            outList.add(nums2[j]);
        }

        int[] result = new int[outList.size()];
        int k = 0;
        for(Integer val : outList){
            result[k] = val;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {


    }
}
