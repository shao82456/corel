package hash1;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hset=new HashSet<>();
        for(int num:nums){
            hset.add(num);
        }
        int res=-1;
        for(int num:nums){
            if(!hset.contains(num-1)){
                int cur=1,tmpNum=num;
                while (hset.contains(tmpNum+1)){
                    cur+=1;
                    tmpNum+=1;
                }
                res=Math.max(res,cur);
            }
        }
        return res;
    }

}
