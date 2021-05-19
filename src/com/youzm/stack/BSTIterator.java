package com.youzm.stack;

import com.youzm.contruct.TreeNode;

import java.util.Stack;

public class BSTIterator {


    Stack<Integer> stack=new Stack<>();

    public BSTIterator(TreeNode root) {
        insertStackDesc(root);
    }

    private void insertStackDesc(TreeNode node){
        if(node==null) return;
        insertStackDesc(node.right);
        stack.push(node.val);
        insertStackDesc(node.left);

    }
    /**
     * @return the next smallest number
     */
    public int next() {
        return stack.pop();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.empty();
    }
}
