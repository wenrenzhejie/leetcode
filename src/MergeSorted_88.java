public class MergeSorted_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int i = 0;i < m;i++){
            temp[i] = nums1[i];
        }
        int i = 0,j = 0,k = 0;
        while (k < m + n){
            if (i >= m){
                nums1[k] = nums2[j];
                j ++;
            }else if (j >= n){
                nums1[k] = temp[i];
                i ++;
            }else if (temp[i] < nums2[j]){
                nums1[k] = temp[i];
                i ++;
            }else {
                nums1[k] = nums2[j];
                j ++;
            }
            k ++;
        }
    }
}
