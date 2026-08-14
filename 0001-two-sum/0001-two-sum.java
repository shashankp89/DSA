import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans={0,0};

        HashMap<Integer,Integer> map= new HashMap<>();
         
    
        for (int i=0;i<nums.length;i++){
            int val2=target-nums[i];

            if (map.containsKey(val2)){
                ans[0]=i;
                ans[1]=map.get(val2);
                break;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}