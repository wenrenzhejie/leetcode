public class Most_water_11 {
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0;i < height.length;i ++){
            for (int j = i + 1;j < height.length;j ++){
                int w = j - i;
                int h = Math.min(height[i],height[j]);
                max = max > w * h?max:w*h;
            }
        }
        return max;
    }
    public int maxArea(int[] height){
        int i = 0,j = height.length - 1,max = 0;
        while (i < j){
            int h = j - i;
            int w = Math.min(height[i],height[j]);
            max = max > h * w ? max : h * w;
            if (height[i] < height[j]){
                i ++;
            }else {
                j --;
            }
        }
        return max;
    }
    public static void main(String[] args){
        int i = new Most_water_11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
}
