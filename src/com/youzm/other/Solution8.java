package com.youzm.other;

import com.youzm.contruct.ListNode;

public class Solution8 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            if (p.val > q.val) {
                current.next = q;
                q = q.next;
            } else {
                current.next = p;
                p = p.next;
            }
            current=current.next;
        }
        if (p != null) {
            current.next = p;
        }
        if (q != null) {
            current.next = q;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution8 solution8=new Solution8();
        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2=new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode l=solution8.mergeTwoLists(l1,l2);
    }

}
