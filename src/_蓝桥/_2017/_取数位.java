package _蓝桥._2017;

public class _取数位 {
        static int len(int x){
            if(x<10) return 1;
            return len(x/10)+1;
        }

        // 取x的第k位数字
        static int f(int x, int k){
            if(len(x)-k==0) return x%10;
//            return ______________________;  //填空
            return f(x/10,k);
        }

        public static void main(String[] args)
        {
            int x = 1123435789;
            //System.out.println(len(x));
            System.out.println(f(x,10));
        }

}
