package _洛谷;

import java.util.Scanner;

public class p1067多项式输出 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n+1];
        for (int i = 0; i <=n ; i++) {
            arr[i] = sc.nextInt();
        }
        String str = arr[0]+"x^"+n--;
        for (int i = 1; i <arr.length -1; i++,n--) {
            if(arr[i]==0)continue;
            if(arr[i]<0&& i!=0){
                if(arr[i]==-1)
                    str+="-x^"+n;
                else
                    str+=arr[i]+"x^"+n;
            }else if(arr[i]==1){
                str+="+x^"+n;
            }else{
                str+="+"+arr[i]+"^"+n;
            }
        }
        if(arr[arr.length-1]<0){
            System.out.println(str+=arr[arr.length-1]);
        }else
            System.out.println(str+="+"+arr[arr.length-1]);
    }
}
