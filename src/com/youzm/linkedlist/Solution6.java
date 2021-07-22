package com.youzm.linkedlist;

import com.youzm.contruct.ListNode;

import java.util.HashSet;

public class Solution6 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddNode = head.next;
        ListNode curNode = head, curOddNode = oddNode;
        while (curNode.next != null) {

            curNode.next = curOddNode.next;
            if (curNode.next != null)
                curNode = curNode.next;
            curOddNode.next = curNode.next;
            if (curOddNode.next != null)
                curOddNode = curOddNode.next;
        }

        curNode.next = oddNode;
        return head;


    }
}
