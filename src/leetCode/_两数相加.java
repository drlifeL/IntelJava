package leetCode;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.List;

public class _两数相加 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode root = addTwoNumbers(l1, l2);
        print(root);
//        System.out.println(('0' - 48) + 1 + 2);
    }

    public static void print(ListNode listNode) {
        ListNode t = listNode;
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = Integer.parseInt(dfs(l1));
        int num2 = Integer.parseInt(dfs(l2));
        int ans = num1 + num2;

        StringBuffer sb = new StringBuffer(ans + "");
        char[] arr = sb.reverse().toString().toCharArray();
        ListNode root = new ListNode((arr[0] - 48));
        ListNode t = root;
        for (int i = 1; i < arr.length; i++) {
            ListNode cur = new ListNode((arr[i] - 48));
            t.next = cur;
            t = t.next;
        }
        return root;
    }

    private static String dfs(ListNode list) {
        ListNode t1 = list;
        StringBuffer sb = new StringBuffer();
        while (t1 != null) {
            sb.append(t1.val);
            t1 = t1.next;
        }
        return sb.reverse().toString();
    }
}
