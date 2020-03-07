package tracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    Solution sol = new Solution();

    @Test
    public void generateParenthesis() {
        int n = 3;
        List<String> res = sol.generateParenthesisII(n);
        System.out.println(res);
    }


    @Test
    public void check() {
        String str = "(((((";
        System.out.println(sol.check(str.toCharArray()));
    }

    @Test
    public void permutation() {
        int input = 9;
        List<String> res = sol.permutation(input);
//        Collections.sort(res);
        System.out.println(res);
    }

    @Test
    public void permutationII() {
        int input = 4;
        List<String> res = sol.permutationII(input);
//        Collections.sort(res);
        System.out.println(res);
    }

    @Test
    public void isMatch() {
        String input = "aab";
        String p = "c*a*b";
        System.out.println(sol.isMatchII(input, p));
    }

    @Test
    public void solveSudoku() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sol.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    @Test
    public void isMatch44() {
        String s = "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb";
        String p = "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a";
        System.out.println(sol.isMatch44(s, p));
    }

    @Test
    public void solveNQueens() {
        int input = 4;
        List<List<String>> res = sol.solveNQueens(input);
        for (List<String> solution : res) {
            System.out.println("solution");
            for (String line : solution)
                System.out.println(line);
        }
    }

    @Test
    public void jiecheng() {
        int res = 4;
        char c = (char) (res + 48);
        System.out.println(c);
    }

    @Test
    public void getPermutation() {
        String res = sol.getPermutation(4, 23);
        System.out.println(res);
    }

    @Test
    public void getUnknownNeighbor() {
        int node = 0;
        for (int i = 0; i < 3; i++) {
            int neighbor = node ^ (1 << i);
            System.out.println(Integer.toBinaryString(neighbor));
        }
    }

    @Test
    public void grayCode() {
        int n = 0;
        List<Integer> res = sol.grayCode(n);
        System.out.println(res);
    }

    @Test
    public void subsetsWithDup() {
        List<List<Integer>> res = sol.subsetsWithDup(new int[]{});
        System.out.println(res);
    }

    @Test
    public void combine() {
        int n = 4;
        int k = 2;
        List<List<Integer>> res = sol.combine(n, k);
        System.out.println(res);
    }

    @Test
    public void isAdditiveNumber() {
        String input1="101";
        boolean res=sol.isAdditiveNumber(input1);
        assertEquals(true,res);
    }

    @Test
    public void isAdditiveStr() {
        String num1="10";
        String num2="10";
        String str="20305080130210";
        boolean res=sol.isAdditiveStr(num1,num2,str);
        assertEquals(true,res);
    }

    @Test
    public void addStr() {
        String s1="0";
        String s2="0";
        assertEquals("0",sol.addStr(s1,s2));
    }

    @Test
    public void combinationSum3() {
        List<List<Integer>> res = sol.combinationSum3(2, 18);
        System.out.println(res);
    }

    @Test
    public void countNumbersWithUniqueDigits() {
        int input1=2;
        assertEquals(8877691,sol.countNumbersWithUniqueDigits(input1));
//        assertEquals(91,sol.countNumbersWithUniqueDigits(input1));
        int input=3;
        int res=sol.countNumbersWithUniqueDigits(input);
        assertEquals(739,res);
    }

    @Test
    public void readBinaryWatch() {
    }

    @Test
    public void readWatch() {
        List<String> res=sol.readBinaryWatch(2);
        Collections.sort(res);
        System.out.println(res);
    }

    @Test
    public void letterCasePermutation() {
        String input1="";
        String input2="a";
        String input3="Ab12c";
        assertEquals(Arrays.asList(""),sol.letterCasePermutation(input1));
        assertEquals(Arrays.asList("a","A"),sol.letterCasePermutation(input2));
        List<String> expectRes3=Arrays.asList("Ab12c","ab12c","AB12c","AB12C","aB12c","aB12C","Ab12C","ab12C");
        List<String> res3=sol.letterCasePermutation(input3);
        Collections.sort(expectRes3);
        Collections.sort(res3);

        assertEquals(expectRes3,res3);
    }

    @Test
    public void countArrangement() {
        int intpu1=2;
        assertEquals(2,sol.countArrangement(intpu1));
    }

    @Test
    public void canUse() {
        System.out.println(sol.canUse(2,1));
        System.out.println(sol.canUse(1,2));
    }

    @Test
    public void isFibonacci() {
        String s1="110";
        String s2="1";
        String left="111";
        System.out.println(sol.isFibonacci(s1,s2,left));
    }

    @Test
    public void splitIntoFibonacci() {
        String input1 = "214748364721474836422147483641";
        System.out.println(sol.splitIntoFibonacci(input1));
    }

    public void numTilePossibilities() {
        String input1="AAB";
        System.out.println(sol.numTilePossibilities(input1));
    }

    @Test
    public void numTilePossibilities1() {
        int[] times=new int[26];
        times[0]=2;
        times[1]=1;
        System.out.println(sol.numTilePossibilities(1,times));
    }

    @Test
    public void maxUncrossedLines() {
        int[] A=new int[] {15,14,1,7,15,1,12,18,9,15,1,20,18,15,16,18,11,8,11,18,11,11,17,20,16,20,15,15,9,18,16,4,16,1,13,10,10,20,4,18,17,3,8,1,8,19,14,10,10,12};
int[] B=new int[] {12,8,17,4,2,18,16,10,11,12,7,1,8,16,4,14,12,18,18,19,19,1,11,18,1,6,12,17,6,19,10,5,11,16,6,17,12,1,9,3,19,2,18,18,2,4,11,11,14,9,20,19,2,20,9,15,8,7,8,6,19,12,4,11,18,18,1,6,9,17,13,19,5,4,14,9,11,15,2,5,4,1,10,11,6,4,9,7,11,7,3,8,11,12,4,19,12,17,14,18};
        System.out.println(sol.maxUncrossedLines(A,B));
    }

    @Test
    public void maxUncrossedLinesII() {
        int[] A=new int[]{1,1,2,1,2};
        int[] B=new int[]{1,3,2,3,1};
        System.out.println(sol.maxUncrossedLines(A,B));
    }

    @Test
    public void wordBreak() {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple","pen","rs");
        System.out.println(sol.wordBreak(s,wordDict));
    }

    @Test
    public void testIsMatch() {
        String s="abc";
        String p="abcd";
        System.out.println(sol.isMatch(s,p));
    }
}