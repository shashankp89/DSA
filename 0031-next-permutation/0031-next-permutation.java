class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int x = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                x = 1;
                int min = -1;
                for (int j = n - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        min = j;
                        break;
                    }
                }
                int temp1 = nums[min];
                nums[min] = nums[i];
                nums[i] = temp1;

                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    int temp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp;
                    j++;
                    k--;
                }

                break;
            }
        }
        if (x == 0) {
            int j = 0;
            int k = n - 1;
            while (j < k) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                j++;
                k--;
            }
        }

    }
}