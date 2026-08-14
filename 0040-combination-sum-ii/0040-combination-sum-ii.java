import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public void temp(int[] candidates, int target, int idx, List<Integer> current, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0 || idx == candidates.length) {
            return;
        }

        current.add(candidates[idx]);
        temp(candidates, target - candidates[idx], idx + 1, current, ans);
        current.remove(current.size() - 1);

        int nextIdx = idx + 1;
        while (nextIdx < candidates.length && candidates[nextIdx] == candidates[idx]) {
            nextIdx++;
        }
        
        temp(candidates, target, nextIdx, current, ans);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        temp(candidates, target, 0, current, ans);
        
        return ans;
    }
}