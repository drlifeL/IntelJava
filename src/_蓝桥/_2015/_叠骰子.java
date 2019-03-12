package _蓝桥._2015;

import java.util.Scanner;

/**
 * 递归的解法，会严重超时
 * 看累骰子，
 */
public class _叠骰子 {
    static int MOD = 1000000007;
    static int n,m;
    static int op[] = new int[7];
    static boolean conflict[][] = new boolean[7][7];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            conflict[x][y] = true;
            conflict[y][x] = true;
        }
        long ans  = 0;
        init();
        for (int up = 1; up <=6 ; up++) {
            ans = (ans+4*f(up,n-1))%MOD;
        }
        System.out.println(ans);

    }
    static void init(){
        op[1] = 4;
        op[4] = 1;
        op[2] = 5;
        op[5] = 2;
        op[3] = 6;
        op[6] = 3;
    }

    /**
     * 上一层定好了朝上的数字为up，的情况下垒好i个骰子的方案数
     * @param up
     * @param i
     * @return
     */
    private static long f(int up, int i) {
        if(i==0)
            return 4;
        long ans = 0;
        for (int upp = 1; upp <=6 ; upp++) {
            if(conflict[op[up]][upp]){
                continue;
            }
            ans=(ans+f(upp,i-1))%MOD;
        }

        return ans;
    }
}
