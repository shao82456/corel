package review1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Author: shaoff
 * Date: 2020/3/18 13:00
 * Package: review1
 * Description:
 */
public class SolutionTest {
    Solution sol=new Solution();
    @Test
    public void twoSum1() {
        int[] res=sol.twoSum1(new int[]{1,2,2,4},4);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void addTwoNumbers() {
        ListNode l1=ListNode.fromArray(new int[]{2,4,6});
        ListNode l2=ListNode.fromArray(new int[]{5,6,4});
        ListNode l3=sol.addTwoNumbers(l1,l2);
        System.out.println(ListNode.mkString(l3));
    }

    @Test
    public void lengthOfLongestSubstring() {
        String input="abcabcbb";
        System.out.println(sol.lengthOfLongestSubstring(input));

    }

    @Test
    public void longestPalindrome() {
        String input="abcba";
        System.out.println(sol.longestPalindrome(input));
    }

    @Test
    public void myAtoi() {
        String str="   -42";
        System.out.println(sol.myAtoi(str));
    }

    @Test
    public void longestCommonPrefix2() {
        String[] input={"dog","racecar","car"};
        System.out.println(sol.longestCommonPrefix2(input));
    }

    @Test
    public void threeSum() {
        int[] nums={-1, 0, 1, 2, -1, -4};
        System.out.println(sol.threeSum2(nums));
    }
}