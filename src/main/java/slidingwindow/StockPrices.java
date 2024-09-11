package slidingwindow;

import java.util.Arrays;

public class StockPrices {


    //
    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int min = prices[0];

        for (int i = 0; i < prices.length; i++) {

            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(prices[i], min);
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = {10,1,5,6,7,1};

        System.out.printf("Max profit for arr: %s is: %d", Arrays.toString(prices) ,maxProfit(prices));
    }
}
