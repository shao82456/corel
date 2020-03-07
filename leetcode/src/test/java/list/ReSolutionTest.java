package list;

import org.junit.Test;

import java.util.Arrays;

import static list.Solution.makeFromArr;
import static list.Solution.makeString;
import static org.junit.Assert.*;

public class ReSolutionTest {
    ReSolution solution=new ReSolution();
    @Test
    public void addTwoNumbers() {
        ListNode l1=makeFromArr(new int[]{5});
        ListNode l2=makeFromArr(new int[]{5});
        ListNode res=solution.addTwoNumbers(l1,l2);
        String resStr=makeString(res);
        System.out.println(resStr);
    }

    @Test
    public void removeNthFromEnd() {
        ListNode l1=makeFromArr(new int[]{1});
        ListNode l2=solution.removeNthFromEnd(l1,1);
        System.out.println(makeString(l2));
    }

    @Test
    public void mergeKLists() {
        ListNode l1=makeFromArr(new int[]{1,4,5});
        ListNode l2=makeFromArr(new int[]{1,3,4});
        ListNode l3=makeFromArr(new int[]{2,6});
        ListNode res = solution.mergeKLists(new ListNode[]{l1, l2, l3});
        String resStr=makeString(res);
        System.out.println(resStr);
    }

    @Test
    public void reverseKGroup() {
        ListNode l1=makeFromArr(new int[]{1,2,3,4,5});
        ListNode res=solution.reverseKGroup(l1,1);
        System.out.println(makeString(res));
    }

}