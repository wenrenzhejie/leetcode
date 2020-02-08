public class LongestSubstring_3 {
    public int lengthOfLongestSubstring1(String s) {
        int[] frequency = new int[256];
        int maxLength = 0;
        int l = 0, r = 0;
        while (l < s.length()) {
            if (r < s.length()){
                char c = s.charAt(r);
                if (frequency[c] != 0) {
                    maxLength = r - l > maxLength ? r - l : maxLength;
                    frequency[s.charAt(l)] = 0;
                    l ++;
                }else {
                    frequency[c] = 1;
                    r++;
                }

            }else {
                maxLength = r - l > maxLength ? r - l : maxLength;
                break;
            }
        }
        return maxLength;
    }
    public int lengthOfLongestSubstring(String s) {
        int l = 0,r = -1;
        int maxLength = 0;
        int[] fre = new int[256];
        while (l < s.length()){
            if (r + 1 < s.length() && fre[s.charAt(r + 1)] == 0){
                r ++;
                fre[s.charAt(r)] ++;
            }else {
                fre[s.charAt(l)] --;
                l ++;
            }
            maxLength = Math.max(maxLength,r - l + 1);
        }
        return maxLength;
    }
    public static void main(String[] args){
        int length = new LongestSubstring_3().lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
    }
}
