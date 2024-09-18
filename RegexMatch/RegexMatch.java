import java.util.regex.Pattern;
import java.io.IOException;

public class RegexMatch {

    // Vérifie si la chaîne contient uniquement des caractères alphabétiques (lettres majuscules ou minuscules)
    public static boolean containsOnlyAlpha(String s) {
        if (s == null) return false; // Gérer les chaînes null
        return Pattern.matches("^[a-zA-Z]+$", s);
    }
    
    // Vérifie si la chaîne commence par une lettre et se termine par un chiffre
    public static boolean startWithLetterAndEndWithNumber(String s) {
        if (s == null) return false; // Gérer les chaînes null
        return Pattern.matches("^[a-zA-Z].*\\d$", s);
    }
    
    // Vérifie si la chaîne contient au moins 3 'A' successifs
    public static boolean containsAtLeast3SuccessiveA(String s) {
        if (s == null) return false; // Gérer les chaînes null
        return Pattern.matches(".*A{3,}.*", s);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(RegexMatch.containsOnlyAlpha("azejkdfhjsdf"));
        System.out.println(RegexMatch.containsOnlyAlpha("azejkd fhjsdf"));
        System.out.println(RegexMatch.startWithLetterAndEndWithNumber("asjd jd34jds jkfd6f5"));
        System.out.println(RegexMatch.startWithLetterAndEndWithNumber("asjd jd34jds jkfd6."));
        System.out.println(RegexMatch.containsAtLeast3SuccessiveA("sdjkAAAAAsdjksj"));
        System.out.println(RegexMatch.containsAtLeast3SuccessiveA("sdjkAAsdaaasdjksj"));
    }

}
