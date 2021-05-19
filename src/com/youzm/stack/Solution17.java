package com.youzm.stack;

import com.youzm.contruct.ListNode;
import com.youzm.contruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public TreeNode sortedListToBST(ListNode head) {
      return buildTree(head,null);

    }
    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }


    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Integer.MIN_VALUE;
        List<Boolean> resultList=new ArrayList<>();
        for(int candie:candies){
            max=Math.max(max,candie);
        }
        for(int candie:candies){
            boolean result=false;
            if(candie+extraCandies>=max){
                result=true;
            }
            resultList.add(result);
        }
        return resultList;
    }


}
