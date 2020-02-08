import java.util.Random;

public class KthMax_215_2 {
    public int findKthLargest(int[] nums, int k) {
       return findKthLargest(nums,0,nums.length - 1,k);
    }
    private int findKthLargest(int[] nums,int l,int r,int k){
        Random random = new Random();
        int ranInt = random.nextInt(r - l + 1) + l;
        swap(nums,l,ranInt);
        int v = nums[l];
        //[l + 1,i) < v (j,r]>v
        int i = l + 1,j = r;
        while (true){
            while (i <= j && nums[i] < v){
                i ++;
            }
            while (i <= j && nums[j] > v){
                j --;
            }
            if (i > j){
                break;
            }
            swap(nums,i,j);
            i ++;
            j --;
        }
        swap(nums,l,j);
        if (nums.length - k > j){
            return findKthLargest(nums,j + 1,r,k);
        }else if (nums.length - k < j){
            return findKthLargest(nums,l,j - 1,k);
        }else {
            return nums[j];
        }
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        int[] ints = new int[]{3,2,1,5,6,4};
        int kthLargest = new KthMax_215_2().findKthLargest(ints, 1);
        System.out.println(kthLargest);
    }
}
