import sun.rmi.runtime.Log;

import java.util.HashSet;
import java.util.TreeSet;

public class NearbyAlmostDuplicate_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        int len = nums.length;
        if (len < 2 || k == 0){
            return false;
        }
        for (int i = 0;i < nums.length;i ++){
            long minNum = (long)nums[i] - (long)t;
            long maxNum = (long)nums[i] + (long)t;
            Long lower = treeSet.floor(maxNum);
            if (lower != null && lower >= minNum){
                return true;
            }else {
                if (treeSet.size() == k){
                    treeSet.remove((long)nums[i - k]);
                }
                treeSet.add((long)nums[i]);
            }
        }
        return false;
    }
    public static void main(String[] args){
        boolean b = new NearbyAlmostDuplicate_220().containsNearbyAlmostDuplicate(new int[]{0, 2147483647}, 1, 2147483647);
        System.out.println(b);
    }
}
