package leetCode;

public class _递归实现1addN {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(getSum(5000));
    }

    public static int getSum(int i) {
//        if (i == 1) {
//            return 1;
//        }
//        return i + getSum(i - 1);
        return i == 1 ? 1 : i + getSum(i - 1);
    }


}
