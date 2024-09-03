public class StringReplace {
    public static String replace(String s, String target, String replacement) {
        // Vérifie que les entrées ne sont pas nulles
        if (s == null || target == null || replacement == null) {
            throw new IllegalArgumentException("Les paramètres ne peuvent pas être nulls.");
        }
        // Utilise la méthode replace pour remplacer toutes les occurrences
        return s.replace(target, replacement);
    }
    
    // Surcharge pour gérer les cas où target et replacement sont des caractères
    public static String replace(String s, char target, char replacement) {
        // Vérifie que l'entrée n'est pas nulle
        if (s == null) {
            throw new IllegalArgumentException("Le paramètre original_string ne peut pas être nul.");
        }
        // Utilise la méthode replace pour remplacer les caractères
        return s.replace(target, replacement);
    }
}
