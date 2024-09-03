public class CleanExtract {
    public static String extract(String s) {
        // Diviser la chaîne d'entrée en sous-chaînes en utilisant le caractère '|'
        String[] substrings = s.split("\\|");

        // Utiliser un StringBuilder pour construire le résultat final
        StringBuilder result = new StringBuilder();

        // Traiter chaque sous-chaîne
        for (String substring : substrings) {
            // Retirer les espaces en début et fin
            substring = substring.trim();
            
            // Trouver la position du premier et dernier point
            int firstDotIndex = substring.indexOf('.');
            int lastDotIndex = substring.lastIndexOf('.');

            // Cas 1: Pas de point, on ajoute la sous-chaîne complète
            if (firstDotIndex == -1) {
                if (!substring.isEmpty()) {
                    result.append(substring).append(" ");
                }
            } 
            // Cas 2: Un seul point, on prend tout ce qui est après le point
            else if (firstDotIndex == lastDotIndex) {
                String extracted = substring.substring(firstDotIndex + 1).trim();
                if (!extracted.isEmpty()) {
                    result.append(extracted).append(" ");
                }
            } 
            // Cas 3: Deux points ou plus, on extrait entre le premier et le dernier point
            else {
                String extracted = substring.substring(firstDotIndex + 1, lastDotIndex).trim();
                if (!extracted.isEmpty()) {
                    result.append(extracted).append(" ");
                }
            }
        }

        // Convertir le StringBuilder en chaîne et supprimer l'espace final
        return result.toString().trim();
    }

    public static void main(String[] args) {
        // Tests
        System.out.println(CleanExtract.extract("The|. quick brown. | what do you ..| .fox .|. Jumps over the lazy dog. ."));
        System.out.println(CleanExtract.extract("  | Who am .I  | .love coding,  |  |.  Coding is fun . | ...  "));
    }
}
