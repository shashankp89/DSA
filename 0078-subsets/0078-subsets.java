class Solution {
    public void add(List<Integer> temp, List<List<Integer>> ans, int[] nums, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        add(temp, ans, nums, idx+1);

        temp.add(nums[idx]);
        add(temp,ans,nums,idx+1);
        temp.remove(temp.size() - 1);

        return;

    }

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int idx = 0;

        add(temp, ans, nums, idx);

        return ans;

    }
}