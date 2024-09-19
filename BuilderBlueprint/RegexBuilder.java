public interface RegexBuilder {
    void buildLiteral(String literal); // Pour ajouter une chaîne littérale au motif
    void buildAnyCharacter();          // Pour ajouter '.' qui correspond à n'importe quel caractère
    void buildDigit();                 // Pour ajouter '\d' qui correspond aux chiffres
    void buildWhitespace();            // Pour ajouter '\s' qui correspond aux espaces blancs
    void buildWordCharacter();         // Pour ajouter '\w' qui correspond aux caractères alphanumériques
    Regex getResult();                 // Pour renvoyer l'objet Regex final
}
