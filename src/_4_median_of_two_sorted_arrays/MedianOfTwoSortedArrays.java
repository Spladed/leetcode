package _4_median_of_two_sorted_arrays;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0, k = 0;
        int total = m + n;
        int[] arr = new int[total];
        while (i < m && j < n) {
            arr[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            arr[k++] = nums1[i++];
        }
        while (j < n) {
            arr[k++] = nums2[j++];
        }
        return total % 2 == 1 ? arr[total / 2] : (double) (arr[total / 2] + arr[total / 2 - 1]) / 2;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 0};
        int[] nums2 = new int[]{0, 0};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

}
