public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        String trim = s.trim();
        if (trim.length() == 0){
            return true;
        }
        int left = 0,right = trim.length() - 1;
        while (left < right){
            char leftChar = trim.charAt(left);
            char rightChar = trim.charAt(right);
            if ( !((leftChar > '0' && leftChar < '9') || (leftChar > 'A' && leftChar < 'Z') || (leftChar > 'a' && leftChar < 'z'))){
                left ++;
                continue;
            }
            if ( !((rightChar > '0' && rightChar < '9') || (rightChar > 'A' && rightChar < 'Z') || (rightChar > 'a' && rightChar < 'z'))){
                right --;
                continue;
            }
            if (!String.valueOf(leftChar).toLowerCase().equals(String.valueOf(rightChar).toLowerCase())){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
    public static void main(String[] args){
        boolean race_a_car = new ValidPalindrome_125().isPalindrome("race a car");
        System.out.println(race_a_car);
    }
}
