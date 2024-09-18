import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexReplace {
    // Function to remove units cm and € following a number and space
    public static String removeUnits(String s) {
        // Regular expression to match a number followed by 'cm' or '€'
        String regex = "(\\d+)(cm|€)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.replaceAll("$1");
    }

    public static String obfuscateEmail(String s) {
        // Split the email into username and domain
        String[] parts = s.split("@");
        if (parts.length != 2) {
            return s; // Return unchanged if not a valid email
        }
        
        String username = parts[0];
        String domain = parts[1];
        
        // Obfuscate username
        String obfuscatedUsername;
        if (username.length() > 3) {
            obfuscatedUsername = username.substring(0, 1) + "***" + username.substring(username.length() - 1);
        } else {
            obfuscatedUsername = username.replaceAll("[-._]", "*");
        }
        
        // Obfuscate domain
        String obfuscatedDomain;
        String[] domainParts = domain.split("\\.");
        if (domainParts.length == 3) {
            // Format: third level domain, second level domain, top level domain
            obfuscatedDomain = "***.***." + domainParts[2];
        } else if (domainParts.length == 2) {
            // Format: second level domain, top level domain
            String topLevelDomain = domainParts[1];
            if (topLevelDomain.equals("com") || topLevelDomain.equals("org") || topLevelDomain.equals("net")) {
                obfuscatedDomain = "***." + topLevelDomain;
            } else {
                obfuscatedDomain = "***.***";
            }
        } else {
            obfuscatedDomain = domain;
        }
        
        return obfuscatedUsername + "@" + obfuscatedDomain;
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


// 32 et 50
// 32 cm et 50 €
// 32cms et 50€!
// john.***@*******.com
// jan*@*******.co.***
// jac***@*******.**