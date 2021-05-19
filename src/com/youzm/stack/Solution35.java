package com.youzm.stack;

import com.youzm.contruct.TreeNode;
import com.youzm.other.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * 后序遍历 左右中
 */
public class Solution35 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LRD(root, list);
        return list;
    }

    /**
     * 递归方式
     *
     * @param node
     * @param list
     */
    public void LRD(TreeNode node, List<Integer> list) {
        if (node == null) return;
        LRD(node.left, list);
        LRD(node.right, list);
        list.add(node.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        TreeNode pre=null;
        while (!stack.empty() || node != null) {

            //迭代至最左边叶子节点
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //获取上一节点
            node = stack.peek();

           if(node.right==null||node.right==pre){
               list.add(stack.pop().val);
               pre=node;
               node=null;
           }else {
               node=node.right;
           }


        }
        return list;

    }

    public static void main(String[] args) {
        Solution35 solution35=new Solution35();
        TreeNode root=new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        System.out.println(solution35.postorderTraversal1( root));

    }

}
