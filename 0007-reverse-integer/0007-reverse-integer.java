class Solution {
    public int reverse(int x) {

        long rev = 0;
        int temp = x;

        if (x < 0) {
            temp = -x;
        }

        while (temp > 0) {
            int digit = temp % 10;
            temp = temp / 10;

            long tmp = (long) rev * 10 + digit;  
            if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) {
                return 0;  
            }
            rev = tmp;  
            
        }

        int count = 0;
        if (x < 0) {
            return -(int)rev;
        }
        return (int)rev;

    }
}