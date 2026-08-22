class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int ans=0;
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            if(map.containsKey(sum-k)){
                int val=map.get(sum-k);
                ans+=val;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
