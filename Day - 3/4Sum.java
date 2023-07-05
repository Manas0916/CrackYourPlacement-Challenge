class Solution 
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return ans;
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < n - 3; i++)
        {
            for(int j = i + 1; j < n - 2; j++)
            {
                long target2 = (long)target - (long)(nums[i] + nums[j]);
                int s = j + 1;
                int e = n - 1;
                
                while(s < e)
                {
                    long two_sum = (long)(nums[s] + nums[e]);
                    
                    if(two_sum < target2) s++;
                    
                    else if(two_sum > target2) e--;
                    
                    else if(two_sum == target2)
                    {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[s]);
                        quad.add(nums[e]);
                        ans.add(quad);
                        
                        while(s < e && nums[s] == quad.get(2)) s++;
                        
                        while(s < e && nums[e] == quad.get(3)) e--; 
                    }
                }
                while(j + 1 < n && nums[j + 1] == nums[j]) j++;
                
                while(i + 1 < n && nums[i] == nums[i + 1]) i++;
            }
        }
        return ans;
    }
}