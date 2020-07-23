from typing import List

from list.ListNode import ListNode


class ListUtil:
    @classmethod
    def mkList(cls, arr: List[int]) -> ListNode:
        dh = ListNode(-1)
        cur = dh
        for num in arr:
            cur.next = ListNode(num)
            cur = cur.next
        return dh.next

    @classmethod
    def printList(cls, head: ListNode):
        res = []
        cur = head
        while cur:
            res.append(cur.val)
            cur = cur.next
        print(res)


if __name__ == '__main__':
    head = ListUtil.mkList([0,1,2,3,4])

    ListUtil.printList(head)
