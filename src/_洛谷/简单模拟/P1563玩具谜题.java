package _洛谷.简单模拟;

import java.util.Scanner;

/**
 * 该方法还可以改进，
 *   其实移动的情况就两种，要么左，要么右，可以在这个基础上直接进行改动
 *   已经改动
 */
public class P1563玩具谜题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入的第一行包含两个正整数 n,m 表示玩具小人的个数和指令的条数。
        int n = sc.nextInt();
        int m = sc.nextInt();
        String []j = new String[n];//小人的职业
        int []c = new int[n];//小人的朝向 0 表示朝向圈内，1 表示朝向圈外
        //接下来 n 行，每行包含一个整数和一个字符串，以逆时针为顺序给出每个玩具小人的朝向和职业。其中 0 表示朝向圈内，1 表示朝向圈外
        c[0] = sc.nextInt();
        j[0] = sc.next();
        for (int i = n-1; i >=1 ; i--) {
            c[i] = sc.nextInt();
            j[i] = sc.next();
        }
        //接下来m行，其中第i行包含两个整数 ai  ,si 表示第i条指令,若ai=0,表示向左数si个人，若
        //ai=1,表示向右数si个人
        int flag = 0;
        for (int i = 0; i < m; i++) {
            int ai = sc.nextInt();
            int si = sc.nextInt();
//            if(ai==0){//向左数
//                if(c[flag]==0){//并且当前位置上的朝向是圈内
//                    flag = (flag+si)%n;//类似于循环队列（就是套用了循环队列公式）
//                }else{//朝向是圈外
//                    flag = (flag-si+n)%n;//这个公式才是精髓啊~！！！！左移
//                }
//            }else{
//                if(c[flag]==1){//并且当前位置上的朝向是圈内
//                    flag = (flag+si)%n;//类似于循环队列
//                }else{//朝向是圈外
//                    flag = (flag-si+n)%n;
//                }
//            }
            if(ai==0 && c[flag]==0 || ai==1 && c[flag]==1){//上面的代码可以直接精简到现在这样
                flag = (flag+si)%n;//向右（数组下标移动）
            }else{
                flag = (flag-si+n)%n;//向左（数组下标移动）
            }
        }
        System.out.println(j[flag]);

    }
}
