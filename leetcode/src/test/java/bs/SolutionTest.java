package bs;

import junit.framework.TestCase;

/**
 * Author: shaoff
 * Date: 2020/5/30 21:06
 * Package: bs
 * Description:
 */
public class SolutionTest extends TestCase {
    Solution solution=new Solution();
    public void testSearch() {
        int[] arr=new int[]{1,1,1,2,2,1};
        System.out.println(solution.search2(arr,2));

    }
}