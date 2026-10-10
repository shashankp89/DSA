class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] count = new int[100001];
        long totalDiff = 0;
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            count[diff]++;
            totalDiff += diff;
        }
        
        long k = (long) k1 + k2;
        if (totalDiff <= k) return 0;
        
        for (int i = 100000; i > 0 && k > 0; i--) {
            if (count[i] > 0) {
                long reduce = Math.min((long) count[i], k);
                count[i] -= (int) reduce;
                count[i - 1] += (int) reduce;
                k -= reduce;
            }
        }
        
        long ans = 0;
        for (int i = 1; i <= 100000; i++) {
            if (count[i] > 0) {
                ans += (long) i * i * count[i];
            }
        }
        return ans;
    }
}