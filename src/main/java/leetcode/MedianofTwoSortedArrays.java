package leetcode;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double out = 0.0;
        int len = nums1.length + nums2.length;
        int[] sort = new int[len];

        int len1 = nums1.length;
        int len2 = nums2.length;

        int m = 0, n = 0, i = 0;
        while ((m < len1 || n < len2) && i < len / 2 + 1) {
            if(m >= len1){
                sort[i] = nums2[n];
                n++;
            }
            else if(n >= len2){
                sort[i] = nums1[m];
                m++;
            }
            else {
                if (nums1[m] < nums2[n]) {
                    sort[i] = nums1[m];
                    m++;
                } else if (nums1[m] >= nums2[n]) {
                    sort[i] = nums2[n];
                    n++;
                }
            }
            i++;
        }
        out = (len%2 == 0 ? (double)(sort[len/2 - 1] + sort[len/2])/2:sort[len/2]);

        return out;
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays sulution = new MedianofTwoSortedArrays();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double out = sulution.findMedianSortedArrays(nums1, nums2);
        System.out.println(out);

    }
}
