package _蓝桥._2016;

public class 煤球数 {
    public static void main(String[] args) {
        long cout =1;//总的层数
        int i = 2;//增量
        long cur = 1;//上一层
        for (int j = 2; j <=100 ; j++,i++) {
            long c = cur+i;
            cout+=c;
            cur = c;
        }
        System.out.println(cout);
    }
}
