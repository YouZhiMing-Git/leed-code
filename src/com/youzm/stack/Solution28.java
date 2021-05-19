package com.youzm.stack;

import java.util.Stack;

/**
 * 给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
 *
 * 每个节点都有 0 个或是 2 个子节点。
 * 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。（知识回顾：如果一个节点有 0 个子节点，那么该节点为叶节点。）
 * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
 *
 */
public class Solution28 {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int ans=0;
        for(int item:arr){
            while (item>=stack.peek()){
               ans+=stack.pop()*Math.min(stack.peek(),item);
            }
            stack.push(item);
        }
        while (stack.size() > 2) {
            ans += stack.pop() * stack.peek();
        }
        return  ans;
    }
}
