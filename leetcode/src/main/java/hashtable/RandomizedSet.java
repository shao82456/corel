package hashtable;

import javax.print.attribute.standard.PresentationDirection;
import java.util.*;

public class RandomizedSet {

   /* public static void main(String[] args) {
        RandomizedSet rset=new RandomizedSet();
        rset.insert(1);
        rset.insert(2);
        rset.insert(3);
        System.out.println(rset.remove(1));
        System.out.println(rset.remove(3));
        System.out.println(rset.getRandom());
    }*/
    Map<Integer,Integer> map=new HashMap<>();
    List<Integer> arr=new ArrayList<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean exists=map.containsKey(val);
        if(!exists) {
            arr.add(val);
            map.put(val, arr.size() - 1);
        }
        return !exists;
    }


    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean exists=map.containsKey(val);
        if(exists){
            int idx=map.get(val);
            int lastVal=arr.get(arr.size()-1);
            arr.set(idx,lastVal);
            map.put(lastVal,idx);
            arr.remove(arr.size()-1);
            map.remove(val);
        }
        return exists;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int rand=(int) (arr.size()*Math.random());
        return arr.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */