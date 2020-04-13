package review1;

/**
 * Author: shaoff
 * Date: 2020/3/18 13:04
 * Package: review1
 * Description:
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        this.val=x;
    }

    public static ListNode fromArray(int[] arr){
        ListNode dh=new ListNode(-1);
        ListNode cur=dh;
        for(int num:arr){
            cur.next=new ListNode(num);
            cur=cur.next;
        }
        return dh.next;
    }

    public static String mkString(ListNode h){
        StringBuilder stringBuilder=new StringBuilder();
        while(h!=null){
            stringBuilder.append(h.val);
            if(h.next!=null){
                stringBuilder.append("->");
            }
            h=h.next;
        }
        return stringBuilder.toString();
    }
}
