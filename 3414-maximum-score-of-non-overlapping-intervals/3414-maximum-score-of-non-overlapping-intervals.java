import java.util.*;

class Solution {
     
    class Result {
        long weight;
        List<Integer> indices;

        Result(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> input) {
        int n = input.size();
         
        int[][] intervals = new int[n][4];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = input.get(i).get(0); 
            intervals[i][1] = input.get(i).get(1); 
            intervals[i][2] = input.get(i).get(2); 
            intervals[i][3] = i;                   
        }
         
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
 
        Result[][] memo = new Result[n][5];
        
        Result res = dfs(intervals, memo, 0, 4);
         
        int[] ans = new int[res.indices.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.indices.get(i);
        }
        return ans;
    }
    
    private Result dfs(int[][] intervals, Result[][] memo, int i, int k) {
         
        if (i == intervals.length || k == 0) {
            return new Result(0, new ArrayList<>());
        }
        if (memo[i][k] != null) {
            return memo[i][k];
        }
         
        Result skip = dfs(intervals, memo, i + 1, k);
         
        int nextIdx = binarySearch(intervals, intervals[i][1]);
        Result nextRes = dfs(intervals, memo, nextIdx, k - 1);
         
        List<Integer> pickedIndices = new ArrayList<>(nextRes.indices);
        pickedIndices.add(intervals[i][3]);
        
        Collections.sort(pickedIndices); 
        
        Result pick = new Result((long) intervals[i][2] + nextRes.weight, pickedIndices);
         
        if (pick.weight > skip.weight) {
            memo[i][k] = pick;
        } else if (pick.weight < skip.weight) {
            memo[i][k] = skip;
        } else {
            
            if (compareLists(pick.indices, skip.indices) < 0) {
                memo[i][k] = pick;
            } else {
                memo[i][k] = skip;
            }
        }
        
        return memo[i][k];
    }
     
    private int binarySearch(int[][] intervals, int targetRight) {
        int left = 0, right = intervals.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] > targetRight) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
     
    private int compareLists(List<Integer> a, List<Integer> b) {
        int minLen = Math.min(a.size(), b.size());
        for (int i = 0; i < minLen; i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if (cmp != 0) return cmp;
        }
        return Integer.compare(a.size(), b.size());
    }
}