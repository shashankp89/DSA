class Solution {
    public double calc(double x, long n){

        if(n==0){
            return (double)1;
        }

        
        
        if(n%2==0){
            double ans=calc(x,n/2);
            return  ans*ans;
        }else{
            double ans=calc(x,(n/2));
            return x*ans*ans;
        }

    }
    public double myPow(double x, int n) {

        if(n<0){
            return (double)1/calc(x,-n);
        }else{
            return calc(x,n);
        }
        
    }
}