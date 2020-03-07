package string1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution sol=new Solution();
    @Test
    public void multiply() {
        System.out.println(sol.multiply("78788","7"));
    }

    @Test
    public void lengthOfLongestSubstring() {
        String input="pwwkew";
        System.out.println(sol.lengthOfLongestSubstring(input));
    }

    @Test
    public void myAtoiII() {
        String s="-";
        System.out.println(sol.myAtoiII(s));
    }

    @Test
    public void intToRoman() {
        int num=1993;
        System.out.println(sol.intToRoman(num));
    }

    @Test
    public void romanToInt() {
        String roman="III";
        System.out.println(sol.romanToInt(roman));
    }

    @Test
    public void longestCommonPrefix() {
        String[] strs=new String[]{"c","c"};
        System.out.println(sol.longestCommonPrefix(strs));
    }
}