import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BreakdownURL {
    // Regex pour extraire les composants de l'URL
    private static final String URL_REGEX = "^(https?)://([^:/\\s]+)(:(\\d+))?(/[^?\\s]*)?(\\?(.*))?$";
    
    // Methode pour parser et valider les URLs
    public Map<String, String> parseURL(String url) {
        Map<String, String> components = new LinkedHashMap<>();
        
        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(url);
        
        if (matcher.matches()) {
            // Extracting components based on regex groups
            String protocol = matcher.group(1);  // Protocol (http or https)
            String domain = matcher.group(2);    // Domain name
            String port = matcher.group(4);      // Port number (optional)
            String path = matcher.group(5);      // Path (optional)
            String query = matcher.group(7);     // Query string (optional)
            
            // Add to map in the specified order
            if (protocol != null) components.put("protocol", protocol);
            if (domain != null) components.put("domain", domain);
            if (port != null) components.put("port", port);
            if (path != null) components.put("path", path);
            if (query != null) components.put("query", query);
        }
        
        return components;
    }



    public static void main(String[] args) {
        BreakdownURL parser = new BreakdownURL();

        // Test case 1
        String URL1 = "https://www.example.com:8080/path?name=value";
        Map<String, String> components1 = parser.parseURL(URL1);
        System.out.println("Components of URL 1: " + components1);

        // Test case 2
        String URL2 = "http://example.com/";
        Map<String, String> components2 = parser.parseURL(URL2);
        System.out.println("Components of URL 2: " + components2);
    }
}


// A VOIR EN DÉTAIL