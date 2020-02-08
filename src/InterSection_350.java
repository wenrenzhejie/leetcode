import java.util.*;

public class InterSection_350 {
    //O(m + n)
    public int[] intersect1(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i],hashMap.getOrDefault(nums1[i],0) + 1);
        }
        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.getOrDefault(nums2[i],0) > 0){
                nums1[k] = nums2[i];
                k ++;
                hashMap.put(nums2[i],hashMap.get(nums2[i]) -  1);
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
    //对有序数组求交集
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length];
        int i = 0,j = 0,k = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] > nums2[j]){
                j ++;
            }else if (nums1[i] < nums2[j]){
                i ++;
            }else {
                res[k] = nums1[i];
                i ++;
                j ++;
                k ++;
            }
        }
        return Arrays.copyOfRange(res,0,k);
    }

}
