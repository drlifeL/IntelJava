package _洛谷.递归;

import java.util.Arrays;
import java.util.Scanner;

/**
 * dfs+判断素数
 * 从n中选择k个数相加
 *
 */
public class p1036选数思路 {
    static int[] a;
    static int ans = 0;
    static boolean[] b;
    static int K;

    /**
     * 此解不能通过.....
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        K = sc.nextInt();
        a = new int[n];
        b = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        dfs( 0, 0, 0);
        System.out.println(ans);
    }

    /**
     * 对于这个问题需要自己抽象，对于一个选择，我可以选他，也可以不选他，选他的时候j+1，sum+=[j+1] 不选的时候，就把指针往下面移动就可以了
     *
     * @param i   下标
     * @param j   步骤
     * @param sum 总数,只用来判断素数
     */
    private static void dfs( int i, int j, int sum) {
/*        if (j == K) {
            ans++;
            System.out.println(Arrays.toString(b));
            return;
        }
        if (i >= a.length || j > K || b[i]) {//如果已经到了最后一个数字，或者这个数被访问过,或者已经够了/  这里注意：必须把判断满足条件放在前面，否则答案一定会出现错误，因为每次i都在加，
            //即使你的j已经满足条件了，所以说这里是个需要注意的点，天坑！
            return;
        }
        b[i] = true;
        dfs(a, i + 1, j + 1, sum += a[i]);//选择这个数
        dfs(a, i + 1, j, sum);//不选这个数,因为上面已经选了，要把这个数减去，但是这里有个疑问，就是i这个数已经递增了，会不会影响那？不会影响，只是感觉在标记上面存在错误，不知为何，这是疑问点！
        b[i] = false;//回溯*/



    if(j==K && isSus(sum)){
        System.out.println(sum);
        ans++;
        return;
    }
    if(i>=a.length) return;
    if(!b[i]){
        b[i] = true;
        dfs(i+1,j+1,sum+=a[i]);
        dfs(i+1,j,sum-=a[i]);
        b[i] = false;
    }
    return;
    }

    private static boolean isSus(int sum) {

        for (int i = 2; i <Math.sqrt(sum) ; i++) {
            if(sum%i==0){
                return false;
            }
        }
        return true;
    }

}
