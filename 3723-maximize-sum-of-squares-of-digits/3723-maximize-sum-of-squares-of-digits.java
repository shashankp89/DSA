class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if ((long) num * 9 < sum) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int nines = sum / 9;
        int rem = sum % 9;
        
        for (int i = 0; i < nines; i++) {
            sb.append('9');
        }
        
        if (nines < num) {
            if (rem > 0) {
                sb.append(rem);
            }
            int zeros = num - nines - (rem > 0 ? 1 : 0);
            for (int i = 0; i < zeros; i++) {
                sb.append('0');
            }
        }
        
        return sb.toString();
    }
}