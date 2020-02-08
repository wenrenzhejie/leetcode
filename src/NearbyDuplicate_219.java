import java.util.*;

public class NearbyDuplicate_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        if (k <= 0){
            return false;
        }
        int l = 0;
        int len = nums.length;
        for (int i = 0;i < len;i ++){
            if (hashSet.contains(nums[i])){
                return true;
            }else {
                if (hashSet.size() == k){
                    hashSet.remove(nums[l]);
                    l ++;
                }
                hashSet.add(nums[i]);
            }
        }
        return false;
    }
}
