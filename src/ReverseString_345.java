public class ReverseString_345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0,j = chars.length - 1;
        while (i < j){
            char m = chars[i];
            while (i < j && m != 'a' && m != 'e' && m != 'i' && m != 'o' && m != 'u'&&m != 'A' && m != 'E' && m != 'I' && m != 'O' && m != 'U'){
                i ++;
                m = chars[i];
            }
            char b= chars[j];
            while (i < j && b != 'a' && b != 'e' && b != 'i' && b != 'o' && b != 'u' && b != 'A' && b != 'E' && b != 'I' &&b != 'O' && b != 'U'){
                j --;
                b = chars[j];
            }
            if (i >= j){
                break;
            }
            swap(chars,i,j);
            i ++;
            j --;
        }
        return String.valueOf(chars);
    }
    private void swap(char[] s,int i,int j){
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
    public static void main(String[] args){
        String hello = new ReverseString_345().reverseVowels("hello");
        System.out.println(hello);
    }

}
