class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int lastPickedEnd = -1;  
        
        for (int i = 0; i < s.length(); i++) {
             
            if (i - k + 1 > lastPickedEnd && isPalindrome(s, i - k + 1, i)) {
                count++;
                lastPickedEnd = i;
                continue;  
            }
            
            if (i - k > lastPickedEnd && isPalindrome(s, i - k, i)) {
                count++;
                lastPickedEnd = i;
            }
        }
        
        return count;
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}