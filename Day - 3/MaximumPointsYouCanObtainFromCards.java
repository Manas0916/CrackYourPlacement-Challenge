class Solution 
{
    public int maxScore(int[] cardPoints, int k) 
    {
        int n = cardPoints.length;
        int left = 0;
        for(int i = 0; i < k; i++)
            left += cardPoints[i];
        
        int max = left, right = 0;
        for(int i = 0; i < k; i++)
        {
            left -= cardPoints[k - i - 1];
            right += cardPoints[n - i - 1];
            
            max = Math.max(max, left + right);
        }
        return max;
    }
}