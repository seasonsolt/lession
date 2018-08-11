package leetcode;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.util.HashSet;
import java.util.Set;

class MyHashSet {

    private int[] table;


    public MyHashSet() {
        table = new int[10000];
    }

    public void add(int key) {
        table[hash(key)] = key;
    }

    public void remove(int key) {
        table[hash(key)] = 0;
    }

    public boolean contains(int key) {
        if(0 != table[hash(key)] && 0 != table[hash(key)]){
            return true;
        }else{
            return false;
        }
    }

    public int hash(int key){
        return key%10000;
    }

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> hashset = new HashSet<Integer>();
            for(int i:nums){
                hashset.add(i);
            }
            if(hashset.size() < nums.length){
                return true;
            }
            return false;

        }
    }

}



/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



class testMyHashSet {
    public static void main(String[] args){
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.remove(2);
        boolean ifContains2 = hashSet.contains(2);
        boolean ifContains3 = hashSet.contains(3);
        System.out.println(ifContains2);
        System.out.println(ifContains3);

    }

}

