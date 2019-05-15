package leetCode;

public class _除数博弈 {
    public static void main(String[] args) {

        for (int i = 1; i <= 1000; i++) {
            System.out.println(divisorGame(i));
        }


    }

    /**
     * 该题的策略就在于，选择最大能整除的奇数。
     * 太坑了！！！！！
     * 但是，还有更坑的，这个可以用一句代码解决，
     *  return n%2==0  ,
     *  该题完全是一个脑筋急转弯，能够让自己获胜的最优策略就是让对面拿到奇数，
     *  摘抄自网络：
     *      当爱丽丝遇到的N是偶数时，她总可以选到一个N的奇数因子x（比如1），
     *      使得传给对方的N-x为奇数，而对方遇到奇数N，只能选择N的奇数因子x，
     *      又会将偶数的N-x传回给爱丽丝，最终爱丽丝会遇到N=2，然后获胜。
     *      当爱丽丝遇到的N是奇数时，只能传给对方偶数或无法操作(N=1)，无法获胜。
     *
     *
     * @param N
     * @return
     */
    public static boolean divisorGame(int N) {
        boolean alie = true;
        boolean bobo = false;
        while (true) {
            if (N == 1) break;
            alie = !alie;
            N -= max(N);
        }
        return !alie;
    }

    public static int max(int n) {
        if (n <= 3) return 1;
        int i = n - 1;
        for (i = n - 1; i > 0 && n % i != 0 && i % 2 == 0; i--) {
        }
        return i;
    }

}
