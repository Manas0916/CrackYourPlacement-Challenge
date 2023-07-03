class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        int n = nums.length;
        int i = 0, j = 1;
        
        while(j < n)
        {
            if(nums[i] == 0 && nums[j] != 0)
            {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
            }
            else if(nums[i] != 0 && nums[j] == 0)
                i++;
            
            else if(nums[i] != 0 && nums[j] != 0)
                i++;
            j++; 
        }
    }
}