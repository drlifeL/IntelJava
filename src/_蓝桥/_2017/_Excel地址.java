package _蓝桥._2017;

import java.util.Scanner;

public class _Excel地址 {
    static long []ans = new long[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long time  = System.currentTimeMillis();
        solve(l);
        long time2  = System.currentTimeMillis();
        System.out.println(time2-time);
        /*
          采用进制思想解决 ，将每次枚举出来的结果放在数组中，最后倒叙输出这个数组即可。
         */
        time  = System.currentTimeMillis();
        int cnt =0;
        while(l!=0){
            if(l%26==0){
                ans[cnt++]=26;
                l = l/26-1;
            }else {
                ans[cnt++] = l % 26;
                l /= 26;
            }
        }
        time2  = System.currentTimeMillis();
        System.out.println(time2-time);
        for (int i = cnt-1; i >=0 ; i--) {
            System.out.print((char)('A'+(ans[i]-1)));
        }
    }
    static void solve(long n){
        //这个方法是通过我们一位一位的进行枚举
        //但是因为在我们的定义中，余数不能为0，如果余数为0的时候，我们不好对数据进行处理，所以
        //当一个l 能够被整除的时候，我们就会把l的值在减去1。但是在结果的放置中，余数做为0.结果里面就作为z，就是最后一个字符
        //这里是模拟了我们的进位的，可以想象成翻牌子。
        for (long i = 1; i <=n ; i++) {
            ans[0]++;
            int tmp = 0;
            if(ans[0]==27){
                tmp = 1;//表示进位
                ans[0] = 1;//回到1
                //进位往后作用
                int t = 1;//下标
                while(tmp>0 &&t<100){
                    ans[t]+=tmp;
                    if(ans[t]==27){
                        ans[t]= 1;
                        tmp = 1;
                    }else{
                        tmp = 0;
                    }
                    t++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <100; i++) {
            if(ans[i]==0) break;
            sb.insert(0,(char)('A'+(ans[i]-1)));
        }
        System.out.println(sb.toString());
    }
}
