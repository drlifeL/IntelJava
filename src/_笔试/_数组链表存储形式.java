package _笔试;

/**
 * 图的邻接表存储形式
 *   我们需要创建一个Node数组，然后每一个node[i] 中存储是的与他存在边关系的节点。
 *   由此就可以完成
 */
public class _数组链表存储形式 {
    private static class Node{
        public Node(int x){
            this.x = x;
        }
        int x ;
        Node next;
    }
    public static void main(String[] args) {
        Node x = new Node(3);
        x.next = new Node(4);
        x.next.next = new Node(5);
        Node t = x;
        while(t!=null){
            System.out.println(t.x);
            t = t.next;
        }
    }
}
