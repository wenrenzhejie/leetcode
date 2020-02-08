import sun.awt.WindowIDProvider;
//最小子数组一定是从某个节点开始的，找到从每一个节点开始的最小子数组
//滑动窗口解法
public class Minimum_size_subarray_sum_209 {
    //暴力解法
    public int minSubArrayLen1(int s, int[] nums) {
        int minLength = nums.length + 1;
        for (int i = 0;i < nums.length;i ++){
            int sum = nums[i];
            if (sum >= s){
                minLength = 1;
                return minLength;
            }
            for (int j = i + 1;j < nums.length;j ++){
               sum += nums[j];
               if (sum >= s){
                   if (j - i + 1 < minLength){
                       minLength = j - i + 1;
                   }
                   break;
               }
            }
        }
        return minLength == nums.length + 1 ? 0 : minLength;
    }
    //滑动窗口解法
    public int minSubArrayLen(int s, int[] nums) {
        //[l...r]是这个窗口
        int l = 0,r = -1;
        int minLength = nums.length + 1;
        int sum = 0;
        while (l < nums.length){
            if (sum < s){
                if (r + 1 < nums.length){
                    r ++;
                    sum += nums[r];
                }else {
                    break;
                }

            }else {
                if (r - l + 1 < minLength){
                    minLength = r - l + 1;
                }
                sum -= nums[l];
                l ++;
            }
        }
        return minLength == nums.length + 1 ? 0:minLength;
    }
}
