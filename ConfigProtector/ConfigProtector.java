import java.util.List;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigProtector {

    public String hideSensitiveData(String configFile, List<String> sensitiveKeys) {
        // Loop through each key in the sensitiveKeys list
        for (String key : sensitiveKeys) {
            // Create a regex pattern to match the key and its value
            // This will match strings in the format key=value
            String regex = key + "=([^\n]*)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(configFile);
            
            // Replace the matched value with asterisks, keeping the key intact
            configFile = matcher.replaceAll(matchResult -> key + "=" + "*".repeat(matchResult.group(1).length()));
        }
        
        return configFile;
    }

    public static void main(String[] args) {
        ConfigProtector protector = new ConfigProtector();

        String configFile1 = "username=admin\npassword=secret\nhost=localhost\n";
        List<String> sensitiveKeys1 = Arrays.asList("password");
        System.out.println("Protected Config 1:\n" + protector.hideSensitiveData(configFile1, sensitiveKeys1));

        String configFile2 = "apiKey=12345\napiSecret=abcdef\nendpoint=https://api.example.com\n";
        List<String> sensitiveKeys2 = Arrays.asList("apiKey", "apiSecret");
        System.out.println("Protected Config 2:\n" + protector.hideSensitiveData(configFile2, sensitiveKeys2));

        String configFile3 = "username=user\npassword=pass\n";
        List<String> sensitiveKeys3 = Arrays.asList("username", "password");
        System.out.println("Protected Config 3:\n" + protector.hideSensitiveData(configFile3, sensitiveKeys3));
    }
}