package com.youzm.tree;

import com.youzm.contruct.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Solution6 {

    int EmptyValue=-2000;
    TreeNode emptyNode = new TreeNode(EmptyValue);

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(queue.poll() + " ");
            if(node!=emptyNode){
                queue.add(node.left == null ? emptyNode : node.left);
                queue.add(node.right == null ? emptyNode : node.right);
            }
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;

        String[] dataStr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(dataStr[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < dataStr.length-1; i+=2) {
            TreeNode node=queue.poll();
            int leftValue=Integer.parseInt(dataStr[i]);
            int rightValue=Integer.parseInt(dataStr[i+1]);

            if(leftValue!=EmptyValue){
                node.left=new TreeNode(leftValue);
                queue.add(node.left);
            }
            if(rightValue!=EmptyValue){
                node.left=new TreeNode(rightValue);
                queue.add(node.right);
            }
        }

        return root;
    }


}
