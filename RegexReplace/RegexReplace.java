import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace {
    public static String removeUnits(String s) {
        
        StringBuilder result = new StringBuilder();
        String[] tokens = s.split(" ");
        for (String token : tokens) {
            if (token.matches("[0-9]+cm")) {
                result.append(token.replace("cm", "")).append(" ");
            } else if (token.matches("[0-9]+€")) {
                result.append(token.replace("€", "")).append(" ");
            } else {
                result.append(token).append(" ");
            }
        }
        // Retourner la chaîne modifiée avec les unités retirées
        return result.toString().trim();
    }
    
    public static String obfuscateEmail(String email) {
       // Split the email into username and domain
        String[] parts = email.split("@");
        if (parts.length != 2) return email; // Invalid email format
        
        String username = parts[0];
        String domain = parts[1];
        
        // Obfuscate the username
        if (username.contains("-") || username.contains(".") || username.contains("_")) {
            // Replace characters following '-', '.', or '_' with '*'
            int size = username.split("[-._]")[1].length();
            username = username.replaceAll("([-. _]).*", "$1" + "*".repeat(size));
        } else {
            // If length is greater than 3, keep the first 3 characters and add '***'
            if (username.length() > 3) {
                username = username.substring(0, 3) + "*".repeat(username.length()-3);
            }
        }
        
        // Obfuscate the domain
        String[] domainParts = domain.split("\\.");
        if (domainParts.length == 3) {
            domainParts[0] = "*".repeat(domainParts[0].length()); // Hide the third-level domain
            domainParts[2] = "*".repeat(domainParts[2].length()); // Hide the top-level domain
        } else if (domainParts.length == 2) {
            String tld = domainParts[1];
            if (tld.equals("com") || tld.equals("org") || tld.equals("net")) {
                domainParts[0] = "*".repeat(domainParts[0].length()); // Hide the domain part
            } else {
                domainParts[0] = "*".repeat(domainParts[0].length()); // Hide the domain part
                domainParts[1] = "*".repeat(domainParts[1].length()); // Hide the top-level domain
            }
        } else {
            // Handle domains with more than 3 parts if needed
            return email;
        }

        return username + "@" + String.join(".", domainParts);
    }

   

    public static void main(String[] args) throws IOException {
        System.out.println(removeUnits("15323cm et 50€"));
        System.out.println(removeUnits("32 cm et 50 €"));
        System.out.println(removeUnits("32cms et 50€!"));
        
        System.out.println(RegexReplace.obfuscateEmail("john.doe@example.com"));
        System.out.println(RegexReplace.obfuscateEmail("jann@example.co.org"));
        System.out.println(RegexReplace.obfuscateEmail("jackob@example.fr"));
    }
}