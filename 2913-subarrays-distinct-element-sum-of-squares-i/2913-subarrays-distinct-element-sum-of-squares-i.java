import java.util.*;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int totalSum = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Set<Integer> distinctElements = new HashSet<>();
                for (int k = i; k <= j; k++) {
                    distinctElements.add(nums.get(k));
                }
                int count = distinctElements.size();
                totalSum += count * count;
            }
        }
        
        return totalSum;
    }
}