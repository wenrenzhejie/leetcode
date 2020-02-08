import java.lang.reflect.Array;
import java.util.Arrays;

public class MoveZeros_283 {
    public void moveZeroes1(int[] nums) {
        int count = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] == 0){
                int j = i;
                while (j + 1 < nums.length && nums[j + 1] != 0){
                        nums[j - count] = nums[j + 1];
                        j ++;
                }
                count ++;
                i = j;
            }

        }
        for (int i = 0;i < count;i++){
            nums[nums.length - 1 - i] = 0;
        }
    }
    public void moveZeroes2(int[] nums){
        int k = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != 0){
                nums[k] = nums[i];
                k ++;
            }
        }
        for (int i = k;i < nums.length;i++){
            nums[i] = 0;
        }
    }
    public void moveZeroes(int[] nums){
        int k = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != 0){
                if (i != k){
                    swap(nums,k,i);
                }
                k++;
            }
        }
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        int[] ints = {0, 1, 0, 3, 12};
        new MoveZeros_283().moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }
}
