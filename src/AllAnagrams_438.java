import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagrams_438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] fre = new int[26];
        int[] chars = new int[26];
        int count = 0;
        int match = 0;
        int l = 0,r = -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < p.length();i ++){
            int f = p.charAt(i) - 'a';
            if (fre[f] == 0){
                fre[f] = 2;
                count ++;
            }else {
                fre[f] ++;
            }
        }
        while (l < s.length()){
            if (r + 1 < s.length()){
                r ++;
                char c = s.charAt(r);
                if (fre[c - 'a'] != 0 && chars[c - 'a'] + 1 < fre[c - 'a']){
                    chars[c - 'a'] ++;
                    if (chars[c - 'a'] + 1 == fre[c - 'a']){
                        match ++;
                        if (match == count){
                            list.add(l);
                            chars[s.charAt(l) - 'a'] --;
                            match --;
                            l ++;
                        }
                    }
                }else {
                   if (fre[c - 'a'] == 0){
                       chars = new int[26];
                       match = 0;
                       l = r + 1;
                   }else{
                       char lChar = s.charAt(l);
                       chars[lChar - 'a'] --;
                       match --;
                       r --;
                       l ++;
                   }
                }
            }else {
                break;
            }
        }
        return list;
    }
    public static void main(String[] args){
        List<Integer> anagrams = new AllAnagrams_438().findAnagrams("abab", "ab");
        System.out.println(anagrams);
    }
    }
