import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexReplace {
    
    // Fonction pour supprimer les unités 'cm' et '€' lorsqu'elles suivent un nombre
    public static String removeUnits(String s) {
        // Remplace "cm" ou "€" s'ils sont suivis directement d'un nombre par rien
        return s.replaceAll("(\\d+)(cm|€)(?![\\d])", "$1");
    }
    
    // Fonction pour obscurcir une adresse e-mail selon les règles données
    public static String obfuscateEmail(String s) {
        // Regex pour séparer le nom d'utilisateur et le domaine
        String[] parts = s.split("@");
        if (parts.length != 2) {
            return s; // Si l'adresse e-mail n'est pas valide, on la retourne telle quelle
        }

        String username = parts[0];
        String domain = parts[1];

        // Obscurcir la partie nom d'utilisateur
        if (username.contains("-") || username.contains(".") || username.contains("_")) {
            username = username.replaceAll("(?<=[-._]).(?=.)", "*"); // Remplace les caractères adjacents à ces symboles par "*"
        } else {
            if (username.length() > 3) {
                username = username.substring(0, 3) + "***"; // Remplace les 3 derniers caractères par "***"
            }
        }

        // Regex pour détecter un domaine à trois niveaux
        String domainPattern = "([^.]+)\\.([^.]+)\\.([^.]+)";
        Matcher matcher = Pattern.compile(domainPattern).matcher(domain);
        if (matcher.matches()) {
            // Si on a un domaine de type "sous-domaine.domaine.tld"
            domain = "******." + matcher.group(2) + ".***"; // Masque le sous-domaine et le TLD
        } else {
            // Sinon, masque tout sauf si c'est .com, .org ou .net
            domain = domain.replaceAll("([^.]+)\\.(com|org|net)", "******.$2");
            domain = domain.replaceAll("([^.]+)\\.([^.]+)", "******.**"); // Masque le domaine et le TLD dans les autres cas
        }

        // Concatène le nom d'utilisateur obfusqué et le domaine obfusqué
        return username + "@" + domain;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(RegexReplace.removeUnits("32cm et 50€"));
        System.out.println(RegexReplace.removeUnits("32 cm et 50 €"));
        System.out.println(RegexReplace.removeUnits("32cms et 50€!"));
        
        System.out.println(RegexReplace.obfuscateEmail("john.doe@example.com"));
        System.out.println(RegexReplace.obfuscateEmail("jann@example.co.org"));
        System.out.println(RegexReplace.obfuscateEmail("jackob@example.fr"));
    }

}
