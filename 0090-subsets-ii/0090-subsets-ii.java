class Solution {
    public void helper(HashSet<List<Integer>> set, List<Integer> temp, int[] nums, int idx) {
        if (idx == nums.length) {
             
            set.add(new ArrayList<>(temp)); 
            return;
        }
        
         
        helper(set, temp, nums, idx + 1);

        
        temp.add(nums[idx]);
        helper(set, temp, nums, idx + 1);
        temp.remove(temp.size() - 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums); 
        
         
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();

        helper(set, temp, nums, 0);

        return new ArrayList<>(set);
    }
}



/* Approach 2 (more optimal, but didn't click while solving)

class Solution {
    public void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        // Add the current subset (snapshot) to the answer
        ans.add(new ArrayList<>(temp));
        
        for (int i = start; i < nums.length; i++) {
            // OPTIMIZATION: If this is a duplicate element at the same depth, skip it
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Pick
            temp.add(nums[i]);
            // Explore
            helper(ans, temp, nums, i + 1);
            // Backtrack
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Mandatory for this logic to work
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
}*/