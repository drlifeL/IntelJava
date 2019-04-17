package _笔试;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  除了超时以外，一切正常
 */
public class _疏散人群链表法 {
    private static class Node {
        public Node(int v) {
            this.v = v;
        }
        int v;
        Node next;
    }

    static Node[] nodes;
    static boolean[] vis;
    static int ans;

    public static void add(int a, int b) {
        Node temp = new Node(b);
        if (nodes[a] == null) {//如果与之关联的并不存在元素，那么则创建过去
            nodes[a] = temp;
        } else {
            Node t = nodes[a];
            while (true) {
                if (t.next == null) {
                    t.next = temp;
                    break;
                }
                t = t.next;
            }
        }
    }

    private static int bfs(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        int res = 0;
        while (!queue.isEmpty()) {
            Node t = queue.poll();
            vis[t.v] = true;
            Node x = nodes[t.v];//传递是它与他有关系的边接点
            while (x != null) {
                if (!vis[x.v]) {
                    queue.add(x);
                    res++;
                }
               x = x.next;
            }
        }
        return res + 1;//加1是算上自己的根节点
    }

    //输出关系
    private static void print() {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                Node t = nodes[i];
                System.out.print(i + "::");
                while (t != null) {
                    System.out.print(t.v + " ");
                    t = t.next;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nodes = new Node[n + 1];
        vis = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();//是哪个链表
            int b = sc.nextInt();//与他有关系是
            add(a, b);//相互都要添加
            add(b, a);
        }
//        print();
        vis[1] = true;
        Node temp = nodes[1];
        while (temp != null) {
            ans  = Math.max(bfs(temp),ans);
            temp = temp.next;
        }
        System.out.println(ans);
    }

}
