package com.youzm.linkedlist;

import com.youzm.contruct.ListNode;

public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node=dummy;
        ListNode delNode=dummy;
        for(int i=0;i<n+1;i++){
            node=node.next;
        }
        while (node!=null){
            node=node.next;
            delNode=delNode.next;
        }
        delNode.next=delNode.next.next;
        return dummy.next;
    }
}
