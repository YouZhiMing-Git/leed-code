package com.youzm.tree;

import com.youzm.contruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Solution4 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        addValue(nodes, lists);
        return lists;

    }

    public void addValue(List<TreeNode> nodes, List<List<Integer>> lists) {
        if (nodes.size() == 0) return;
        List<TreeNode> tempNodes = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                list.add(node.val);
                tempNodes.add(node.left);
                tempNodes.add(node.right);
            }

        }
        if (list.size() > 0) {
            lists.add(list);
        }

        addValue(tempNodes, lists);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int length=queue.size();
            for (int i = 0; i < length; i++) {
                node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            lists.add(list);
        }
        return lists;

    }
}
