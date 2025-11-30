public class MergeSortedArr {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
// import java.util.Arrays;

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         // We use three pointers:
//         // p1 points to the end of elements in nums1
//         // p2 points to the end of elements in nums2
//         // p points to the end of the combined array nums1
//         int p1 = m - 1;
//         int p2 = n - 1;
//         int p = m + n - 1;
//         while (p1 >= 0 && p2 >= 0) {
//             // Compare the elements at the current pointers
//             // and place the larger one at the current position 'p'
//             if (nums1[p1] > nums2[p2]) {
//                 nums1[p] = nums1[p1];
//                 p1--; // Move nums1 pointer left
//             } else {
//                 nums1[p] = nums2[p2];
//                 p2--; // Move nums2 pointer left
//             }
//             p--; // Move combined pointer left
//         }

//         while (p2 >= 0) {
//             nums1[p] = nums2[p2];
//             p2--;
//             p--;
//         }

//         System.out.println(Arrays.toString(nums1)); 
//     }
// }

