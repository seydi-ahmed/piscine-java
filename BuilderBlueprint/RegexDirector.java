public class RegexDirector {
    private RegexBuilder builder;

    // Définit le constructeur à utiliser
    public void setBuilder(RegexBuilder builder) {
        this.builder = builder;
    }

    // Construit un motif regex en utilisant le constructeur
    public Regex construct() {
        builder.buildLiteral("Hello");  // Ajoute le littéral 'Hello'
        builder.buildWhitespace();      // Ajoute un espace blanc '\s'
        builder.buildWordCharacter();   // Ajoute un caractère alphanumérique '\w'
        builder.buildAnyCharacter();    // Ajoute n'importe quel caractère '.'
        return builder.getResult();     // Renvoie le motif regex construit
    }
}
