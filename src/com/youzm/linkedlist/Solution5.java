package com.youzm.linkedlist;

import com.youzm.contruct.ListNode;

import java.util.HashSet;
import java.util.List;

public class Solution5 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set=new HashSet<>();
        ListNode node=head;
        while (node!=null){
            if(set.contains(node))return true;
            else {
                set.add(node);
                node=node.next;
            }
        }
        return false;
    }
    public boolean hasCycle1(ListNode head){
        if(head==null)return false;
        if(head.next==null) return false;
        if(head.next.next==null)return false;
        ListNode fast=head.next.next;
        ListNode slow=head;
        while (fast!=slow){
            if(slow.next==null)return false;
            slow=slow.next;
            if(fast.next==null||fast.next.next==null)return false;
            fast=fast.next.next;
        }
        return true;

    }
}
