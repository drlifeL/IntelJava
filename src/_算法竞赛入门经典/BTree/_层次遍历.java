package _算法竞赛入门经典.BTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _层次遍历 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(5);
        root.leftNode = new Node(4);
        root.leftNode.leftNode = new Node(11);
        root.leftNode.leftNode.leftNode = new Node(7);
        root.leftNode.leftNode.rightNode = new Node(2);

        root.rightNode = new Node(8);
        root.rightNode.leftNode = new Node(13);
        root.rightNode.rightNode = new Node(4);
        root.rightNode.rightNode.rightNode = new Node(1);

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value + ":");
            if (cur.leftNode != null) {
                queue.add(cur.leftNode);
            }
            if (cur.rightNode != null) {
                queue.add(cur.rightNode);
            }
        }

    }
}

class Node {
    public int value;
    public Node leftNode;
    public Node rightNode;

    public Node(int value) {
        this.value = value;
    }
}
