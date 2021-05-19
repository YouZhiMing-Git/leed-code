package com.youzm.linkedlist;

import com.youzm.contruct.ListNode;

/**
 * 反转一个单链表。
 */
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode next=head.next;
        ListNode newHead=null;
        while (cur!=null&&next!=null){
            cur.next=newHead;
            newHead=cur;
            cur=next;
            next=next.next;
        }
        cur.next=newHead;
        newHead=cur;
        return newHead;
    }

    public static void main(String[] args) {
        Solution3 solution3=new Solution3();
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        System.out.println(solution3.reverseList(head));
    }
}
