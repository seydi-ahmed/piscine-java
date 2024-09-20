import java.util.ArrayList;
import java.util.List;

public class ConcreteRegexBuilder implements RegexBuilder {
    private List<String> component = new ArrayList<>(); // Pour contenir les composants de la regex

    @Override
    public void buildLiteral(String literal) {
        component.add(literal); // Ajoute la partie littérale au motif
    }

    @Override
    public void buildAnyCharacter() {
        component.add("."); // Ajoute '.' pour correspondre à n'importe quel caractère
    }

    @Override
    public void buildDigit() {
        component.add("\\d"); // Ajoute '\d' pour correspondre aux chiffres
    }

    @Override
    public void buildWhitespace() {
        component.add("\\s"); // Ajoute '\s' pour correspondre aux espaces blancs
    }

    @Override
    public void buildWordCharacter() {
        component.add("\\w"); // Ajoute '\w' pour correspondre aux caractères alphanumériques
    }

    @Override
    public Regex getResult() {
        return new Regex(component); // Construit et renvoie un objet Regex
    }



// **********************************************************************************************************************************

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().whoAreYou());
    }
}
