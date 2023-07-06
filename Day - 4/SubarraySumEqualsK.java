class Solution 
{
    public int subarraySum(int[] nums, int k) 
    {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int presum = 0, cut = 0;
        for(int i = 0; i < n; i++)
        {
            presum += nums[i];
            int remove = presum - k;
            if(map.containsKey(remove))
                cut += map.get(remove);
            
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return cut;
    }
}