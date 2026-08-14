class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums= new int[nums1.length];

        int i=0;
        int j=0;
        int k=0;

        while (i<m && j<n){
            if (nums1[i]==nums2[j]){
                nums[k]=nums1[i];
                nums[++k]=nums2[j];

                i++;
                j++;
                k++;
            }else if (nums1[i]<nums2[j]){
                nums[k]=nums1[i];
                i++;
                k++;
            }else {
                nums[k]=nums2[j];
                j++;
                k++;
            }

        }

        while (i<m){
            nums[k]=nums1[i];
            i++;
            k++;
        }

        while (j<n){
            nums[k]=nums2[j];
            j++;
            k++;
        }

        k=0;
        i=0;

        while (k<nums1.length){
            nums1[i]=nums[k];
            i++;
            k++;
        }
        
    }
}