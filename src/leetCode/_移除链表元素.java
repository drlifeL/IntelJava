package leetCode;

import java.util.List;

public class _移除链表元素 {
    public static void main(String[] args) {
        ListNode list = new ListNode(6);
        list.next = new ListNode(6);
        list.next.next = new ListNode(6);
        list.next.next.next = new ListNode(3);
        list.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next = new ListNode(6);
        print(list);
        list = removeElements(list, 6);
        print(list);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode front = head;
        ListNode tail = null;
        boolean flag = true;
        while (front != null) {
            if (front.val == val) {
                if (front.next != null) {
                    front.val = front.next.val;
                    front.next = front.next.next;
                    flag = false;
                } else {
                    if (tail != null) {
                        tail.next = null;
                    }
                    flag = true;
                }
            }
            if (!(front.val == val)) {
                tail = front;
            }

            if (flag) {
                front = front.next;
            }
            flag = true;
        }
        return head.val == val ? null : head;
    }

    public static void print(ListNode list) {

        ListNode t = list;
        while (t != null) {
            if (t.next == null) {
                System.out.println(t.val);
                return;
            }
            System.out.print(t.val + "->");
            t = t.next;
        }
    }

}
