package _笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Z国的货币系统包含面值1元、4元、16元、64元共计四种硬币，以及面值1024元的纸币。
 *
 * 现在小Y使用1024元的纸币购买了一件价值为N的商品，请问最少他会收到多少硬币。
 *
 * 输入格式
 * 共一行，包含整数N。
 *
 * 输出格式
 * 共一行，包含一个数，表示最少收到的硬币数。
 */
public class _找零 {
    static int []val = {1,4,16,64};
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1024-sc.nextInt();
        for (int i = 3; i >=0 && n!=0 ; i--) {
            ans += n/val[i];
            n%=val[i];
        }
        System.out.println(ans);



    }
}
