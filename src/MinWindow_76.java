import java.util.HashMap;

public class MinWindow_76 {
    public String minWindow(String s, String t) {
        //记录窗口中已出现的次数
        int[] chars = new int[256];
        //记录t中每个单词的频次
        int[] fre = new int[256];
        //记录已匹配的单词数
        int match = 0;
        //记录单词数
        int count = 0;
        int minLength = s.length() + 1;
        int beginIndex = -1;
        if (t.length() > s.length()){
            return "";
        }
        for (int i = 0;i < t.length();i ++){
            if (fre[t.charAt(i)] == 0){
                fre[t.charAt(i)] = 2;
                count ++;
            }else {
                fre[t.charAt(i)] ++;
            }
        }
        int l = 0,r = -1;
        while (l < s.length()){
            if (r + 1 < s.length()){
                r ++;
                char c = s.charAt(r);
                if (fre[c] != 0 ){
                    chars[c] ++;
                    if (chars[c] + 1 == fre[c]){
                        match ++;
                    }
                    if (match == count){
                        if (r - l + 1 < minLength){
                            minLength = r - l + 1;
                            beginIndex = l;
                        }
                        if (fre[s.charAt(l)] != 0){
                            chars[s.charAt(l)] --;
                            if (chars[s.charAt(l)] + 1 < fre[s.charAt(l)]){
                                match --;
                            }
                        }
                        l ++;
                        chars[c] --;
                        if (c != s.charAt(l - 1)){
                            match --;
                        }
                        r --;
                    }
                }
            }else {
                break;
            }
        }
        return minLength == s.length() + 1 ? "":s.substring(beginIndex,beginIndex + minLength);
    }
    public static void main(String[] args){
        String s = new MinWindow_76().minWindow("acbbaca", "aba");
        System.out.println(s);
    }
}
