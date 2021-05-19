package com.youzm.tree;

import com.youzm.contruct.ListNode;
import com.youzm.contruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Solution3 {
    //递归调用
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return helper(root.left,root.left);

    }
    public  boolean helper(TreeNode node1,TreeNode node2){
        if(node1==node2)return true;
        if(node1==null||node2==null) return false;
        return node1.val==node2.val&&helper(node1.left,node2.right)&&helper(node1.right,node2.left);
    }


    //队列实现
    public boolean isSymmetric1(TreeNode root){
        if(root==null)return true;
        Queue<TreeNode> queue=new LinkedList();
        TreeNode u=root.left,v=root.right;
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()){
            u=queue.poll();
            v=queue.poll();
            if(u==v)continue;
            if(v==null||u==null)return false;
            if(u.val!=v.val)return false;
            queue.offer(u.left);
            queue.offer(v.right);
            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }



}
