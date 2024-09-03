public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("ressasser"));
        System.out.println(Palindrome.isPalindrome("Bonjour"));
        System.out.println(Palindrome.isPalindrome("kay ak"));
        System.out.println(Palindrome.isPalindrome("kayak"));
        System.out.println(Palindrome.isPalindrome("kayaK"));
        System.out.println(Palindrome.isPalindrome(""));
    }
}
