package array;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode mkList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode dh = new ListNode(-1);
        ListNode cur = dh;
        for (int num : arr) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dh.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int val = this.val;
        ListNode next = this.next;
        while (next != null) {
            sb.append(val + "->");
            val = next.val;
            next = next.next;
        }
        sb.append(val);
        return sb.toString();
    }
}

public class Solution {

    /**
     * 1. Two Sum
     * 给定一个数组和目标数，找出两个和为目标数的数的index
     * 普通方法两层for循环，O(n^2)
     * 使用hash快速查找，从i=0开始，先在集合中查找另一半（这样避免用了两次自己，如4+4=8),如果没有，则加入集合，当遍历到这个数的另一半时，就找到了一对
     * 此题假定这个组只有一对数符合条件，如果不止一对要找出所有解，依然可以用此方法，因为对一个数，最多只存在一个另一半的数
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (data.containsKey((target - nums[i]))) {
                int j = data.get(target - nums[i]);
                return i < j ? new int[]{i, j} : new int[]{j, i};
            } else {
                data.put(nums[i], i);
            }
        }
        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dh = new ListNode(-1);
        ListNode cur = dh;
        int whelm = 0;
        for (ListNode p1 = l1, p2 = l2; p1 != null || p2 != null; ) {
            int sum = whelm;

            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            whelm = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if (whelm != 0) cur.next = new ListNode(whelm);
        return dh.next;
    }

    /**
     * 6. ZigZag Conversion
     * 按zigzag顺序显示字符串时，需要记录横纵坐标信息，但是结果返回的是按行串起来的信息
     * ，故不需要维护每个字符具体是哪一列的，只需要保证先后顺序即可
     * 当对输入逐字符判断行信息时，将字符放入对应的行列表中即可，行列表内的元素顺序就是该行的元素的列顺序
     */
    public String convert(String s, int numRows) {
        //准备行列表
        List<List<Character>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            rows.add(new ArrayList<>());
        //放入对应行
        int idx = 0;
        while (idx < s.length()) {
            for (int i = 0; i < numRows && idx < s.length(); i++)
                rows.get(i).add(s.charAt(idx++));
            for (int i = numRows - 2; i >= 1 && idx < s.length(); i--)
                rows.get(i).add(s.charAt(idx++));
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++)
            rows.get(i).forEach(character -> res.append(character));
        return res.toString();
    }

    /**
     * 5. Longest Palindromic Substring
     * 2D动态规划
     */

    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        /*used to extract substring*/
        int n=1,l=0;
        boolean[][] memo=new boolean[s.length()][s.length()];
        /*dp*/
        for(int len=0;len<s.length();len++){
            for(int i=0;i+len<s.length();i++){
                int j=i+len;
                if(len==0){
                    memo[i][j] = true;
                }else if(len==1){
                    memo[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    memo[i][j]=memo[i+1][j-1]&&s.charAt(i)==s.charAt(j);
                }
                if(memo[i][j]&&(j-i+1)>n){
                    n = j - i + 1;
                    l=i;
                }
            }
        }
        return s.substring(l,l+n);
    }

    /**
     * 153 Find Minimum in Rotated Sorted Array
     * 元素无重复，思路简单
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        return _findMin(nums, 0, nums.length - 1);
    }


    private int _findMin(int[] nums, int p, int r) {
//        如果两个或不足两个
        if ((r - p) < 2)
            return Math.min(nums[p], nums[r]);
        int q = (r - p) / 2 + p;
        if (nums[p] < nums[q])
            return nums[q] < nums[r] ? nums[p] : _findMin(nums, q + 1, r);
        else
            return _findMin(nums, p, q);
    }


    /**
     * 154. Find Minimum in Rotated Sorted Array II
     * 元素有重复，分情况讨论
     */

    public int findMinII(int[] nums) {
        return findMinII(nums, 0, nums.length - 1);
    }

    private int findMinII(int[] nums, int p, int r) {
        if ((r - p) < 2) return Math.min(nums[p], nums[r]);
        int q = (p + r) / 2;
        if (nums[p] == nums[q] && nums[q] == nums[r]) {
            int tmpMin = nums[p];
            for (int i = p + 1; i <= r; i++) tmpMin = Math.min(tmpMin, nums[i]);
            return tmpMin;
        } else {
            if (nums[p] <= nums[q]) {
                if (nums[q] <= nums[r]) return nums[p];
                else return findMinII(nums, q + 1, r);
            } else
                return findMinII(nums, p, q);
        }
    }

    public static class Interval {
        int end;
        int start;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        } else {
            intervals.sort(new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.start - o2.start;
                }
            });
            Interval cur = intervals.get(0);
            int pos = 0;
            while (pos != intervals.size() - 1) {
                Interval next = intervals.get(pos + 1);
                if (cur.end >= next.start) {
                    cur.end = Integer.max(cur.end, next.end);
                    intervals.remove(next);
                } else {
                    pos++;
                    cur = next;
                }

            }
            return intervals;
        }
    }

    /**
     * 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        int NR = matrix.length;
        int NC = matrix[0].length;
        boolean[][] visited = new boolean[NR + 2][NC + 2];
        Arrays.fill(visited[0], true);
        Arrays.fill(visited[NR + 1], true);
        for (int i = 0; i < NR + 2; i++)
            visited[i][0] = true;
        for (int i = 0; i < NR + 2; i++)
            visited[i][NC + 1] = true;


        int[] direcR = {0, 1, 0, -1};
        int[] direcC = {1, 0, -1, 0};

        int curX = 1, curY = 1;
        int di = 0;
        for (int i = 0; i < NR * NC; i++) {
            res.add(matrix[curX - 1][curY - 1]);
            visited[curX][curY] = true;
            int nextX = curX + direcR[di];
            int nextY = curY + direcC[di];

            if (visited[nextX][nextY]) {
                di = (di + 1) % 4;
                nextX = curX + direcR[di];
                nextY = curY + direcC[di];
            }
            curX = nextX;
            curY = nextY;
        }
        return res;
    }

    /**
     * 726. Number of Atoms
     * 和使用栈计算表达式一样，使用栈去嵌套的括号
     *
     * @param formula
     * @return
     */
    public String countOfAtoms(String formula) {
        List<String> stk = new ArrayList<>();
        List<String> tmpArr = new ArrayList<>();
        while (!formula.isEmpty()) {
            switch (formula.charAt(0)) {
                case '(':
                    stk.add("(");
                    formula = formula.substring(1);
                    break;
                case ')':
                    formula = formula.substring(1);
                    /*获取当前formula的倍数*/
                    int pos1 = getNumStrPos(formula);
                    int time = (pos1 >= 0) ? Integer.parseInt(formula.substring(0, pos1 + 1)) : 1;
                    /*更新formula*/
                    formula = formula.substring(pos1 + 1);
                    /*获取当前formula*/
                    while (!stk.get(stk.size() - 1).equals("(")) {
                        int n = time * Integer.parseInt(stk.remove(stk.size() - 1));
                        String atom = stk.remove(stk.size() - 1);
                        tmpArr.add(atom);
                        tmpArr.add(n + "");
                    }
                    /*删除"("*/
                    stk.remove(stk.size() - 1);
                    /*将去括号的结果压回栈*/
                    stk.addAll(tmpArr);
                    tmpArr.clear();
                    break;
                default:
                    /* 添加原子到栈中*/
                    int j = 1;
                    while (j < formula.length() && Character.isLowerCase(formula.charAt(j))) {
                        j++;
                    }
                    stk.add(formula.substring(0, j));
                    formula = formula.substring(j);
                    /*添加原子数到栈中*/
                    int pos2 = getNumStrPos(formula);
                    int time2 = (pos2 >= 0) ? Integer.parseInt(formula.substring(0, pos2 + 1)) : 1;
                    /*添加*/
                    stk.add(Integer.toString(time2));
                    formula = formula.substring(pos2 + 1);
                    break;
            }
        }
        return formatRes(stk);
    }

    private String formatRes(List<String> stk) {
        TreeMap<String, Integer> table = new TreeMap<>();
        while (!stk.isEmpty()) {
            int n = Integer.parseInt(stk.remove(stk.size() - 1));
            String atom = stk.remove(stk.size() - 1);
            table.put(atom, table.getOrDefault(atom, 0) + n);
        }
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, Integer> entry : table.entrySet()) {
            res.append(entry.getKey());
            if (entry.getValue() != 1) {
                res.append(entry.getValue());
            }
        }
        return res.toString();
    }

    private int getNumStrPos(String s) {
        int j = -1;//j表示最后一个数字的下标,初始值为i
        while (j + 1 < s.length() && Character.isDigit(s.charAt(j + 1))) {
            j++;
        }
        return j;
    }

    /*42. Trapping Rain Water,暴力搜索*/
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int max_left = 0;
            int max_right = 0;
            for (int j = 0; j < i; j++) {
                max_left = Math.max(height[j], max_left);
            }
            for (int j = i + 1; j < height.length; j++) {
                max_right = Math.max(height[j], max_right);
            }
            res += Math.max(Math.min(max_left, max_right) - height[i], 0);
        }
        return res;
    }

    /*42. Trapping Rain Water,动态规划避免第二层循环*/
    public int trap1(int[] height) {
        int res = 0;
        /*max_left[i]表示i最高的左墙,即max(height[0,i-1])*/
        int[] max_left = new int[height.length];
        if (max_left.length > 0)
            max_left[0] = 0;
        for (int j = 1; j < max_left.length; j++) {
            max_left[j] = Math.max(height[j - 1], max_left[j - 1]);
        }
        int[] max_right = new int[height.length];
        if (max_right.length > 0)
            max_right[max_right.length - 1] = 0;
        for (int j = max_right.length - 2; j >= 0; j--) {
            max_right[j] = Math.max(height[j + 1], max_right[j + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            res += Math.max(Math.min(max_left[i], max_right[i]) - height[i], 0);
        }
        return res;
    }

    public boolean isValidSudoku(char[][] board) {
        int[] ht = new int[10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!tryIncre(board, ht, i, j)) {
                    return false;
                }
            }
            ht = new int[10];
        }

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (!tryIncre(board, ht, i, j)) {
                    return false;
                }
            }
            ht = new int[10];
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int i1 = i; i1 < i + 3; i1++) {
                    for (int j1 = j; j1 < j + 3; j1++) {
                        if (!tryIncre(board, ht, i1, j1)) {
                            return false;
                        }
                    }
                }
                ht = new int[10];
            }
        }
        return true;
    }

    private boolean tryIncre(char[][] board, int[] ht, int i, int j) {
        char c = board[i][j];
        if (c != '.' && ht[c - '0'] > 0) {
            return false;
        } else if (c != '.') {
            ht[c - '0'] += 1;
        }
        return true;
    }

    public int majorityElement(int[] nums) {
        int t = nums.length / 2;
        int l = 0, r = nums.length - 1;
        int q;
        while ((q = partition(nums, l, r)) != t) {
            if (q < t) {
                l = q + 1;
            } else if (q > t) {
                r = q - 1;
            }
        }
        /*check*/
        int c = 0;
        for (int num : nums) {
            if (num == nums[q]) {
                c += 1;
            }
        }
        return c > nums.length / 2 ? nums[q] : -1;
    }

    /*返回数组有序后，在idx位置的元素
     * 原数组nums会发生变化*/
    private int findInSorted(int[] nums, int idx) {
        assert idx < nums.length;
        int l = 0, r = nums.length - 1;
        int q;
        while ((q = partition(nums, l, r)) != idx) {
            if (q < idx) {
                l = q + 1;
            } else if (q > idx) {
                r = q - 1;
            }
        }
        return nums[idx];
    }

    /*
     * 以arr[l]为基准key，将arr[l...r]划分为arr[l...q],arr[q+1..r],
     * 前半部分<key,后半部分>=key*/
    public int partition(int[] arr, int l, int r) {
        assert l < arr.length && r < arr.length && l <= r;
        int key = arr[l];
        int i = l, j = r + 1; //arr[l+1...i] 为前半部分,arr[j...r]为后半部分
        while (i < j - 1) {
            if (arr[i + 1] < key) {
                i++;
            } else {
                int tmp = arr[j - 1];
                arr[j - 1] = arr[i + 1];
                arr[i + 1] = tmp;
                j--;
            }
        }
        arr[l] = arr[i];
        arr[i] = key;
        return i;
    }

    public List<Integer> majorityElementII(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int bs = nums.length / 3;
        int p1 = 0 + bs, p2 = nums.length - 1 - bs;
        int c1 = 0, c2 = 0;
        int pnum1 = findInSorted(nums, p1);
        int pnum2 = findInSorted(nums, p2);

        for (int num : nums) {
            if (num == pnum1) {
                c1++;
            }
            if (num == pnum2) {
                c2++;
            }
        }
        if (c1 > bs) {
            res.add(pnum1);
        }
        if (c2 > bs && pnum1 != pnum2) {
            res.add(pnum2);
        }
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
//        assert nums.length>1;
        for (int i = 1; i < left.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    /*289. Game of Life
     * 用特殊的值来描述数据变化前后的值*/
    public void gameOfLife(int[][] board) {
        int[] go = new int[]{0, 1, -1};
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int liveNeighborC = 0;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (!(m == 0 && n == 0)) {
                            int ni = i + go[m];
                            int nj = j + go[n];
                            if (ni >= 0 && ni < r && nj >= 0 && nj < c) {
                                if (Math.abs(board[ni][nj]) == 1) {
                                    liveNeighborC += 1;
                                }
                            }
                        }
                    }
                }
                /*之前是alive*/
                if (board[i][j] == 1 && (liveNeighborC < 2 || liveNeighborC > 3)) {
                    board[i][j] = -1;
                }
                if (board[i][j] == 0 && liveNeighborC == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    /*448. Find All Numbers Disappeared in an Array
     * 不能用额外的空间，那还可以想办法利用已经给的空间*/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int N = nums.length + 1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[nums[i] % N - 1] += N;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < N) {
                res.add(i + 1);
            }
        }
        return res;
    }

    /*类似选择排序*/
    public int thirdMax(int[] nums) {
        int m1 = Integer.MIN_VALUE, m2 = Integer.MIN_VALUE, m3 = Integer.MIN_VALUE;
        boolean m3Seted = false;
        for (int i = 0; i < nums.length; i++) {
            m1 = Math.max(nums[i], m1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < m1) {
                m2 = Math.max(nums[i], m2);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < m2) {
                m3 = Math.max(nums[i], m3);
                m3Seted = true;
            }
        }
        return m3Seted ? m3 : m1;
    }

    /*使用和442一样的思路*/
    public List<Integer> findDuplicates(int[] nums) {
        int N = nums.length + 1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[nums[i] % N - 1] += N;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > N * 2) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int lb = 0, le = -1;
        for (int point : timeSeries) {
            if (point > le) {
                res += le - lb + 1;
                lb = point;
                le = lb + duration - 1;
            } else {
                le = point + duration - 1;
            }
        }
        res += le - lb + 1;
        return res;
    }

    /*560. Subarray Sum Equals K
     * 暴力搜索+求和优化*/
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0 && k == 0) {
            return 1;
        } else if (nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sum[j] - sum[i] + nums[i] == k) {
                    res += 1;
                }
            }
        }
        return res;
    }

    /*排序+滑动窗口
     * 滑动窗口看来不行，因为有负数存在*/
    @Deprecated
    public int subarraySumII(int[] nums, int k) {
        if (nums.length == 0 && k == 0) {
            return 1;
        } else if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0, j = -1;
        int cur = 0;
        int res = 0;
        while (i < nums.length) {
            if (j + 1 < nums.length && cur < k) {
                cur += nums[++j];
            } else if (j >= i) {
                cur -= nums[i++];
            }
            if (cur == k) {
                res += 1;
            }
        }
        return res;
    }


    /*hashtable+查找*/
    public int subarraySumIII(int[] nums, int k) {
        if (nums.length == 0 && k == 0) {
            return 1;
        } else if (nums.length == 0) {
            return 0;
        }
        int lastSum = 0;
        Map<Integer, List<Integer>> ht = new HashMap<>();
        Map<Integer, Integer> ht2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            lastSum += nums[i];
            List<Integer> idxs = ht.getOrDefault(lastSum, new ArrayList<>());
            idxs.add(i);
            ht.put(lastSum, idxs);
            ht2.put(i, lastSum);
        }
        /*把求和为0空子数组准备好 */
        List<Integer> idxs = ht.getOrDefault(0, new ArrayList<>());
        idxs.add(-1);
        ht.put(0, idxs);

        /*由于每个子数组都是arr[i..j],对每个sum[j],查找是否有对应的sum[i]*/
        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            int sumj = ht2.get(j);
            int diff = sumj - k;
            if (ht.containsKey(diff)) {
                for (int i : ht.get(diff)) {
                    if (i + 1 <= j) {
                        res += 1;
                    }
                }
            }
        }
        return res;
    }

    /*561 Array Partition I*/
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    /*565. Array Nesting
    数组会组成几个子链表，子链表都是环形链表，最短长度为1，进行深度搜索，找出节点数最大的即可，*/
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int cur = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            int init = i;
            while (!visited[init]) {
                visited[init] = true;
                cur += 1;
                init = nums[init];
            }
            res = Math.max(res, cur);
            cur = 0;
        }
        return res;
    }

    /*566. Reshape the Matrix
     * 从左到右遍历矩阵即可*/
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }
        int[][] newNums = new int[r][c];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                newNums[k / c][k % c] = nums[i][j];
                k++;
            }
        }
        return newNums;
    }

    /*581. Shortest Unsorted Continuous Subarray*/
    public int findUnsortedSubarray(int[] nums) {
        int[] ori = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int l = -1;
        while ((l + 1) < nums.length && nums[l + 1] == ori[l + 1]) {
            l++;
        }
        int r = nums.length;
        while ((r - 1) >= 0 && nums[r - 1] == ori[r - 1]) {
            r--;
        }
        //数组已经有序
        if (l >= r) {
            return 0;
        }
        //l+1...r-1表示无序部分
        return r - 1 - l;
    }

    /*611. Valid Triangle Number
     * 数学分析+二分搜索*/
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
//      数组排序后，a<=b<=c判断三角形只需确认a+b<=c
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                int k = find(nums, j + 1, nums.length - 1, nums[i] + nums[j]);
                count += (k - 1 - j);
            }
        }
        return count;
    }

    private int find(int[] nums, int l, int r, int key) {
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] >= key) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    /*621. Task Scheduler*/
    public int leastInterval(char[] tasks, int n) {
        int[] data = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            data[tasks[i] - 'A'] += 1;
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                que.add(i);
            }
        }
        int res = 0;
        int cur = 0;
        while (!que.isEmpty()) {
            int task = que.peek();
            int count = data[task];
            if (count <= n) {
                res += count;
                que.poll();
            } else {
                res -= count;
                que.poll();
            }
        }
        return res;
    }

    /*628. Maximum Product of Three Numbers
     * 分析：
     * 1.如果结果大于0，选3个正数，或是两个负数，一个正数
     * 2.如果结果小于0，选3个负数，或是两个正数，一个负数
     * 但是除非一个正数都没有，否则必是情况1
     * */
    public int maximumProduct(int[] nums) {
        int max = -1001;
        int min = 1001;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (max < 0) {
            //说明都是负，选3个最大的负数
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int num : nums) {
                if (pq.size() < 3) {
                    pq.add(num);
                } else if (pq.peek() < num) {
                    pq.add(num);
                    pq.remove();
                }
            }
            // assert pq.size()==3
            return pq.remove() * pq.remove() * pq.remove();
        } else {
            //三个最大正数，或两个最小负数，一个最大正数
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            for (int num : nums) {
                if (pq1.size() < 3) {
                    pq1.add(num);
                } else if (pq1.peek() < num) {
                    pq1.remove();
                    pq1.add(num);
                }
            }
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
            for (int num : nums) {
                if (pq2.size() < 2) {
                    pq2.add(num);
                } else if (pq2.peek() > num) {
                    pq2.remove();
                    pq2.add(num);
                }
            }
            int t1 = pq1.remove() * pq1.remove() * pq1.remove();
            int t2 = pq2.remove() * pq2.remove() * max;
            return Math.max(t1, t2);
        }
    }

    /*643. Maximum Average Subarray I
     * 连续固定长度子数组，用滑动窗口扫描一遍即可*/
    public double findMaxAverage(int[] nums, int k) {
        //assert 1<=k<=nums.length
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(sum, res);
        }
        return res / k;
    }

    /*661. Image Smoother
     * 暴力搜索*/
    public int[][] imageSmoother(int[][] M) {
        int[][] nM = new int[M.length][M[0].length];
        int[] go = new int[]{-1, 0, 1};
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int sum = 0;
                int count = 0;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        int ni = go[m] + i;
                        int nj = go[n] + j;
                        if ((ni >= 0 && ni < M.length) && (nj >= 0 && nj < M[0].length)) {
                            sum += M[ni][nj];
                            count += 1;
                        }
                    }
                }
                nM[i][j] = sum / count;
            }
        }
        return nM;
    }

    /*665. Non-decreasing Array
    * 暴力搜索*/
    public boolean checkPossibility(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int cur=Integer.MIN_VALUE;
            boolean ordered=true;
            for(int j=0;j<nums.length&&ordered;j++){
                if(j!=i){
                    if(cur<=nums[j]){
                        cur=nums[j];
                    }else{
                        ordered=false;
                    }
                }
            }
            if(ordered){
                return true;
            }
        }
        return false;
    }

    /*665. Non-decreasing Array
     * 动态规划改进*/
    public boolean checkPossibilityII(int[] nums) {
        int[] begin=new int[nums.length];
        for(int i=0;i<begin.length;i++){
            begin[i]=i;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=nums[i-1]){
                begin[i]=begin[i-1];
            }
        }
        if( begin[nums.length-1]<=1||begin[nums.length-2]==0){
            return true;
        }else{
            for(int i=1;i<nums.length-1;i++){
                boolean left=begin[i-1]==0;
                boolean right=begin[nums.length-1]<=i+1;
                if(left&&right&&nums[i-1]<=nums[i+1]){
                    return true;
                }
            }
            return false;
        }
    }

    /*670. Maximum Swap
    * 贪心*/
    public int maximumSwap(int num) {
//      记录每个数字最后出现的位置
        int[] lastPos=new int[10];
        char[] cs=String.valueOf(num).toCharArray();
        Arrays.fill(lastPos,-1);
        for(int i=0;i<cs.length;i++){
            lastPos[cs[i]-'0']=i;
        }
        for(int i=0;i<cs.length;i++){
//           用最后面的比cs[i]大的数字来交换
            int toSwap=-1;
            for(int j=cs[i]-'0'+1;j<lastPos.length;j++){
                if(lastPos[j]>i){
                    toSwap=lastPos[j];
                }
            }
            if(toSwap>0){
                char tmp=cs[i];
                cs[i]=cs[toSwap];
                cs[toSwap]=tmp;
                return Integer.parseInt(String.valueOf(cs));
            }
        }
        return num;
    }

    /*674. Longest Continuous Increasing Subsequence
    * 用滑动窗口*/
    public int findLengthOfLCIS(int[] nums) {
        //初始化窗口
        int l=0,r=0;
        //开始滑动
        int res=0;
        while (l<nums.length){
            if((r+1)<nums.length&&nums[r+1]>nums[r]){
                r++;
            }else{
                l=r=r+1;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }

    /*697. Degree of an Array
    * 用滑动窗口*/
    public int findShortestSubArray(int[] nums) {
        //先获取数组的度
        Map<Integer,Integer> map=new  HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int degree=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            degree=Math.max(degree,entry.getValue());
        }
        //初始化窗口
        Map<Integer,Integer> wd=new HashMap<>();
        int curDegree=0;
        int l=0,r=-1;
        //开始滑动
        int res=nums.length;
        while(l<nums.length){
            if((r+1)<nums.length&&curDegree<degree){
                int count=wd.getOrDefault(nums[++r],0)+1;
                wd.put(nums[r],count);
                if(count>curDegree){
                    curDegree=count;
                }
            }else if(r<l){
                //滑动左边界，且窗口为空时
                r+=1;
                l+=1;
            }else{
                //滑动左边界，且窗口不为空时
                int count=wd.getOrDefault(nums[l],0)-1;
                wd.put(nums[l++],count);
                //窗口一定只有一个元素的频率代表这个度
                if(count+1==curDegree){
                    curDegree=count;
                }
            }
            if(curDegree==degree){
                res=Math.min(res,r-l+1);
            }
        }
        return res;
    }
}
