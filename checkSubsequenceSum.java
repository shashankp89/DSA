/*Given an array nums and an integer k. R﻿eturn true if there exist subsequences such that the sum of all elements in subsequences is equal to k else false.


Example 1

Input : nums = [1, 2, 3, 4, 5] , k = 8

Output : Yes

Explanation : The subsequences like [1, 2, 5] , [1, 3, 4] , [3, 5] sum up to 8.

Example 2

Input : nums = [4, 3, 9, 2] , k = 10

Output : No

Explanation : No subsequence can sum up to 10.

 
Constraints

1 <= nums.length <= 20
1 <= nums[i] <= 100
1 <= k <= 2000 */

class Solution {

    public boolean temp(int[] nums, int k, int idx) {
        if (k == 0) {
            return true;
        }
        if (idx == nums.length || k < 0) {
            return false;
        }

        if (temp(nums, k - nums[idx], idx + 1)) {
            return true;
        }

        return temp(nums, k, idx + 1);
    }

    public boolean checkSubsequenceSum(int[] nums, int target) {
        return temp(nums, target, 0);
    }
}