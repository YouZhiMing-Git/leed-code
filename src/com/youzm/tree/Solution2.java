package com.youzm.tree;

import com.youzm.contruct.TreeNode;

/**
 * 验证二叉搜索树
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Solution2 {


    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node ,long low,long upper){
        if(node==null)return  true;
        if(node.val>=upper)return false;
        if(node.val<=low)return false;
        return helper(node.left,low,node.val)&&helper(node.right,node.val,upper);
    }


    //中序遍历
    long pre=Long.MIN_VALUE;
    public boolean isValidBST1(TreeNode root){
        if(root==null)return true;
        if(!isValidBST1(root.left))return false;
        if(root.val<=pre)return false;
        pre=root.val;
        return isValidBST1(root.right);
    }

}
