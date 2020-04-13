package review1;

import java.util.*;

/**
 * Author: shaoff
 * Date: 2020/3/18 12:42
 * Package: review1
 * Description:复习一边之前刷的题
 */
public class Solution {
    /**
     * 1. Two Sum
     * 寻找整数数组中，两个数之后是目标数的索引
     * 可以假设只有一个解
     * 每个数只能用一次
     * <p>
     * 思路：
     * 利用tar-num1从hash中查找目标数
     * 基本方案：
     * 遍历一遍数组，将其所有数记录在hash中，以值为key,以索引为value
     * 第二次遍历时，寻找每个值对应的target-current是否存在，如果存在且不是自身，返回
     * 通过比较索引确保不是自身
     * <p>
     * 优化方案：
     * 只遍历一遍数组，假设target=num1+num2,即使遍历num1时num2还未遍历到，此时hash中没有num2，那也可以在遍历到num2时
     * 找到对应的num1，此时num1已存在，为了解决不使用自身两次，可以先查找target-current,再将current放入hash中
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            memo.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int num2 = memo.getOrDefault(target - num, -1);
            if (num2 != -1 && num2 != i) {
                return new int[]{i, memo.get(target - num)};
            }
        }
        //not found
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (memo.containsKey(target - num)) {
                return new int[]{i, memo.get(target - num)};
            }
            memo.put(num, i);
        }
        /*not found*/
        return null;
    }

    /*2. Add Two Numbers
    * 链表加法
    * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
* 个位在表头，高位在表尾
*
* 普通的数学的加法就是从个位依次相加，逐个加到高位，其中保留进位信息
* 思路也是这样,从两个链表头开始遍历，知道两个链表都为空为止*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        ListNode resDh = new ListNode(-1);
        ListNode cur3 = resDh;
        int spill = 0;
        while (cur1 != null || cur2 != null) {
            int val = spill;
            if (cur1 != null) {
                val += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                val += cur2.val;
                cur2 = cur2.next;
            }
            spill = val / 10;
            cur3.next = new ListNode(val % 10);
            cur3 = cur3.next;
        }
        //两个表一样长，且发生了进位
        if (spill != 0) {
            cur3.next = new ListNode(spill);
        }
        return resDh.next;
    }

    /**
     * 3. Longest Substring Without Repeating Characters
     * 最长无重复子串
     * 思路：一般遇到连续的子串问题应考虑滑动窗口
     * 这里用一个集合来存当前窗口内有的元素，每次窗口增长时记录窗口长度，
     * 当元素在窗口内重复时，窗口出一个元素，直到将其移出
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = -1;
        int res = 0;
        while (r + 1 < s.length()) {
            if (set.contains(s.charAt(r + 1))) {
                set.remove(s.charAt(l++));
            } else {
                set.add(s.charAt(++r));
                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }

    /**
     * 4. Median of Two Sorted Arrays
     * 两个有序数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return -1;
    }

    /*5. Longest Palindromic Substring
     * 最长回文子串
     * 思路：
     * 1.直观地方式
     * a.遍历所有子串,这一步需要o[n*(n-1)/2]
     * b.对每个子串，判断其是否是回文串，这一步是o(n)复杂度，整体复杂度O(n^3)
     * 2.动态规划
     * 递推式如下
     * f(i,j)表示子串s[i,j]是否是回文子串
     * f(i,j)=T (i==j)
     * f(i,j)=T (j=i+1)
     * f(i,j)= s[i]==s[j]&&f(i+1,j-1)
     */
    public String longestPalindrome(String s) {
        if ((s.length() == 0)) {
            return "";
        }
        boolean[][] memo = new boolean[s.length()][s.length()];
        String res = s.charAt(0) + "";
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            memo[i][i] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            int j = i + 1;
            if ((j < s.length())) {
                memo[i][j] = s.charAt(i) == s.charAt(j);
                if (memo[i][j] && maxLen < (j - i + 1)) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                memo[i][j] = s.charAt(i) == s.charAt(j) && memo[i + 1][j - 1];
                if (memo[i][j] && maxLen < (j - i + 1)) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /*7. Reverse Integer
     * 数学运算题目，关键是避免溢出*/
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }

    /**
     * 8. String to Integer (atoi)
     *
     * @param str
     * @return 按照第7题的思路来处理
     */
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char first = str.charAt(0);
        boolean neg = first == '-';
        if ((!neg) && ((first - '0' < 0) || (first - '0' > 9))) {
            return 0;
        }
        int firstIdx = neg ? 1 : 0;
        int res = 0;
        for (int i=firstIdx;i<str.length();i++) {
            int num = str.charAt(i) - '0';
            if (num >= 0 && num <= 9) {
                if (neg) {
                    if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && num > 8)) {
                        return Integer.MIN_VALUE;
                    } else {
                        res = res * 10 - num;
                    }
                } else {
                    if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > 7)) {
                        return Integer.MAX_VALUE;
                    } else {
                        res = res * 10 + num;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 14. Longest Common Prefix
     * 最长公共前缀
     * 思路
     * 1从一个的字符串的首个字符开始，遍历剩下的所有的字符串，比较首个字符是否一致，
     * 如果一致，继续判断下一个字符。直到其中某个字符串为空或是字符不等为止
     * 时间复杂度o(m*n) m为最短字符串的长度，n是字符串个数
     *
     * 2.分治法,将数组分成两份，分别得出两个最长的公共前缀，这两个前缀的最长公共前缀就是
     * 整个数组的最长公共前缀
     * 时间复杂度递推式T(n)=2T(n/2)+O(m) m是最短的字符串的长度，在最坏情况下，所有字符串的长度都是m
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i==strs[j].length()||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length==0){
            return "";
        }
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i==strs[j].length()||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    private String _longestCommonPrefix2(String[] strs,int l,int r){
        if(l==r){
            return strs[l];
        }
        int mid=(l+r)/2;
        String left=_longestCommonPrefix2(strs,l,mid);
        String right=_longestCommonPrefix2(strs,mid+1,r);
        return _longestCommonPrefix2(left,right);
    }

    private String _longestCommonPrefix2(String a,String b){
        for(int i=0;i<a.length();i++) {
            char c=a.charAt(i);
            if(i==b.length()||b.charAt(i)!=c){
                return a.substring(0,i);
            }
        }
        return a;
    }

    /**
     * 15. 3Sum
     * 思路：
     * 1.直观方式，遍历所有组合，找出符合的三元组，但是还需要去重，去除元素一样的三元组
     * ，目前还没有好的去重方式
     * 2.固定第一个数，然后twoSum的方式
     * 时间复杂度O(n^3)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        Integer[] distinctedNums=set.toArray(new Integer[0]);
        System.out.println(Arrays.toString(distinctedNums));
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<distinctedNums.length;i++){
            for(int j=i+1;j<distinctedNums.length;j++){
                for(int k=j+1;k<distinctedNums.length;k++){
                    if ((distinctedNums[i]+distinctedNums[j]+distinctedNums[k])==0) {
                        List<Integer> tuple=new ArrayList<>();
                        tuple.add(distinctedNums[i]);
                        tuple.add(distinctedNums[j]);
                        tuple.add(distinctedNums[k]);
                        res.add(tuple);
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        for(int first=0;first<nums.length-2;first++){
            int target=-1*nums[first];
            for(List<Integer> two:twoSum2(nums,first+1,nums.length-1,target)){
                two.add(nums[first]);
                res.add(two);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum2(int[] nums,int l,int r, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = l; i<=r; i++) {
            int num = nums[i];
            if (memo.containsKey(target - num)) {
                List<Integer> tuple=new ArrayList<>();
                tuple.add(nums[i]);
                tuple.add(nums[memo.get(target - num)]);
                res.add(tuple);
            }
            memo.put(num, i);
        }
        /*not found*/
        return res;
    }
}
