public class ColorSort_75 {
    public void sortColors(int[] nums) {
        int zero = -1; //[0...zero] = 0
        int two = nums.length; // [two...n-1] = 2
        for (int i = zero + 1;i < two;i++){
            switch (nums[i]){
                case 0:
                    zero ++;
                    swap(nums,i,zero);
                    break;
                case 1:
                    break;
                case 2:
                    two --;
                    swap(nums,i,two);
                    i --;
                    break;
            }
        }
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
