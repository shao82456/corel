package review1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: shaoff
 * Date: 2020/3/18 13:11
 * Package: review1
 * Description:
 */
public class ListNodeTest {

    @Test
    public void fromArray() {
        int[] arr=new int[]{1,2,3,5};
        ListNode h=ListNode.fromArray(arr);
        System.out.println(h.mkString(h));
    }

    @Test
    public void mkString() {
    }
}