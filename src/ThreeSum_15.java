import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if (len < 3){
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0;i < nums.length;i ++){
            int l = i + 1;
            int r = len - 1;
            if (nums[i] > 0){
                break;
            }
            if (i >=1 && nums[i] == nums[i - 1]){
                continue;
            }
            int middle = -nums[i];
            while (l < r){
                if (nums[l] + nums[r] > middle){
                    r --;
                }else if (nums[l] + nums[r] < middle){
                    l ++;
                }else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list);
                    l ++;
                    r --;
                    while (l < r && nums[l] == nums[l - 1]){
                        l ++;
                    }
                    while (l < r && nums[r] == nums[r + 1]){
                        r --;
                    }
                }

            }
        }
        return lists;
    }
}
