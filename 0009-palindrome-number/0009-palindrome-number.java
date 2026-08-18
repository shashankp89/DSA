class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        int digits=0;
        int num=x;
        while(num>0){
            num=num/10;
            digits++;
        }
        num=0;
        for(int i=1;i<=digits;i++){
            num = num + ((x % (int)Math.pow(10, i)) / (int)Math.pow(10, i - 1)) * (int)Math.pow(10, digits - i);

        }
        if(num==x){
            return true;
        }else{
            return false;
        }
    }
}