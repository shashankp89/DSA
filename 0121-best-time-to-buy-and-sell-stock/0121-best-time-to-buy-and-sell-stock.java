class Solution {
    public int maxProfit(int[] prices) {

        int min = 0;
        int maxProf = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < prices[min]) {
                min = i;
            } else {
                int currProf = prices[i] - prices[min];

                if (currProf > maxProf) {

                    maxProf = currProf;
                }
            }

        }

        return maxProf;

    }
}