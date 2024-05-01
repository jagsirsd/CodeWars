package arrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure that nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // If partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            // If partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { // we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { // we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        // Only we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException("Input arrays are not sorted");
    }
    public static double findMedianSortedArraysNamingChanged(final int[] nums11, final int[] nums22) {
        int[] smaller = nums11;
        int[] larger = nums22;
        // Ensure that nums1 is the smaller array
        if (nums11.length > nums22.length) {
            larger = nums11;
            smaller = nums22;
        }

        int smallLen = smaller.length;
        int largeLen = larger.length;
        int low = 0;
        int high = smallLen;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (smallLen + largeLen + 1) / 2 - partitionX;

            // If partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            // If partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : smaller[partitionX - 1];
            int minRightX = (partitionX == smallLen) ? Integer.MAX_VALUE : smaller[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : larger[partitionY - 1];
            int minRightY = (partitionY == largeLen) ? Integer.MAX_VALUE : larger[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((smallLen + largeLen) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { // we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { // we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        // Only we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException("Input arrays are not sorted");
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();
        Solution2.removeDuplicates(nums);
        Arrays.stream(nums).forEach(System.out::println);
        int[] nums1 = {1, 3, 8};
        int[] nums2 = {7, 9, 10, 11};

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("The median is: " + median);
    }
    static class Solution {
        public String intToRoman(int num) {
            String[] M = {"", "M", "MM", "MMM"};
            String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
        }
    }
    static class Solution2 {
        public static int removeDuplicates(int[] nums) {
            int len = nums.length;
            if (len <= 1) return len;
            int tail = 1;
            for (int i = 1; i < len; ++i) {
                if (nums[i - 1] != nums[i]) {
                    nums[tail++] = nums[i];
                }
            }
            System.out.println("need to do a copy: " + tail);
            return tail;
        }
    }
}
