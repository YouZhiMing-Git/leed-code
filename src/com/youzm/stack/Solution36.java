package com.youzm.stack;

import com.youzm.contruct.ListNode;

import java.util.Stack;

public class Solution36 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack_index=new Stack<>();
        Stack<Integer> stack_val=new Stack<>();
        ListNode node=head;
        stack_index.add(-1);
        stack_val.add(Integer.MAX_VALUE);
        int index=0;
        int size=0;
        while (node!=null){
            node=node.next;
            size++;
        }
        node=head;
        int[] largerVals=new int[size];
        while (node!=null){

            while (node.val>stack_val.peek()){
                largerVals[stack_index.pop()]=node.val;
                stack_val.pop();
            }
            stack_val.add(node.val);
            node=node.next;
            stack_index.push(index);
            index++;
        }

       return largerVals;
    }

    public static void main(String[] args) {
        Solution36 solution36=new Solution36();
        ListNode root=new ListNode(2,new ListNode(1,new ListNode(5)));
        System.out.println(solution36.nextLargerNodes(root));
    }
}
