class Solution 
{
    public int reversePairs(int[] nums) 
    {
        return mergeSort(nums, 0, nums.length - 1);
    }
    int mergeSort(int[] nums, int low, int high)
    {
        if(low >= high) return 0;
        
        int m = (low + high) / 2;
        int inv = mergeSort(nums, low, m);
        inv += mergeSort(nums, m + 1, high);
        inv += merge(nums, low, m , high);
        
        return inv;
    }
    int merge(int[] nums, int l, int m, int h)
    {
        int cnt = 0;
        int j = m + 1;  // keeping j at the starting position of right half of array
        for(int i = l; i <= m; i++)
        {
            while(j <= h && nums[i] > 2 * (long) nums[j]) j++;
            
            cnt += (j - (m + 1));
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int left = l, right = m + 1;
        while(left <= m && right <= h)
        {
            if(nums[left] <= nums[right])
                temp.add(nums[left++]);
            else
                temp.add(nums[right++]);
        }
        while(left <= m)
            temp.add(nums[left++]);
        
        while(right <= h)
            temp.add(nums[right++]);
        
        for(int i = l; i <= h; i++)
            nums[i] = temp.get(i - l);
        
        return cnt;
    }
}