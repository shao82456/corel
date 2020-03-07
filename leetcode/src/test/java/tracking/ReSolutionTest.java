package tracking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReSolutionTest {
    ReSolution sol=new ReSolution();
    @Test
    public void letterCombinations() {
        String digits="";
        List<String> res = sol.letterCombinations(digits);
        System.out.println(res.size());
    }

    @Test
    public void generateParenthesis() {
        int n=1;
        System.out.println(sol.generateParenthesis(n));
    }
}