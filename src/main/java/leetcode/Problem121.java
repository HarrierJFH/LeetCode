package leetcode;

public class Problem121 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int min = prices[0], require = min, profit = 0, price;
        for (int i = 1; i < length; i++) {
            price = prices[i];
            if (price > require) {
                profit += price - require;
                require = price;
            } else if (price < min) {
                require -= min - price;
                min = price;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Problem121 problem121 = new Problem121();
        System.out.println(problem121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
