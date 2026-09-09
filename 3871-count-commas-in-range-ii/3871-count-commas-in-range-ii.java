class Solution {
    public long countCommas(long n) {

        long order=1000;
        long comma=0;

        while(n>=order){
            comma=comma+(n-order+1);
            order=order*1000;
        }
        return comma;
    }
}