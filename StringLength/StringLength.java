public class StringLength {
    public static int getStringLength(String s) {
        System.out.println(s.length());
        if (s == null){
            return 0;
        } else {
            return s.length();
        }
    }

    public static void main (String[] args) {
        getStringLength("abc");
    }
}