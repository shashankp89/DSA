class Solution {
    public long calc(long x, long n) {
        if (n == 0) {
            return 1;
        }
        
        long ans = calc(x, n / 2);
        long res = (ans * ans) % 1000000007;
        
        if (n % 2 == 0) {
            return res;
        } else {
            return (x * res) % 1000000007;
        }
    }

    public int countGoodNumbers(long n) {
        if (n == 1) {
            return 5;
        }

        if (n % 2 == 0) {
            long ans = (calc(5, n / 2) * calc(4, n / 2)) % 1000000007;
            return (int) ans;
        } else {
            long ans = (calc(5, (n / 2) + 1) * calc(4, n / 2)) % 1000000007;
            return (int) ans;
        }
    }
}