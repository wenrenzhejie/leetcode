import java.util.HashMap;

public class HappyNumber_202 {
    public boolean isHappy1(int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (true){
            String s = String.valueOf(n);
            n = 0;
            for (int i = 0;i < s.length();i ++){
                int i1 = Integer.parseInt(String.valueOf(s.charAt(i)));
                n += i1 * i1;
            }
            if (n == 1){
                return true;
            }
            if (hashMap.getOrDefault(n,0) > 0){
                return false;
            }else {
                hashMap.put(n,1);
            }
        }
    }

    public boolean isHappy(int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (true){
        int sum = 0;
        while (n > 0){
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        if (sum == 1){
            return true;
        }
        if (hashMap.getOrDefault(sum,0) > 0){
            return false;
        }else {
            hashMap.put(sum,1);
        }
        n = sum;
        }
    }
}
