public class MaxFactor {
    public static void main(String[] args){
        int max = new MaxFactor().max(0, 64);
        System.out.println(max);
    }
    private int max(int i,int j){
        while (i % j != 0){
            int temp = j;
            j = i % j;
            i = temp;
        }
        return j;
    }
}
