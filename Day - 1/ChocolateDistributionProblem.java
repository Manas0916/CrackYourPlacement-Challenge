class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        
        int i = 0, j = m - 1;
        int min = Integer.MAX_VALUE;
        while(j < n)
        {
            min = Math.min(min, a.get(j) - a.get(i));
            i++;
            j++;
        }
        return min;
    }
}