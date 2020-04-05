package leetcode;

public class Problem122 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int profit = 0;
        int last = prices[0];
        int oriPrice = 0;
        boolean stockHolding = false;
        for (int i = 1; i < length; i++) {
            int price = prices[i];
            if (price < last && stockHolding) {
                profit += last - oriPrice;
                stockHolding = false;
            } else if (price > last && !stockHolding) {
                oriPrice = last;
                stockHolding = true;
            }
            last = price;
        }
        if (stockHolding) {
            profit += last - oriPrice;
        }
        return profit;
    }

}
