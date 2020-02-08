import java.util.HashMap;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0;i < nums.length;i ++){
            int middle = target - nums[i];
            if (hashMap.containsKey(middle)){
                return new int[]{i,hashMap.get(middle)};
            }else {
                hashMap.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException();
    }
}
