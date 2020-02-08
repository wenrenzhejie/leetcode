public class KthMax_215 {
    public int findKthLargest(int[] nums, int k) {
       return findKthLargest(nums,0,nums.length - 1,k);
    }
    private int findKthLargest(int[] nums,int l,int r,int k){
        int partition = partition(nums, l,r);
        if (partition < (nums.length - k)){
            return findKthLargest(nums,partition + 1,r,k);
        }else if (partition > (nums.length - k)){
            return findKthLargest(nums,l,partition - 1,k);
        }else {
            return nums[partition];
        }
    }
    private int partition(int[] nums,int l,int r){
        int j = l;
        for (int i = l + 1;i <= r;i ++){
            if (nums[i] < nums[l]){
                j ++;
                swap(nums,j,i);
            }
        }
        swap(nums,l,j);
        return j;
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        int[] ints = new int[]{3,2,1,5,6,4};
        int kthLargest = new KthMax_215().findKthLargest(ints, 6);
        System.out.println(kthLargest);
    }
}
