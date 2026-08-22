class Solution {
    public boolean checkDivisibility(int x) {

        int n=x;

        int sum=0;
        int prod=1;

        while(n>0){
            int dig = n%10;

            sum+=dig;
            prod*=dig;

            n=n/10;
        }

        if (x%(sum+prod)==0){
            return true;
        }else{
            return false;
        }
        
    }
}