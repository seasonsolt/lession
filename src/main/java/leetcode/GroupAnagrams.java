package leetcode;

import java.nio.charset.Charset;
import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, Integer> containsMap = new HashMap<String, Integer>();
        Integer listCount = 0;
        for(int i = 0; i < strs.length; i ++){
            char[] sortedStr = strs[i].toCharArray();
            Arrays.sort(sortedStr);
            Integer preVal = containsMap.get(new String(sortedStr));
            if( null == preVal ){
                List<String> list = new LinkedList<String>();
                list.add(strs[i]);
                result.add(list);
                containsMap.put(new String(sortedStr), ++listCount);
            }else {
                result.get(preVal - 1).add(strs[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();

//        String[] strs1 = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        String[] strs2 = {"eat","tea","tan","ate","nat","bat"};
//        List<List<String>> result1 =  test.groupAnagrams(strs1);
        List<List<String>> result2 =  test.groupAnagrams(strs2);
//        System.out.println(result1);
        System.out.println(result2);
    }
}
