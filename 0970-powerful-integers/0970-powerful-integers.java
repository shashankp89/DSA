class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if(bound==1 || bound==0){
            return new ArrayList<>();
        }
 
        HashSet<Integer> s = new HashSet<>();
      

        for(int i=1;i<bound;i=i*x){
            for(int j=1;i+j<=bound;j=j*y){
                s.add(i+j);
                if(y==1){
                    break;
                }
            }
            if(x==1){
                break;
            }
        }

          return new ArrayList<>(s);
        
    }
}