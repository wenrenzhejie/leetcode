public class TwoSum_167 {
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0;i < numbers.length;i ++){
            int search = target - numbers[i];
            if (search >= numbers[i]){
                for (int j = i + 1;j < numbers.length;j ++){
                    if (numbers[j] == search){
                        return new int[]{i + 1,j + 1};
                    }
                }
            }
            if (search <= numbers[i]){
                for (int j = i - 1;j < numbers.length;j ++){
                    if (numbers[j] == search){
                        return new int[]{j + 1,i + 1};
                    }
                }
            }
        }
        return new int[]{-1,-1};
    }
    //有序数组采用二分查找优化
    public int[] twoSum2(int[] numbers, int target) {
       for (int i = 0;i < numbers.length;i ++){
           int search = target - numbers[i];
           int i1 = find(numbers, i + 1, numbers.length - 1, search);
           if (i1 != -1){
               return new int[]{i + 1,i1 + 1};
           }
       }
       return new int[]{-1,-1};
    }
    private int find(int[] numbers,int begin, int end, int search) {
        if (begin > end){
            return -1;
        }
        int mid = begin + (end - begin) / 2;
        if (numbers[mid] < search){
            return find(numbers,mid + 1,end,search);
        }else if (numbers[mid] > search){
            return find(numbers,begin,mid - 1,search);
        }else {
            return mid;
        }
    }
    //使用对撞指针解决此类问题
    public int[] twoSum(int[] numbers, int target){
        return twoSum(numbers,0,numbers.length - 1,target);
    }
    private int[] twoSum(int[] numbers, int left,int right,int target){
        if (left >= right){
            return new int[]{-1,-1};
        }
        if (numbers[left] + numbers[right] > target){
            return twoSum(numbers,left,right - 1,target);
        }else if (numbers[left] + numbers[right] < target){
            return twoSum(numbers,left + 1,right,target);
        }else {
            return new int[]{left + 1,right + 1};
        }
    }
}
