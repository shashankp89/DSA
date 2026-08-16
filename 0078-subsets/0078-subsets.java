class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n;
        
        for(int i=0; i<totalSubsets; i++){
            List<Integer> sub = new ArrayList<>();
            
            for(int j=0; j<n; j++){
                if(((i >> j) & 1) == 1){
                    sub.add(nums[j]);
                }
            }
            
            ans.add(sub);
        }
        
        return ans;
    }
}