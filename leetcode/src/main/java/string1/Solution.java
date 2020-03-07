package string1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int k = i + j + 1;// (i+num2.length())-(num2.length()-1-j);
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[k];
                res[k] = tmp % 10;
                res[k - 1] += tmp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        while (i < res.length) {
            sb.append(res[i++]);
        }
        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }

    /*72. Edit Distance
     * word1长度少时，替换，插入
     * word2长度少时，替换
     * 否则，替换
     * 最后删除*/
    public int minDistance(String word1, String word2) {
        return -1;
    }

    /*3. Longest Substring Without Repeating Characters
     * 使用滑动窗口+hash表的方式，由于样本范围不大，空间复杂度O(1)*/
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = -1;
        Set<Character> set = new HashSet<>();
        int res = 0;
        while (r + 1 < s.length()) {
            if (set.contains(s.charAt(r + 1))) {
                set.clear();
                l = r = r + 1;
                set.add(s.charAt(r));
            } else {
                set.add(s.charAt(r + 1));
                r++;
                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }

    public int myAtoi(String str) {
        int res = 0;
        boolean negative = false;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        int limit = -Integer.MAX_VALUE;
        int multmin;
        if (i < str.length()) {
            if (str.charAt(i) < '0') {
                if (str.charAt(i) == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (str.charAt(i) != '+') return 0;
                if (i == str.length() - 1) return 0;
                i++;
            }
            multmin = limit / 10;
            while (i < str.length()) {
                int digit = Character.digit(str.charAt(i++), 10);
                if (digit < 0) break;
                if (res < multmin) return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                res *= 10;
                if (res < limit + digit) return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                res -= digit;
            }
        }
        return negative ? res : -res;
    }

    public int myAtoiII(String str) {
        int res = 0;
        boolean neg = str.charAt(0) == '-';
        for (int i = neg ? 1 : 0; i < str.length(); i++) {
            int poped = neg ? -(str.charAt(i) - '0') : (str.charAt(i) - '0');
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && poped > 7)) {
                throw new IllegalArgumentException("integer overflow");
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && poped < -8)) {
                throw new IllegalArgumentException("integer overflow");
            }
            res = res * 10 + poped;
        }
        return res;
    }

    /*12. Integer to Roman
     将千，百，十，个 对号入座即可*/
    public String intToRoman(int num) {
        Map<Integer, String> data = new HashMap<>();
        data.put(0, "");
        data.put(1, "I");
        data.put(2, "II");
        data.put(3, "III");
        data.put(4, "IV");
        data.put(5, "V");
        data.put(6, "VI");
        data.put(7, "VII");
        data.put(8, "VIII");
        data.put(9, "IX");
        data.put(10, "X");
        data.put(20, "XX");
        data.put(30, "XXX");
        data.put(40, "XL");
        data.put(50, "L");
        data.put(60, "LX");
        data.put(70, "LXX");
        data.put(80, "LXXX");
        data.put(90, "XC");
        data.put(100, "C");
        data.put(200, "CC");
        data.put(300, "CCC");
        data.put(400, "CD");
        data.put(500, "D");
        data.put(600, "DC");
        data.put(700, "DCC");
        data.put(800, "DCCC");
        data.put(900, "CM");
        data.put(1000, "M");
        data.put(2000, "MM");
        data.put(3000, "MMM");
        int g = num % 10;
        num /= 10;
        int s = (num % 10) * 10;
        num /= 10;
        int b = (num % 10) * 100;
        num /= 10;
        int q = (num % 10) * 1000;
        return data.get(q) + data.get(b) + data.get(s) + data.get(g);
    }

    /*13. Roman to Integer
     * 十进制中的一位由1-2个字母表示，按照一定的策略进行转换即可*/
    public int romanToInt(String s) {
        int res = 0;
        int[] map = new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
        for (int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            if (c == 'I' && (i + 1) < s.length()&&
                    (s.charAt(i+1)=='V'||s.charAt(i+1)=='X')) {
                res-=1;i++;
            }
            if (c == 'X' && (i + 1) < s.length()&&
                    (s.charAt(i+1)=='L'||s.charAt(i+1)=='C')) {
                    res -= 10;i++;
            }
            if (c == 'C' && (i + 1) < s.length()&&
                    (s.charAt(i+1)=='D'||s.charAt(i+1)=='M')){
                res-=100;i++;
            }
            res += map[s.charAt(i) - 'A'];
        }
        return res;
    }

    /*14. Longest Common Prefix
    * 两层循环遍历,
    * 看来解析中的代码更加优雅*/
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length<2) {
            return strs[0];
        }
        int j=-1;
        while (true){
            if(j+1>=strs[0].length()){
                return strs[0].substring(0,j+1);
            }
            char c=strs[0].charAt(j+1);
            for(int i=1;i<strs.length;i++){
                if(j+1>=strs[i].length()||strs[i].charAt(j+1)!=c){
                    return strs[0].substring(0,j+1);
                }
            }
            j+=1;
        }
    }
}
