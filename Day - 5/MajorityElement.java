class Solution 
{
    public int majorityElement(int[] nums) 
    {
        int count = 0, cand = 0;
        for(int el: nums)
        {
            if(count == 0)
                cand = el;
            
            if(el == cand)
                count ++;
            
            else
                count --;
        }
        return cand;
    }
}