package stack1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution sol=new Solution();
    @Test
    public void isValid() {
        String str="()";
        System.out.println(sol.isValid(str));
    }
}