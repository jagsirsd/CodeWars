package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedianOfTwoSortedArraysTest {

    @Test
    public void medianTest() {
        int[] nums1 = {1, 3, 8};
        int[] nums2 = {7, 9, 10, 11};

        double median = MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(8.0, median);

        median = MedianOfTwoSortedArrays.findMedianSortedArraysNamingChanged(nums1, nums2);
        Assertions.assertEquals(8.0, median);
    }

    @Test
    public void medianTestLarge() {
        int[] nums1 = {1, 3, 8, 22, 27};
        int[] nums2 = {7, 9, 10, 11, 15, 16, 23, 24};

        double median = MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(11.0, median);

        median = MedianOfTwoSortedArrays.findMedianSortedArraysNamingChanged(nums1, nums2);
        Assertions.assertEquals(11.0, median);
    }
}