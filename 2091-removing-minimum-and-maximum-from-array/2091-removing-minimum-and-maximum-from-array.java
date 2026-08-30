class Solution {
    public int minimumDeletions(int[] a) {
        
        int n = a.length;
        int id1 = 0;
        int id2 = 0;
        
        for(int i = 1; i < n; i = i + 1){
            if(a[i] < a[id1]){
                id1 = i;
            }
            if(a[i] > a[id2]){
                id2 = i;
            }
        }
        
        int lf = id1;
        int rt = id2;
        
        if(id1 > id2){
            lf = id2;
            rt = id1;
        }
        
        int p1 = rt + 1;
        int p2 = n - lf;
        int p3 = (lf + 1) + (n - rt);
        
        int ans = p1;
        
        if(p2 < ans){
            ans = p2;
        }
        
        if(p3 < ans){
            ans = p3;
        }
        
        return ans;
    }
}