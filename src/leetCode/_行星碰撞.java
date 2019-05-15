package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _行星碰撞 {
    public static void main(String[] args) {
        asteroidCollision(new int[]{-3, -2, -1, 1, 2});
    }

    /**
     * 思路：先找寻方向往左的数，也就是小于0的数
     *
     * @param asteroids
     * @return
     */
    public static int[] asteroidCollision(int[] asteroids) {

        boolean[] vis = new boolean[asteroids.length];
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] < 0) {
                jujde(vis, i, asteroids);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                list.add(asteroids[i]);
            }
        }
        int arr[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private static void jujde(boolean[] vis, int i, int[] t) {
        int curNum = Math.abs(t[i]);
        for (int j = i - 1; j >= 0; j--) {
            if (vis[j] || t[j] < 0) continue;//如果这个值在以前已经被抵消了，那么直接跳过
            if (curNum > t[j]) {//如果当前这个负数的绝对值比我前一个值大，那么前面一个值被抵消
                vis[j] = true;
            } else if (curNum < t[j]) {
                vis[i] = true;
                break;
            } else {
                vis[i] = true;
                vis[j] = true;
                break;
            }
        }
    }
}
