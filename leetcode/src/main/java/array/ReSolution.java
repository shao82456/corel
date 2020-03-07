package array;

import java.util.*;

public class ReSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (memo.containsKey(target - num)) {
                return new int[]{i, memo.get(target - num)};
            } else {
                memo.put(num, i);
            }
        }
        /*not found*/
        return null;
    }

    /*11. Container With Most Water
     利用双指针的方法，因为根据题目的性质，每次都可以通过移动左/右指针
     来剪纸*/
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(Math.min(height[l], height[r]) * (r - l), res);
            if (height[l] < height[r]) {
                //此时再以height[l]为左边界没有意义了
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    /*15. 3Sum*/
    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    /*26. Remove Duplicates from Sorted Array
     * 很简单，扫描一遍数组即可*/
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int last = nums[0];
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (last != nums[i]) {
                nums[++j] = nums[i];
                last = nums[i];
            }
        }
        return j + 1;
    }

    /*27. Remove Element
     * 比较简单，扫描一遍即可，关键在于移动元素*/
    public int removeElement(int[] nums, int val) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    /*30. Substring with Concatenation of All Words
     * 滑动窗口，且窗口大小固定*/
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        Map<String, Integer> data = new HashMap<>();
        for (String word : words) {
            data.put(word, data.getOrDefault(word, 0) + 1);
        }
        int n = words[0].length();
        int l = 0, r = -1;
        Queue<String> window = new LinkedList<>();
        while (r + n < s.length()) {
            String cur = s.substring(r + 1, r + 1 + n);
            int left = data.getOrDefault(cur, 0);
            if (left > 0) {
                window.offer(cur);
                data.put(cur, data.get(cur) - 1);
                r += n;
            } else {
                while (!window.isEmpty()) {
                    String last = window.poll();
                    data.put(last, data.get(last) + 1);
                }
                l += 1;
                r = l - 1;
            }
            if (window.size() == words.length) {
                res.add(l);
                while (!window.isEmpty()) {
                    String last = window.poll();
                    data.put(last, data.get(last) + 1);
                }
                l += 1;
                r = l - 1;
            }
        }
        return res;
    }

    /*32. Longest Valid Parentheses
    滑动窗口的方法，括号只有一种，当遇到左括号数>=右括号数时，窗口右边界向前滑动，
    当右括号大时，窗口清空并前移,
    看来这种思路不对*/
    public int longestValidParentheses(String s) {
        int ln = 0, rn = 0;
        int l = 0, r = -1;
        int res = 0;
        while (l < s.length()) {
            if (r + 1 == s.length()) {
                if (s.charAt(l++) == '(') {
                    ln -= 1;
                } else {
                    rn -= 1;
                }
            } else if (ln >= rn) {
                if (s.charAt(++r) == '(') {
                    ln += 1;
                } else {
                    rn += 1;
                }
            } else {
                l = r + 1;
                r = l - 1;
                ln = 0;
                rn = 0;
            }
            if (ln == rn) {
                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }

    /*33. Search in Rotated Sorted Array
     * 没有重复元素很关键*/
    public int search(int[] nums, int target) {
        return _search(nums, 0, nums.length - 1, target);
    }

    private int _search(int[] nums, int l, int r, int target) {
        if (l <= r) {
            int m = (l + r) / 2;
            if (target == nums[m]) {
                return m;
            }
            //这里<=是因为当搜索范围为2时，m=l
            if (nums[l] <= nums[m]) {
                //左半段有序
                if (target >= nums[l] && target < nums[m]) {
                    return _search(nums, l, m - 1, target);
                } else {
                    return _search(nums, m + 1, r, target);
                }
            } else {
                //右半段有序
                if (target > nums[m] && target <= nums[r]) {
                    return _search(nums, m + 1, r, target);
                } else {
                    return _search(nums, l, m - 1, target);
                }
            }
        }
        return -1;
    }

    private int bs(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int left=bsMost(nums,0,nums.length-1,true,target);
        if(left==-1){
            return new int[]{-1,-1};
        }
        int right=bsMost(nums,0,nums.length-1,false,target);
        return new int[]{left,right};
    }

    public int bsMost(int[] nums,int l,int r,boolean left,int target){
        int last=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(target<nums[m]){
                r=m-1;
            }else if(target>nums[m]){
                l=m+1;
            }else{
                last=m;
                if(left){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }
        }
        return last;
    }

    /*35. Search Insert Position
    * 二分搜索的思路，寻找目标数，
    * 如果没有，寻找最接近的左值*/
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]<target){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return l;
    }
}
