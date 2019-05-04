package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 测试用例比较操蛋，测试通过到36/45 当前的方法不能解决一个自环，和两个测试点连接一个点的测试用例，思路出现了错误....
 */
public class _尽量减少恶意软件的传播II {
    public static void main(String[] args) {
        //graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
        int graph[][] = {{1, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 0}, {0, 0, 0, 1, 1, 0}, {0, 0, 0, 0, 0, 1}};
        int graph1[][] = {{1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
        int initial[] = {5, 0};
        int initial2[] = {0, 8, 1};

        int graph2[][] = {{1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1}};
        int initial3[] = {6,4,0};
//        System.out.println(minMalwareSpread(graph2, initial3));
    }

    /**
     * initial是被感染的节点
     * 当前的思路，遍历所有可能被感染的节点：
     * 1.首先屏蔽掉该节点，然后再看假设删除该节点的情况下，有多少个节点被感染，
     *
     * @param graph
     * @param initial
     * @return

    public static int minMalwareSpread(int[][] graph, int[] initial) {
        int nodeNum = graph.length;//获取所有节点的数量
        boolean vis[] = new boolean[nodeNum];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < initial.length; i++) {
            vis[initial[i - 1]] = true;
            int v1 = bfs(graph, vis, initial[i]);//
            vis[initial[i - 1]] = false;
            vis[initial[i]] = true;
            int v2 = bfs(graph, vis, initial[i - 1]);
            vis[initial[i]] = false;
            if (v1 == v2) {
                v1 = Math.min(initial[i - 1], initial[i]);//提取当前脚下的那一个
                ans = Math.min(ans, v1);//如果相等，返回索引较小的
            } else {
                v1 = (v1 == Math.min(v1, v2)) ? initial[i - 1] : initial[i];
                ans = Math.min(ans, v1);
            }
        }
        return ans;
    } */
    /**
     * 重写该方法，假设当前节点被删除，然后遍历下一个被感染的节点，计算删除该节点后，被感染的软件的个数。
     * @param graph
     * @param initial
     */
    public static void minMalwareSpread(int [][]graph,int []initial){


    }


    private static int bfs(int[][] graph, boolean[] vis, int i) {
        boolean nVis[] = Arrays.copyOf(vis, vis.length);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        int ans = 0;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            for (int j = 0; j < graph[front].length; j++) {
                if (j == front || j == i) continue;//排除自环
                if (graph[front][j] == 1 && !nVis[j]) {
                    nVis[j] = true;
                    queue.add(j);
                    ans++;
                }
            }
        }
        return ans;
    }
}
