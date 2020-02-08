import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class InterSection_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> hashSet1 = new HashSet<>();
        for (int i = 0;i < nums1.length;i ++){
            hashSet.add(nums1[i]);
        }
        for (int i = 0;i < nums2.length;i ++){
            if (hashSet.contains(nums2[i])){
                hashSet1.add(nums2[i]);
            }
        }
        int[] ints = new int[hashSet1.size()];
        Iterator<Integer> iterator = hashSet1.iterator();
        int i = 0;
        while (iterator.hasNext()){
            ints[i] = iterator.next();
            i ++;
        }
        return ints;
    }
}
