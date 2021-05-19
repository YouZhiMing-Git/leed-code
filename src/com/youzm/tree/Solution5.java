package com.youzm.tree;

import com.youzm.contruct.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class Solution5 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return searchMiddle(nums,0,nums.length-1);
    }
    public TreeNode searchMiddle(int[] nums,int begin,int end){
        if(begin>end)return null;
        int middle=begin+(end-begin)/2;
        TreeNode node=new TreeNode(nums[middle]);
        node.left=searchMiddle(nums,begin,middle-1);
        node.right=searchMiddle(nums,middle+1,end);
        return node;
    }

    public static void main(String[] args) {
        Solution5 solution5=new Solution5();
        int[] nums={-10,-3};
        System.out.println(solution5.sortedArrayToBST(nums));
    }
}
