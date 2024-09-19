import java.util.List;

public class Regex {
    private StringBuilder pattern;

    // Constructeur prenant une liste de composants regex
    public Regex(List<String> component) {
        pattern = new StringBuilder();
        for (String part : component) {
            pattern.append(part); // Concatène toutes les parties de la regex
        }
    }

    // Renvoie le motif regex final sous forme de chaîne de caractères
    public String getPattern() {
        return pattern.toString();
    }

    @Override
    public String toString() {
        return getPattern(); // Pour afficher le motif regex lorsque nécessaire
    }
}
