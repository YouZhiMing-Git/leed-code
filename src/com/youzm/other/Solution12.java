package com.youzm.other;

import com.youzm.contruct.TreeNode;
import sun.reflect.generics.tree.Tree;

/*
* 给定一个二叉树，判断它是否是高度平衡的二叉树
* */
public class Solution12 {


    /*暴力破解*/
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(depth(root.left)-depth(root.right))<2&&isBalanced((root.left))&&isBalanced(root.right);
    }

    public int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        return  Math.max(depth(node.left),depth(node.right))+1;
    }




    /*
    * 自底向上
    * */
    public boolean isBalanced1(TreeNode root) {
        return depthTree(root)!=-1;
    }
    public int depthTree(TreeNode node){
        if(node==null) return 0;
        int leftDepth=depthTree(node.left);
        if(leftDepth==-1) return -1;
        int rightDepth=depthTree(node.right);
        if(rightDepth==-1) return -1;
        return Math.abs(leftDepth-rightDepth)<2?Math.max(leftDepth,rightDepth)+1:-1;
    }
}
