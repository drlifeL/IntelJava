package _洛谷;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1540机器翻译 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();//内存数量，就是队列
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        int ans  = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if(list.contains(arr[i])) continue;
            if(m == list.size() && !list.contains(arr[i])){
                list.remove(0);
                list.add(arr[i]);
                ans++;
            }else {
                list.add(arr[i]);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
