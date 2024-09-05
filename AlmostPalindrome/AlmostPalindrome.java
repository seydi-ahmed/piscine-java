public class AlmostPalindrome {
    public static boolean isPalindrome(String s){
        if (s == null){
            return false;
        } else {
            s = s.toLowerCase();
            for (int i = 0, j = s.length() - 1; i<j; i++, j--){
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isAlmostPalindrome(String s) {
        if (isPalindrome(s)) {
            return false;
        }
        int count = 0;
        for (int i = 0, j = s.length() - 1; i<j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)){
                count++;
            }
        }
        return count != 1;
    }

    // MAIN
    public static void main(String[] args) {
        System.out.println(AlmostPalindrome.isAlmostPalindrome("Racedcar"));
        System.out.println(AlmostPalindrome.isAlmostPalindrome("level"));
    }
}