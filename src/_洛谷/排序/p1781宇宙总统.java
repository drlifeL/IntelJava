package _洛谷.排序;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1781宇宙总统 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();//直接使用位数排除
        String []arr = new String[n];
        int l = 0;
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.next();
            l = Math.max(l,arr[i].length());//记录最大的位数
        }
        for (int i = 0; i <n ; i++) {
            if(arr[i].length()<l){//如果当前数的位数没有最大位数大，直接排除
                continue;
            }
            list.add(arr[i]);
        }

        /**
         * 核心：
         *     满足的都是同样长度位数的数字
         *     1.只要list的长度不等于1就循环
         *     从1开始
         *     传递到jujde参数
         *
         *     jujde();将所有的字符串转换为字符数组，用一个循环进行对比，返回较小的某一个数，移除
         *
         */
        while(list.size()!=1){
            for (int j = 1; j <list.size() ; j++) {
                    list.remove(judge(list.get(0),list.get(j)));
            }
        }

        for (int i = 0; i <n ; i++) {
            if(arr[i].equals(list.get(0))){
                System.out.println(i+1);
                System.out.println(list.get(0));
                break;
            }
        }
    }

    private static String judge(String s, String s1) {
        char []a = s.toCharArray();
        char []b = s1.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if(a[i]>b[i]){//如果a>b返回b
                return s1;
            }else if(b[i]>a[i]){//如果a<b返回a
                return s;
            }
        }
        return s;//否则就返回任意一个，因为他们一样大，例题中不可能
    }
}
