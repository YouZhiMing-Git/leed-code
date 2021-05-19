package com.youzm.other;

import com.youzm.contruct.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> qList=new ArrayList<>();
        ListNode p =head;
        while (p.next!=null){
            ListNode q=p;
            qList.add(q);
            p=p.next;
        }
        int length=qList.size();
        if(n==length){
            return qList.get(0).next;
        }else {
            int target=length-n;
            qList.get(target-1).next=qList.get(target).next;
            return qList.get(0);
        }
    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast=dummy;
        ListNode slow=dummy;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
    public static void main(String[] args) {

    }
}



