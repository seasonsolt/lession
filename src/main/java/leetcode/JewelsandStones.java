package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {

        Map<String, Integer> jeweMap = new HashMap<String, Integer>();
        for(int i = 0; i < J.length(); i++){
           jeweMap.put(String.valueOf(J.charAt(i)), 0);
        }
        for(int j = 0; j < S.length(); j++){
            String tmp = String.valueOf(S.charAt(j));
            Integer cnt = jeweMap.get(tmp);
            if(null != cnt){
                jeweMap.put(tmp, ++cnt);
            }
        }

        Integer result = 0;
        for(Integer cnt : jeweMap.values()){
           result += cnt;
        }


        return result;
    }

    public static void main(String[] args){
       JewelsandStones test = new JewelsandStones();
       System.out.println(test.numJewelsInStones("aA", "aAAbbbb"));
    }
}
