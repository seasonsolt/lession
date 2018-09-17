package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 * <p>
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * <p>
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * <p>
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * <p>
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * <p>
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * <p>
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * <p>
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class RandomizedSet {
    Set<Integer> set;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        set = new HashSet<Integer>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
       return set.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        return  set.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Iterator<Integer> it = set.iterator();
        it.next();
        Integer[] arr = new Integer[set.size()];
        set.toArray(arr);
        return arr[(int)(Math.random() * set.size())];

    }

    public static void main(String[] args) {
        RandomizedSet test = new RandomizedSet();
        test.insert(3);
        test.insert(1);
        test.insert(2);
        test.insert(4);
        test.insert(5);

        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());

    }

}
