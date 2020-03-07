package array;

import org.junit.Test;

import java.util.Arrays;

public class ReSolutionTest {
    ReSolution sol = new ReSolution();

    @Test
    public void maxArea() {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(sol.maxArea(arr));
    }

    @Test
    public void twoSum() {
        int[] arr = new int[]{1, 3, 1, 1};
        System.out.println(Arrays.toString(sol.twoSum(arr, 2)));
    }

    @Test
    public void removeDuplicates() {
        int[] arr = new int[]{1, 1, 2};
        System.out.println(sol.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void removeElement() {
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(sol.removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void findSubstring() {
        String s = "aaaaaa";
        String[] words = new String[]{"aa", "aa"};
        System.out.println(sol.findSubstring(s, words));
    }

    @Test
    public void longestValidParentheses() {
        String input = "()(()";
        System.out.println(sol.longestValidParentheses(input));

    }

    @Test
    public void search() {
        int[] nums = new int[]{3, 1};
        System.out.println(sol.search(nums, 1));
    }

    @Test
    public void bsMost() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(sol.bsMost(nums, 0, nums.length - 1, false, 8));
    }

    @Test
    public void searchRange() {
        int target = 1;
        int[] nums = new int[]{1,2};
        int[] res = sol.searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void searchInsert() {
        int[] nums=new int[]{1,3,5,6};
        System.out.println(sol.searchInsert(nums,7));
    }
}