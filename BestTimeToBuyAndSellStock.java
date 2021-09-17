/*
--- 121. Best Time To Buy And Sell Stock [EASY] ---

You are given an array "prices" where "prices[i]" is the price of a given stock on the "ith" day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different
day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction, if you cannot achieve any profit,
return 0.

--- EXAMPLES ---

- EX 1 -
Input:          prices = [7, 1, 5, 3, 6, 4]
Output:         5
Explanation:    Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5.
                Note that buying on day 2 and selling on day 1 is not allowed because you must
                buy before you sell.

- EX 2 -
Input:          prices = [7, 6, 4, 3, 1]
Output:         0
Explanation:    In this case, no transactions are done and the max profit = 0.
*/

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

    /*
     * Time Complexity: O(N) where N is the length of the prices array. We iterate
     * through it once.
     * 
     * Space Complexity: O(1).
     */

    public static int maxProfit(int[] prices) {
        // This holds the best profit so far and will be returned to the user.
        int bestProfit = 0;

        // This holds the minimum price so far. Initialize it to the first price.
        int minPriceSoFar = prices[0];
        // Iterate through the prices array.
        for (int i = 0; i < prices.length; i++) {
            // Update minimum price so far if nedded.
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
            // Calculate the current profit if we were to use minimum price so far and
            // current number.
            int currentProfit = prices[i] - minPriceSoFar;
            // If that current profit is the best profit, update best profit.
            bestProfit = Math.max(bestProfit, currentProfit);
        }

        // Return best profit.
        return bestProfit;
    }

    public static void main(String[] args) {
        // Sample arrays.
        int[] s1 = new int[] { 7, 1, 5, 3, 6, 4 };
        int[] s2 = new int[] { 7, 6, 4, 3, 1 };

        // Results.
        int r1 = maxProfit(s1);
        int r2 = maxProfit(s2);

        // Print results.
        System.out.println("The max profit you can make from the prices " + Arrays.toString(s1) + " is: " + r1);
        System.out.println("The max profit you can make from the prices " + Arrays.toString(s2) + " is: " + r2);
    }
}
