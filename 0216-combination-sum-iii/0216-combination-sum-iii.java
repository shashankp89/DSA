import java.util.ArrayList;
import java.util.List;

class Solution {

    public void temp(int k, int n, int digit, List<Integer> current, List<List<Integer>> ans) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        if (k == 0 || n < 0 || digit > 9) {
            return;
        }

        current.add(digit);
        temp(k - 1, n - digit, digit + 1, current, ans);
        current.remove(current.size() - 1);

        temp(k, n, digit + 1, current, ans);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        temp(k, n, 1, current, ans);
        
        return ans;
    }
}