package com.youzm.stack;

import com.youzm.contruct.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],。
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 输出为
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Solution39 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        initValue(queue,resList,false);
        return resList;
    }

    public void initValue(Queue<TreeNode> queue, List<List<Integer>> resList, boolean left) {
        if(queue.size()==0)return;
        List<Integer> res = new ArrayList<>();
        int n=queue.size();
        while (n>0) {
            TreeNode node=queue.poll();
            if(left) res.add(node.val);
            else res.add(0,node.val);
            if(node.right!=null)queue.offer(node.right);
            if(node.left!=null)queue.offer(node.left);
            n--;
        }
        resList.add(res);
        initValue(queue,resList,!left);
    }

    public static void main(String[] args) {
        Solution39 solution39=new Solution39();
        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,null,new TreeNode(5)));
        System.out.println(solution39.zigzagLevelOrder(root));
    }


}
