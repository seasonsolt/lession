package leetcode;

import java.util.*;

public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> out = new LinkedList<String>();
        Map<String, Integer> indexMap = new HashMap<String, Integer>();
        for (int i = 0; i<list1.length; i++) {
            indexMap.put(list1[i], i);
        }
        Integer sum = list1.length + list2.length - 2;
        for (int i = 0; i<list2.length; i++) {
            Integer tmp = indexMap.put(list2[i], 1);
            if (tmp != null) {
                if(sum == (i + tmp)){
                    out.add(list2[i]);
                    continue;
                }
                if((i + tmp) < sum){
                    sum = i + tmp;
                    out.clear();
                    out.add(list2[i]);
                    continue;
                }
            }
        }

        return out.toArray(new String[out.size()]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Shogun","Burger King"};

        MinimumIndexSumofTwoLists test = new MinimumIndexSumofTwoLists();
        String[] result = test.findRestaurant(list1, list2);
        System.out.println(result);

    }

}
