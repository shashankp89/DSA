class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> li = new ArrayList<>();
        int n = security.length;
        int[] desc = new int[n];
        int[] aesc = new int[n];

        for(int i = 1; i < n ; i++){
            if(security[i] <= security[i-1])desc[i] = desc[i-1] + 1;
        }
        for(int i = n-2; i >= 0 ; i--){
            if(security[i] <= security[i+1]) aesc[i] = aesc[i+1] + 1;
        }
        for(int i = time ; i < n-time ; i++){
            if(aesc[i] >= time && desc[i] >= time) li.add(i);
        }

        return li;
    }
}