package com.youzm.linkedlist;

import com.youzm.contruct.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 */
public class Solution4 {
    public boolean isPalindrome(ListNode head) {
        if(head==null)return false;
        StringBuilder x=new StringBuilder();
        StringBuilder y=new StringBuilder();
        ListNode node=head;
        while (node!=null){
            x.append(node.val);
            y.insert(0,node.val);
            node=node.next;
        }
        return x.toString().equals(y.toString());
    }
    public boolean isPalindrome1(ListNode head) {
        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd);

        while (secondHalfStart != null) {
            if (head.val != secondHalfStart.val) return false;
            head = head.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }

    // 反转链表
    // 取自：https://leetcode-cn.com/problems/reverse-linked-list/solution/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            // 临时存储当前结点的 next
            ListNode tempNext = curr.next;
            // 反转当前结点
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }

    // 查找前半部分的尾结点
    // 快慢指针
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        Solution4 solution4=new Solution4();
        ListNode head=new ListNode(1);
        System.out.println(solution4.isPalindrome(head));
    }
}
