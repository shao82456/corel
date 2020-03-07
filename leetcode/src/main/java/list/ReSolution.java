package list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ReSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        ListNode dh = new ListNode(-1);
        ListNode cur3 = dh;
        int spill = 0;
        while (cur1 != null || cur2 != null) {
            int sum = spill;
            if (cur1 != null) {
                sum += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                sum += cur2.val;
                cur2 = cur2.next;
            }
            spill = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            cur3.next = newNode;
            cur3 = newNode;
        }
        /*process the last spill*/
        int sum = cur3.val + spill;
        if (spill != 0) {
            cur3.next = new ListNode(spill);
        }
        return dh.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dh = new ListNode(-1);
        dh.next = head;
        ListNode bef = findNthFromEnd(dh, n + 1);
        bef.next = bef.next.next;
        return dh.next;
    }

    private ListNode findNthFromEnd(ListNode head, int n) {
        assert head != null;
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode head : lists) {
            if (head != null) {
                heap.add(head);
            }
        }
        ListNode dh = new ListNode(-1);
        ListNode cur = dh;

        while (heap.size() > 0) {
            ListNode min = heap.remove();
            if (min.next != null)
                heap.add(min.next);
            cur.next = min;
            cur = cur.next;
        }
        return dh.next;
    }

    /*24. Swap Nodes in Pairs
     * 链表类的题用递归会简单很多*/
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = swapPairs(head.next.next);
        ListNode next = head.next;
        head.next = left;
        next.next = head;
        return next;
    }

    /*25. Reverse Nodes in k-Group
     * 和24题类似，采用递归+栈的思路,
     * 可以避免使用栈*/
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        return _reverseKGroup(head, k);
    }

    private ListNode _reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> stk = new ArrayList<>();
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            stk.add(cur);
            cur = cur.next;
        }
        if (stk.size() < k) {
            return head;
        }
        assert k > 0;
        ListNode left = _reverseKGroup(cur, k);
        ListNode newHead = stk.remove(stk.size() - 1);
        ListNode newCur = newHead;
        while (!stk.isEmpty()) {
            newCur.next = stk.remove(stk.size() - 1);
            newCur = newCur.next;
        }
        newCur.next = left;
        return newHead;
    }
}