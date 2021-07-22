package com.youzm.linkedlist;

import com.youzm.contruct.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int val,Node next) {
        this.val = val;
        this.next = next;
        this.random = null;
    }
}

public class Solution8 {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> originalNodeMap = new HashMap<>();
        Map<Integer, Node> newNodeMap = new HashMap<>();

        Node currentNode = head;
        Node lastNode = null, newHeadNode = null;

        int i = 0;
        while (currentNode != null) {
            originalNodeMap.put(currentNode, i);
            Node newNode = new Node(currentNode.val);
            if (lastNode == null) {
                newHeadNode = newNode;

            } else {
                lastNode.next = newNode;
            }
            lastNode = newNode;
            currentNode=currentNode.next;
            newNodeMap.put(i++, newNode);
        }
        currentNode = head;
        Node newCurrentNode = newHeadNode;
        int index = 0;
        Node randomNode = null;

        while (currentNode != null) {
            randomNode = currentNode.random;
            if (randomNode != null) {
                index = originalNodeMap.get(randomNode);
                newCurrentNode.random = newNodeMap.get(index);
            }
            currentNode = currentNode.next;
            newCurrentNode = newCurrentNode.next;
        }
        return newHeadNode;
    }

    public static void main(String[] args) {
        Node node0=new Node(7);
        Node node1=new Node(13);
        Node node2=new Node(11);
        Node node3=new Node(10);
        Node node4=new Node(1);
        node0.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        node1.random=node0;
        node2.random=node4;
        node3.random=node2;
        node4.random=node0;


        Solution8 solution8 = new Solution8();
        Node node = solution8.copyRandomList(node0);
        System.out.println(node);


    }
}



























