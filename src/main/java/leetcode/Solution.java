package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] sChar = s.toCharArray();
        int[] result = new int[2];
        int len = s.length();
        boolean[] exists = new boolean[256];
        int i = 0, j = 0, ans = 0;
        while (i < len && j < len) {
            if (!exists[(int) sChar[j]]) {
                exists[sChar[j]] = true;
                j++;
                ans = ans > j - i ? ans : j - i;
            } else {
                exists[(int) sChar[i]] = false;
                i++;
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        char[] sChar = s.toCharArray();
        HashSet<Integer> exists = new HashSet<Integer>();

        int[] result = new int[2];
        int len = s.length();

        int i = 0, currLen = 0, longest = 0;
        while (i < len && currLen < len) {
            exists.add((int)sChar[i]);
            currLen++;
            if(exists.size() < currLen){
                //发生重复数字
                longest = longest > exists.size() ? longest:exists.size();
                currLen = 0;
                exists = new HashSet<Integer>();
            }else{
                i++;
            }
        }

        return longest;
    }

}
