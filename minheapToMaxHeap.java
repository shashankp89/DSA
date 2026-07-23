/*Convert Min Heap to Max Heap
Subscribe to TUF+

Hints
Company
Given a min-heap in array representation named nums, convert it into a max-heap and return the resulting array.



A min-heap is a complete binary tree where the key at the root is the minimum among all keys present in a binary min-heap and the same property is recursively true for all nodes in the Binary Tree.

A max-heap is a complete binary tree where the key at the root is the maximum among all keys present in a binary max-heap and the same property is recursively true for all nodes in the Binary Tree.



Since there can be multiple answers, the compiler will return true if it's correct, else false.


Example 1

Input: nums = [10, 20, 30, 21, 23]

Output: [30, 21, 23, 10, 20]

Explanation:

In the input min heap, 10 is the root (smallest).

After conversion, 30 becomes the root (largest).

Now every parent node is larger than its children:

30 > 21, 30 > 23

21 > 10, 23 > 20

Hence it is a valid max heap.

Example 2

Input: nums = [-5, -4, -3, -2, -1]

Output: [-1, -2, -3, -4, -5]

Explanation:

In the input min heap, -5 is the root (smallest among negatives).

After conversion, -1 becomes the root (largest among negatives).

Now every parent node is larger than its children:

-1 > -2, -1 > -3

-2 > -4, -3 > -5

Hence it is a valid max heap.

Now your turn!

Input: nums = [2, 6, 3, 100, 120, 4, 5]

Output:

Pick your answer


[120, 100, 5, 3, 4, 2, 6]

[100, 120, 6, 3, 4, 2, 5]

[120, 100, 6, 3, 2, 2, 5]

[120, 100, 6, 3, 4, 2, 5]
Constraints

1 <= nums.length <= 105
-104 <= nums[i] <= 104
nums represents a min-heap */


class Solution {
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;
        
        // Start from the last non-leaf node and heapify each node upwards to the root
        // The last non-leaf node is always at index (n / 2) - 1
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        
        return nums;
    }
    
    // Helper method to maintain the max-heap property
    private void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as the current root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index
        
        // If left child exists and is greater than the current largest
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // If right child exists and is greater than the current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // If the largest is not the root, we need to swap and continue heapifying down
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}