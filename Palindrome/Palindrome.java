public class Palindrome {
    public static boolean isPalindrome(String s) {
        // Supprimer les espaces et convertir la chaîne en minuscules pour une comparaison insensible à la casse
        String cleaned = s.replaceAll("\\s+", "").toLowerCase();
        
        // Créer un StringBuilder avec la chaîne nettoyée
        StringBuilder sb = new StringBuilder(cleaned);
        
        // Vérifier si la chaîne est égale à son inverse
        return cleaned.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        // Tests
        System.out.println(Palindrome.isPalindrome("ressasser")); // true
        System.out.println(Palindrome.isPalindrome("Bonjour"));  // false
    }
}
