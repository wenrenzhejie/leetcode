import javax.sound.midi.Soundbank;

public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0;i < nums.length - count;i++){
            if (nums[i] == val){
                count ++;
                if (nums[nums.length - count] != val){
                    swap(nums,i,nums.length -  count);
                }else {
                    i --;
                }
            }
        }
        return nums.length - count;
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        int[] ints = new int[]{0,1,2,2,3,0,4,2};
        int i = new RemoveElement_27().removeElement(ints,0);
        System.out.println(i);

    }
}
