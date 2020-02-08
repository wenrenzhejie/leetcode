import java.util.HashMap;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] ints = new int[26];
        for (int i = 0;i < s.length();i ++){
           ints[s.charAt(i) - 'a'] ++;
           ints[t.charAt(i) - 'a'] --;
        }
        for (int i : ints){
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
