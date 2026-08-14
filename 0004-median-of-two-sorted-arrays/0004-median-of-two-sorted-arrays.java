class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = n1;
        int leftHalf = (n1 + n2 + 1) / 2;
        int totalLength = n1 + n2;
        
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = leftHalf - mid1;
            
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            
            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }
            
            if (mid1 < n1) {
                r1 = nums1[mid1];
            }
            if (mid2 < n2) {
                r2 = nums2[mid2];
            }
            
            if (l1 <= r2 && l2 <= r1) {
                if (totalLength % 2 != 0) {
                    if (l1 > l2) {
                        return (double) l1;
                    } else {
                        return (double) l2;
                    }
                } else {
                    int maxLeft = 0;
                    if (l1 > l2) {
                        maxLeft = l1;
                    } else {
                        maxLeft = l2;
                    }
                    
                    int minRight = 0;
                    if (r1 < r2) {
                        minRight = r1;
                    } else {
                        minRight = r2;
                    }
                    
                    return ((double) maxLeft + (double) minRight) / 2.0;
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        
        return 0.0;
    }
}