package _洛谷;
//给定一个部分有序的数组，求数组中最长的递增子序列
public class 最长连续递增子序列 {
    public static void main(String[] args) {
        int []a = new int[]{1,9,2,5,7,3,4,6,8,0};
        int len = 0;
        int m = 0;
        for (int i = 0; i <a.length-1; i++) {
            if(a[i]>a[i+1]){
                len =Math.max(len,i+1-m);
                m = i+1;
            }
        }
        System.out.println(len);

    }
}
