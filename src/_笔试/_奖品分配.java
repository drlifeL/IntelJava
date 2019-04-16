package _笔试;

import java.util.Arrays;
import java.util.Scanner;

/*
    思路：
        1.首先根据每个孩子的分数进行排序，然后可以得到一个升序的数组，child[0] = 1;
        然后如果右边的孩子的分数比自己高，那么右边孩子的奖励必然是上一个孩子的奖品数量+1
        循环排序好的孩子
            1.首先拿到当前孩子的左孩子和右孩子
            2.左边和右边孩子的奖品数量最低是一个， 用变量记录  lv 和rv
            3.判断，如果当前孩子比左边孩子的分数高，lv = 左边孩子的奖品数量+1  如果当前孩子比右边孩子的分数高 rv = 右边孩子的奖品数量+1,
            4.当前的孩子的实际奖品数量 = max(lv ,rv)


        2
        5
        7 3 2 5 3
        5
        5 6 3 4 8
        时间超出限制
        正常..数据10W  java的话用这个肯定不行、必须用简单dp
 */
public class _奖品分配 {
    private static class Node {
        public int score;
        public int num;
    }
    static int[]arr ;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int q = 0; q < T; q++) {
            int n = sc.nextInt();

            int []arr = new int[n];
            int []score = new int[n];
            int []child = new int[n];
            for (int i = 0; i < n; ++i) {
/*               Node node = new Node();
                node.score = sc.nextInt();
                arr[i] = node.score;
                node.num = i;
                nodes[i] = node;*/
                score[i] = sc.nextInt();
                arr[i] = score[i];//存储一个原数组，方便对其左右分数进行判断
                child[i] = i;
            }
            //           Node[] nodes = new Node[n];  节点做法
            //            sort(nodes);

//            int res[] = new int[n];
//            for (int i = 0; i < n; i++) {
//                Node curNode = nodes[i];
//                int left = (curNode.num + n - 1) % n, right = (curNode.num + 1) % n;
//                int lv = 1, rv = 1;//左边和右边小朋友的分数最低为1
//                if (curNode.score > arr[left]) lv = res[left] + 1;
//                if (curNode.score > arr[right]) rv = res[right] + 1;
//                res[curNode.num] = Math.max(lv, rv);
//            }


            sort(score,child);
            int res[] = new int[n];
            for (int i = 0; i < n; i++) {
                int left = (child[i] + n - 1) % n, right = (child[i] + 1) % n;
                int lv = 1, rv = 1;//左边和右边小朋友的分数最低为1
                if (score[i] > arr[left]) lv = res[left] + 1;
                if (score[i] > arr[right]) rv = res[right] + 1;
                res[child[i]] = Math.max(lv, rv);//结果千万不要存储错了！！！
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += res[i];
            }
            System.out.println(ans);
        }

    }
    public static void sort(int []s,int []c){
        for (int i = 0; i < s.length; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[i] > s[j]) {
                    int st = s[i];
                    int ct = c[i];
                    s[i] = s[j];
                    s[j] = st;
                    c[i] = c[j];
                    c[j] = ct;
                }
            }
        }


    }


    public static void sort(Node s[]) {
        for (int i = 0; i < s.length; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[i].score > s[j].score) {
                    Node t = s[i];
                    s[i] = s[j];
                    s[j] = t;
                }
            }
        }
    }

}
