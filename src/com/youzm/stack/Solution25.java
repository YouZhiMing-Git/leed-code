package com.youzm.stack;

import com.youzm.contruct.TreeNode;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*给定一个二叉树，返回它的 前序 遍历。
 * ，是二叉树遍历的一种，也叫做先根遍历、先序遍历、前序周游，可记做根左右。前序遍历首先访问根结点然后遍历左子树，最后遍历右子树。*/
public class Solution25 {


    //递归方式
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        VLR(root, result);
        return result;
    }

    public void VLR(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        VLR(node.left, list);
        VLR(node.right, list);
    }

    //迭代方式
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        TreeNode curNode=root;
        Stack<TreeNode> stack=new Stack<>();
        while (curNode!=null||!stack.empty()){
            if(curNode!=null){
                list.add(curNode.val);
                stack.push(curNode);
                curNode=curNode.left;
            }else {
                curNode=stack.pop().right;
            }

        }
        return list;
    }


}
