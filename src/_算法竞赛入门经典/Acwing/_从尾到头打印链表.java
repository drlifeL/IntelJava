package _算法竞赛入门经典.Acwing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _从尾到头打印链表 {
    public static void main(String[] args) {
/*        ListNode head = new ListNode(10);
        head.next = new ListNode(12);
        head.next.next = new ListNode(15);
        List<Integer> list = new ArrayList<Integer>();
        System.out.println(Arrays.toString(printListReversingly(head)));*/
        String s  = "abcd";
        int index = s.indexOf("d");
        System.out.println(index);

    }

    private static int[] printListReversingly(ListNode head) {
/*        if (head.next != null) {
            printListReversingly(head.next,list);
        }*/
        List<Integer> list = new ArrayList<Integer>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }

        int [] arr  = new int[list.size()];
        for (int i = list.size()-1; i >= 0; i--) {
            arr[list.size()-1-i] = list.get(i);
        }
        return arr;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
