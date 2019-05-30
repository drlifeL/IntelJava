package leetCode;
//1 10 100 1000
//1 2  10+(100%10-2)  10*18-1+100
public class _数字1的个数 {
    public static void main(String[] args) {
        System.out.println("co = " + countDigitOne(100000));
    }

    public static int countDigitOne(int n) {
        int sum = 0;
        for (int i = n; i > 0; i--) {
            if (Integer.toString(i).contains("1")) {
                System.out.println("i = " + i);
                sum += Integer.toString(i).length() - Integer.toString(i).replace("1", "").length();
            }
        }
//        if(n < 10){
//            return 1;
//        }
//        int size = Integer.toString(n).length();
//        int[] list = new int[Integer.toString(n).length()];
//        for (int i = 1;i <= size;i++){
//            list[size-i] = n % 10;
//            n = n / 10;
//        }
//        for (int i = 0; i < size; i++) {
//            System.out.println("list = " + list[i]);
//        }
//        int ji = 0;
//        for (int i = 0;i < size;i++){
//            if(i == size-1){
//
//            }
//            sum =(sum * 10)+1;
//        }
        return sum;
    }

    public void get(int n) {

    }

}
