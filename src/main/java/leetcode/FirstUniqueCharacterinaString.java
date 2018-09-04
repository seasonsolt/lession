package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        Map<String, Integer> uniqMap = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Integer val = uniqMap.get(String.valueOf(s.charAt(i)));
            if(null == val){
                uniqMap.put(String.valueOf(s.charAt(i)), 1);
            }else{
                uniqMap.put(String.valueOf(s.charAt(i)), ++val);
            }
        }
        for(Map.Entry<String, Integer> entry: uniqMap.entrySet()){
            if(entry.getValue() == 1){
               return s.indexOf(entry.getKey());
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        FirstUniqueCharacterinaString test = new FirstUniqueCharacterinaString();
        int result =  test.firstUniqChar("loveleetcode");
    }
}
