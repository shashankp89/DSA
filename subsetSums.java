/*Given an array nums of n integers. Return array of sum of all subsets of the array nums.



Output can be returned in any order.


Example 1

Input : nums = [2, 3]

Output : [0, 2, 3, 5]

Explanation :

When no elements is taken then Sum = 0.

When only 2 is taken then Sum = 2.

When only 3 is taken then Sum = 3.

When element 2 and 3 are taken then sum = 2+3 = 5.

Example 2

Input : nums = [5, 2, 1]

Output : [0, 1, 2, 3, 5, 6, 7, 8]

Explanation :

When no elements is taken then Sum = 0.

When only 5 is taken then Sum = 5.

When only 2 is taken then Sum = 2.

When only 1 is taken then Sum = 1.

When element 2 and 1 are taken then sum = 2+1 = 3.

 
Constraints

1 <= n <= 15
0 <= nums[i] <= 10^4*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void temp(List<Integer> ans, int [] sum, int[] nums, int idx){
        if(idx==nums.length){
            ans.add(sum[0]);
            return;
        }
        temp(ans,sum,nums,idx+1);

        sum[0]+=nums[idx];
        temp(ans,sum,nums,idx+1);
        sum[0]-=nums[idx];

        return;
    }
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans= new ArrayList<>();

        int [] sum = new int[1];

        temp(ans,sum,nums,0);

        return ans;


    }
}