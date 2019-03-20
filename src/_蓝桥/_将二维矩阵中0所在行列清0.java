package _蓝桥;

import java.util.HashMap;
import java.util.Map;

public class _将二维矩阵中0所在行列清0 {
    static int a[][] = {{1,2,3,4},{5,6,6,8},{9,0,1,2},{13,14,15,16}};
    static rl[] r = new rl[10];
    public static void main(String[] args) {
        print();
        find();
        recover();
        System.out.println("---------------------");
        print();
    }

    public static void print(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <4 ; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
    private static void recover() {
        int  i = 0;
        while(r[i]!=null){
            for (int j = 0; j < 4; j++) {
                a[r[i].i][j] = 0;
                a[j][r[i].j] = 0;
            }
            i++;
        }
    }

    private static void find() {
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(a[i][j]==0){
                  r[k++] = new rl(i,j);
                }
            }
        }

    }
}
class rl{
    int i;
    int j;
    public rl(int i,int j){
        this.i = i;
        this.j = j;
    }

}
