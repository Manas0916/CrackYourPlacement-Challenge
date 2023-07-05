class Solution 
{
    Integer dp[][];
    int n;
    public int maxProfit(int[] prices) 
    {
        n = prices.length;
        dp = new Integer[n][2];
        return solve(prices, 0, 0);
    }
    int solve(int[] prices, int i, int buy)
    {
        if(i == n) return 0;
        if(dp[i][buy] != null) return dp[i][buy];
        
        if(buy == 0)
            return dp[i][buy]= Math.max((-prices[i] + solve(prices, i + 1, 1)), solve(prices, i + 1, 0));
        
        else
            return dp[i][buy] = Math.max((prices[i] + solve(prices, i + 1, 0)), solve(prices, i + 1, 1));
    }
}