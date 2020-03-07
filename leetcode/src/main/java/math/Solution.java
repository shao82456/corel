package math;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    /**
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        return false;
    }

    /**
     * 12. Integer to Roman
     **/
    public String intToRoman(int num) {
        String[] mapg = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] maps = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] mapb = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] mapq = {"M", "MM", "MMM"};

        if (num < 1 || num > 3999)
            throw new IllegalArgumentException();

        int val = num;
        int q = val / 1000;
        val -= q * 1000;
        int b = val / 100;
        val -= b * 100;
        int s = val / 10;
        val -= s * 10;
        int g = val;

        StringBuilder res = new StringBuilder();
        if (q != 0)
            res.append(mapq[q - 1]);
        if (b != 0)
            res.append(mapb[b - 1]);
        if (s != 0)
            res.append(maps[s - 1]);
        if (g != 0)
            res.append(mapg[g - 1]);

        return res.toString();
    }

    /**
     * 202. Happy Number
     * 关键在环检测，采用Floyd环检测算法
     */
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = calculate(slow);
            if (slow == 1) return true;
            fast = calculate(fast);
            fast = calculate(fast);
        } while (fast != slow);
        return false;
    }

    public int calculate(int num) {
        int res = 0;
        while (num > 0) {
            res += (num % 10) * (num % 10);
            num /= 10;
        }
        return res;
    }

    /**
     * 求比n小的质数的个数
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                res++;
                for (int k = 1; k * i < n; k++)
                    isPrime[k * i] = false;
            }
        }
        return res;
    }

    public int countPrimes1(int n) {
        int maxFactor = (int) Math.ceil(Math.sqrt(n));
        HashSet<Integer> res = new HashSet<>();
        for (int factor = 2; factor <= maxFactor; factor += 1) {
            while (n % factor == 0) {
                n /= factor;
                res.add(factor);
            }
        }
        return res.size();
    }

    public int reverse(int x) {
        int res = 0;
        int left = x;
        int poped;
        while (left != 0) {
            poped = left % 10;
            left /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && poped > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && poped < -8)){
                return 0;
            }
            res = res * 10 + poped;
        }
        return res;
    }

    /*9. Palindrome Number
     * 不使用字符串的方式，将x的后半部分翻转，将得到的整数与前半部分比较*/
    public boolean isPalindrome(int x) {
        if ((x<0||(x%10==0&&x!=0))) {
            return false;
        }
        int left=x;
        int right=0;
        while (left>right){
            right=right*10+left%10;
            left /= 10;
        }
        return left==right||left==right/10;
    }
}
