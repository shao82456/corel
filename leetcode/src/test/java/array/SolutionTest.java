package array;

import array.Solution.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    Solution sol = new Solution();
    TestCaseGenerater tcg = new TestCaseGenerater();


    @Test
    public void findMin() {
        long begin = System.currentTimeMillis();
        for (int j = 0; j < 1000; j++) {
            List<List<Integer>> data = tcg.getRotatedArrays();
            for (List<Integer> nums : data) {
                int[] a = new int[nums.size()];
                for (int i = 0; i < a.length; i++)
                    a[i] = nums.get(i);
                sol.findMin(a);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - begin) / 1000.0);
    }

    @Test
    public void longestPalindrome() {
        String str = "cbbd";
        String res = sol.longestPalindrome(str);

        System.out.println(res);
    }

    public void merge() {
        List<Interval> in = new ArrayList<>();
        in.add(new Interval(2, 3));
        in.add(new Interval(2, 2));
        in.add(new Interval(3, 3));
        in.add(new Interval(1, 3));
        in.add(new Interval(5, 7));
        in.add(new Interval(2, 2));
        in.add(new Interval(4, 6));

        List<Interval> res = sol.merge(in);
        for (Interval interval : in) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    @Test
    public void spiralOrder() {
        int[][] map = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {8, 9, 10, 11}};
        System.out.println(sol.spiralOrder(map));
    }

    @Test
    public void convert() {
        String input1 = "PAYPALISHIRING";
        String res1 = sol.convert(input1, 3);
        String res2 = sol.convert(input1, 4);
        assertEquals("PAHNAPLSIIGYIR", res1);
        assertEquals("PINALSIGYAHRPI", res2);
    }

    @Test
    public void twoSum() {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] res = sol.twoSum(arr, target);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void addTwoNumbers() {
        ListNode l1 = ListNode.mkList(new int[]{1});
        ListNode l2 = ListNode.mkList(new int[]{5, 6, 4});
        assertEquals("6->6->4", sol.addTwoNumbers(l1, l2).toString());
    }

    @Test
    public void countOfAtoms() {
        String formula = "K4(ON(SO3)2)2";
        System.out.println(sol.countOfAtoms(formula));
    }

    @Test
    public void trap() {
        int[] input = new int[]{};
        int res = sol.trap1(input);
        System.out.println(res);
    }

    @Test
    public void isValidSudoku() {
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(sol.isValidSudoku(board));
    }

    @Test
    public void partition() {
        int[] arr = {6, 6, 6, 7, 7};
        System.out.println(sol.partition(arr, 0, 4));
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void majorityElement() {
        int[] nums = new int[]{6, 6, 6, 7, 7};
        System.out.println(sol.majorityElement(nums));
    }

    @Test
    public void majorityElementII() {
        int[] nums = new int[]{3};
        System.out.println(sol.majorityElementII(nums));
    }

    @Test
    public void productExceptSelf() {
        int[] nums = new int[]{0, 0};
        System.out.println(Arrays.toString(sol.productExceptSelf(nums)));
    }

    @Test
    public void gameOfLife() {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        sol.gameOfLife(board);
        System.out.printf(Arrays.deepToString(board));
    }

    @Test
    public void findDisappearedNumbers() {
        int[] arr=new int[]{2,3,0};
        System.out.println(sol.findDisappearedNumbers(arr));
    }

    @Test
    public void thirdMax() {
        int[] arr=new int[]{2,2,3,1};
        System.out.println(sol.thirdMax(arr));
    }

    @Test
    public void findDuplicates() {
        int[] arr=new int[]{4,3,2,7,8,2,3,1};
        System.out.println(sol.findDuplicates(arr));
    }

    @Test
    public void findPoisonedDuration() {
        int[] arr=new int[]{1,3};
        System.out.println(sol.findPoisonedDuration(arr,2));
    }

    @Test
    public void subarraySum() {
        int[] nums = {-1,4,3,3};
        int k=6;
        System.out.println(sol.subarraySumIII(nums,k));
    }

    @Test
    public void arrayPairSum() {
        int[] arr=new int[]{3,1,7,8,9,6};
        System.out.println(sol.arrayPairSum(arr));
    }

    @Test
    public void arrayNesting() {
        int[] arr=new int[]{0};
        System.out.println(sol.arrayNesting(arr));
    }

    @Test
    public void matrixReshape() {
        int[][] nums=new int[][]{{1,2},{3,4}};
        String resStr=Arrays.deepToString(sol.matrixReshape(nums,2,4));
        System.out.println(resStr);
    }

    @Test
    public void findUnsortedSubarray() {
        int[] arr1=new int[]{1,2,3};
        int[] arr2=new int[] {1};
        int[] arr3=new int[] {3,2,1};
        int[] arr4=new int[] {1,2,4,3};
        assertEquals(0,sol.findUnsortedSubarray(arr1));
        assertEquals(0,sol.findUnsortedSubarray(arr2));
        assertEquals(3,sol.findUnsortedSubarray(arr3));
        assertEquals(2,sol.findUnsortedSubarray(arr4));
    }

    @Test
    public void triangleNumber() {
        int[] arr=new int[]{2,2,3,4};
        System.out.println(sol.triangleNumber(arr));
    }

    @Test
    public void maximumProduct() {
        int[] arr=new int[]{-1,-2,-100,4};
        System.out.println(sol.maximumProduct(arr));
    }

    @Test
    public void findMaxAverage() {
        int[] arr=new int[]{1,12,-5,-6,50,3};
        System.out.println(sol.findMaxAverage(arr,4));
    }

    @Test
    public void imageSmoother() {
        int[][] data=new int[][]{
                {2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        System.out.println(Arrays.deepToString(sol.imageSmoother(data)));
        System.out.println(Arrays.deepToString(data));
    }

    @Test
    public void checkPossibility() {
        int[] arr=new int[]{4};
        System.out.println(sol.checkPossibilityII(arr));
    }

    @Test
    public void maximumSwap() {
        System.out.println(sol.maximumSwap(98368));
    }

    @Test
    public void findLengthOfLCIS() {
        int[] nums=new int[]{1,3,5,4,7};
        System.out.println(sol.findLengthOfLCIS(nums));
    }

    @Test
    public void findShortestSubArray() {
        int[] nums=new int[]{1,2,4,5,1};
        System.out.println(sol.findShortestSubArray(nums));
    }
}