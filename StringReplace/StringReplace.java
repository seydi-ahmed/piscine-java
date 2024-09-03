public class StringReplace {
    public static String replace(String s, String target, String replacement) {
        if (s == null || target == null || replacement == null) {
            throw new IllegalArgumentException("Les paramètres ne peuvent pas être nulls.");
        }
        return s.replace(target, replacement);
    }
    
    public static String replace(String s, char target, char replacement) {
        if (s == null) {
            throw new IllegalArgumentException("Le paramètre original_string ne peut pas être nul.");
        }
        return s.replace(target, replacement);
    }
}
