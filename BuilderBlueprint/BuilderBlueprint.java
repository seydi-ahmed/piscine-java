import java.util.List;

public class Regex {
    private StringBuilder pattern;

    // Constructor takes a list of regex components
    public Regex(List<String> component) {
        pattern = new StringBuilder();
        for (String part : component) {
            pattern.append(part); // Appends all parts of the regex
        }
    }

    // Returns the final regex pattern as a String
    public String getPattern() {
        return pattern.toString();
    }

    @Override
    public String toString() {
        return getPattern(); // To print regex pattern when needed
    }
}

public interface RegexBuilder {
    void buildLiteral(String literal); // To add a literal string to the pattern
    void buildAnyCharacter();          // To add '.' which matches any character
    void buildDigit();                 // To add '\d' which matches digits
    void buildWhitespace();            // To add '\s' which matches whitespaces
    void buildWordCharacter();         // To add '\w' which matches word characters
    Regex getResult();                 // To return the final Regex object
}

import java.util.ArrayList;
import java.util.List;


public class ConcreteRegexBuilder implements RegexBuilder {
    private List<String> component = new ArrayList<>(); // To hold regex components

    @Override
    public void buildLiteral(String literal) {
        component.add(literal); // Adds literal part to the pattern
    }

    @Override
    public void buildAnyCharacter() {
        component.add("."); // Adds '.' to match any character
    }

    @Override
    public void buildDigit() {
        component.add("\\d"); // Adds '\d' to match digits
    }

    @Override
    public void buildWhitespace() {
        component.add("\\s"); // Adds '\s' to match whitespaces
    }

    @Override
    public void buildWordCharacter() {
        component.add("\\w"); // Adds '\w' to match word characters
    }

    @Override
    public Regex getResult() {
        return new Regex(component); // Constructs and returns a Regex object
    }
}

public class RegexDirector {
    private RegexBuilder builder;

    // Sets the builder to be used
    public void setBuilder(RegexBuilder builder) {
        this.builder = builder;
    }

    // Constructs a regex pattern by using the builder
    public Regex construct() {
        builder.buildLiteral("Hello");  // Add the literal 'Hello'
        builder.buildWhitespace();      // Add whitespace '\s'
        builder.buildWordCharacter();   // Add word character '\w'
        builder.buildAnyCharacter();    // Add any character '.'
        return builder.getResult();     // Return the built regex
    }
}

