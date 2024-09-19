public class ExerciseRunner {
    public static void main(String[] args) {
        // Create the director and builder
        RegexDirector director = new RegexDirector();
        RegexBuilder builder = new ConcreteRegexBuilder();

        // Set the builder and construct the regex
        director.setBuilder(builder);
        Regex regex = director.construct();

        // Print the resulting regex pattern
        System.out.println(regex.getPattern());
    }
}
