package leetCode;

public class _买卖股票的最佳时机 {
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if ((prices[i] < prices[j] && prices[j] - prices[i] > ans)) {
                    ans = prices[j] - prices[i];
                }
            }
        }
        return ans;
    }
}
