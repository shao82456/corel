package tracking;

import java.util.*;

public class ReSolution {
    /*10. Regular Expression Matching
     递归思路,当p为空时为递归结束，s为空不能作为递归结束条件，例如s="",p="a*"
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        /*if p(1)!='*'  return p(0)==s(0)&&isMatch(s[1:],p[1:])
         * else  s尝试匹配一个p(0)||结束匹配p(0)*/
        boolean firstMatch = (s.length() > 0) && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
        if (p.length() > 1 && p.charAt(1) == '*') {
            return (firstMatch && isMatch(s.substring(1), p) || isMatch(s, p.substring(2)));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /*17. Letter Combinations of a Phone Number*/
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        letterCombinations(digits, 0, "", res, map);
        return res;
    }

    private void letterCombinations(String digits, int i, String cur, List<String> all, Map<Character, List<String>> map) {
        if (i == digits.length()) {
            all.add(cur);
            return;
        }
        for (String s : map.get(digits.charAt(i))) {
            letterCombinations(digits, i + 1, cur + s, all, map);
        }
    }

    /*22. Generate Parentheses
     * 利用回溯+剪枝的思路，
     * 由于只有一种括号，当右括号比左括号多时，直接剪掉
     * 当左括号比右括号多时，继续添加左括号或右括号都可以
     * 当左括号用完时，只添加右括号*/
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        _generateParenthesis(n*2, 0, 0, "", res);
        return res;
    }

    private void _generateParenthesis(int n, int ln, int rn, String cur, List<String> all) {
        if (rn > ln) {
            return;
        }
        if (ln + rn == n) {
            all.add(cur);
            return;
        }
        if (ln * 2 < n) {
            _generateParenthesis(n, ln + 1, rn, cur + "(", all);
            _generateParenthesis(n, ln, rn + 1, cur + ")", all);
        } else {
            _generateParenthesis(n, ln, rn + 1, cur + ")", all);
        }
    }
}