package leetCode;

public class _删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        print(list);
//        list = removeNthFromEnd(list, 1);
        list = removeNode(list, 5);
        System.out.println("<------------------->");
        print(list);

    }

    public static void print(ListNode list) {
        ListNode t = list;
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }
    }

    /**
     * 1.想用快慢指针一遍循环，在删除第一个的时候会出现空指针异常！(已解决)
     * 2.删除位置会莫名向前移动一位，已解决
     * 虽然看起来很混乱，但是TMD有用，并且只用了一遍循环。
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNode(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode low = null;
        int len = 0;
        boolean flag = false;
        while (fast != null) {
            if (flag) {
                low = low.next;
            }
            if (len == n) {
                flag = true;
                low = head;
            }
            len++;
            fast = fast.next;
        }
        if (low == null) {
            head.val = head.next.val;
            head.next = head.next.next;
        } else {
            if (low.next.next == null) {
                low.next = null;
            } else {
                low.next.val = low.next.next.val;
                low.next.next = low.next.next.next;
            }
        }
        return head;
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t = head;
        int len = 0;
        while (t != null) {
            len++;
            t = t.next;
        }
        if (len == 1) {
            return null;
        }
        int delNodeIndex = len - n;
        t = head;
        int curlen = 0;
        ListNode last = null;
        while (t != null) {
            if (curlen == delNodeIndex) {
                if (t.next != null) {//不是最后一个
                    t.val = t.next.val;
                    t.next = t.next.next;
                    break;
                } else {//是最后一个
                    last.next = null;
                    break;
                }
            }
            last = t;
            t = t.next;
            curlen++;
        }
        return head;
    }
}
