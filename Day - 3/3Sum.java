class Solution 
{
    public List<List<Integer>> threeSum(int[] num) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(num);
        int n = num.length;
        
        for(int i = 0; i < n - 2; i++)
        {
            if(i == 0 || num[i] != num[i - 1])
            {
                int l = i + 1, r = n - 1;
                while(l < r)
                {
                    if(num[l] + num[r] == -num[i]) 
                    {
                        ans.add(Arrays.asList(num[i], num[l], num[r]));

                        while (l < r && num[l] == num[l + 1]) l++;

                        while (l < r && num[r] == num[r - 1]) r--;

                        l++; r--;
                    }

                    else if(num[l] + num[r] < -num[i]) l++;

                    else  r--;
                }
            }  
        }
        return ans;
    }
}