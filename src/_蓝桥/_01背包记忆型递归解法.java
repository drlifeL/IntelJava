package _蓝桥;

import java.util.Arrays;

/**
 * 记忆性递归，事半，功倍
 */
public class _01背包记忆型递归解法 {
    static int w[] = {2, 1, 3, 2};//重量表
    static int v[] = {3, 2, 4, 2};//价值表
    static int rec[][];//记忆型递归表，根据当前的重量和价值保存这个结果下的值
    static int n;

    public static void main(String[] args) {
        n = 4;//物品的数量
        int W = 5;//背包的容量
        int ww = W;//复制一份背包的容量
        dfs(0, ww, 0);//一般的递归求解,带返回值的递归是我的弱项
        System.out.println(dfsInt(0, ww));

        rec = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(rec[i], -1);//把数组中的值都初始化为-1
        }
        System.out.println(momenyDfs(0, ww));
    }


    private static void dfs(int i, int ww, int value) {
        if (ww == 0) {//背包的容量为0，
            System.out.println(value);
            return;
        }
        if (i == n) return;
        dfs(i + 1, ww, value);//不选当前物品
        if (ww >= w[i]) {
            dfs(i + 1, ww - w[i], value + v[i]);
        }
    }


    private static int dfsInt(int i, int ww) {
        if (i == n || ww <= 0) return 0;
        int v1 = dfsInt(i + 1, ww);//不选的情况下
        if (ww >= w[i]) {
            int v2 = v[i] + dfsInt(i + 1, ww - w[i]);//选择的情况下，要记住把选择的值带上，否则就是0
            return Math.max(v1, v2);
        }
        return v1;
    }

    /**
     * 记忆性递归，有重复的求解
     *
     * @return
     */
    private static int momenyDfs(int i, int ww) {
        if (ww <= 0 || i == n) return 0;

        //计算之前先查询
        if (rec[i][ww] >= 0) {//已经对这个求过解
            return rec[i][ww];//可以直接返回
        }
        int ans;
        int v1 = momenyDfs(i + 1, ww);
        if (ww >= w[i]) {
            ans = Math.max(v[i] + momenyDfs(i + 1, ww - w[i]), v1);
        } else {
            ans = v1;
        }
        //返回之前做记录
        rec[i][ww] = ans;
        return ans;
    }
}
