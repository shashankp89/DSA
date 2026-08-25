class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],1);
        }
        int i=k;
        while(true){
            if(!map.containsKey(i)){
                return i;
            }
            i=i+k;
        }
    }
}