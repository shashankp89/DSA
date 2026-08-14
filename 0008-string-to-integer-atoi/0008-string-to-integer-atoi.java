class Solution {
    int num = 0;
    int n = 0;
    int neg = 0;
    boolean started = false;

    public boolean isdigit(char x) {
        return x >= '0' && x <= '9';
    }

    public int myAtoi(String s) {
        num = 0;
        neg = 0;
        started = false;
        n = s.length();

        check(s, 0);

        if (neg == 1) {
            return -num;
        }
        return num;
    }

    private void check(String s, int i) {
        if (i == n) {
            return;
        }

        char c = s.charAt(i);

        if (c == ' ' && !started) {
            check(s, i + 1);
            return;
        } else if (c == '-' && !started) {
            neg = 1;
            started = true;
            check(s, i + 1);
            return;
        } else if (c == '+' && !started) {
            started = true;
            check(s, i + 1);
            return;
        } else if (isdigit(c)) {
            started = true;
            int digit = c - '0';

            if (num > 214748364 || (num == 214748364 && digit > 7)) {
                if (neg == 0) {
                    num = 2147483647;
                    return;
                } else {
                    num = -2147483648;
                    neg = 0;
                    return;
                }
            }
            num = num * 10 + digit;
            check(s, i + 1);
            return;
        } else {
            return;
        }
    }
}