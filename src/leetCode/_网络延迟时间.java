package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _网络延迟时间 {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int k = 4;
        //out =10
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        int time = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(K);

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int i = 0; i < times[curNode].length; i++) {

            }


        }

        return -1;
    }
}
