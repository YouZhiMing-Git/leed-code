package com.youzm.stack;

import com.youzm.contruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个二叉树，返回它的中序 遍历。
先左子树  根节点  右子树
*/
public class Solution23 {
   /* List<Integer> result=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        LDR(root);
        return result;
    }
    *//*递归算法*//*
    public void LDR(TreeNode node){
        if(node==null) return;
        LDR(node.left);
        result.add(node.val);
        LDR(node.right);
    }*/

    /*迭代方式*/
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curNode = root;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (curNode != null||!stack.empty()) {
            //遍历至左子树 左叶子节点
            if(curNode!=null){
                stack.push(curNode);
                curNode=curNode.left;
            }else {
                //获取中间节点
                curNode=stack.pop();
                result.add(curNode.val);
                curNode=curNode.right;

            }
        }
        return result;

    }


}
