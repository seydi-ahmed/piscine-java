public class Palindrome {
    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("ressasser")); // true
        System.out.println(Palindrome.isPalindrome("Bonjour"));  // false
        System.out.println(Palindrome.isPalindrome("kay ak"));   // false
    }
}
