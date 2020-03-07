package hash1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution sol=new Solution();
    @Test
    public void longestConsecutive() {
        int[] arr={100, 4, 200, 1, 3, 2};
        System.out.println(sol.longestConsecutive(arr));
    }
}