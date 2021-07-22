package com.youzm.linkedlist;

import com.youzm.contruct.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Solution7 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode boy = headA, girl = headB;
        while (boy != girl) {
            boy = boy != null ? boy.next : headB;
            girl = girl != null ? girl.next : headA;
        }

        return boy;
    }
}
