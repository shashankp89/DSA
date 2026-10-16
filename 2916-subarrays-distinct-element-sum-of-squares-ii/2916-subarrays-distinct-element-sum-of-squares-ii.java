import java.util.HashMap;
import java.util.Map;

class Solution {
    private long[] sumSq;
    private long[] sum;
    private long[] lazy;
    private final int mod = 1000000007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sumSq = new long[4 * n];
        sum = new long[4 * n];
        lazy = new long[4 * n];
        
        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSum = 0;
        
        for (int i = 0; i < n; i++) {
            int left = lastSeen.getOrDefault(nums[i], -1) + 1;
            
            update(1, 0, n - 1, left, i, 1);
            totalSum = (totalSum + sumSq[1]) % mod;
            
            lastSeen.put(nums[i], i);
        }
        
        return (int) totalSum;
    }

    private void apply(int node, int l, int r, long val) {
        long len = r - l + 1;
        sumSq[node] = (sumSq[node] + 2 * val * sum[node] + val * val % mod * len) % mod;
        sum[node] = (sum[node] + val * len) % mod;
        lazy[node] = (lazy[node] + val) % mod;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = l + (r - l) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = l + (r - l) / 2;
        update(2 * node, l, mid, ql, qr, val);
        update(2 * node + 1, mid + 1, r, ql, qr, val);
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % mod;
        sum[node] = (sum[2 * node] + sum[2 * node + 1]) % mod;
    }
}