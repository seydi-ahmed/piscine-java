import java.util.ArrayList;
import java.util.List;

public class Character {
    // Propriétés privées avec les modificateurs d'accès appropriés
    private final int maxHealth;
    private int currentHealth;
    private final String name;

    // Liste statique pour garder une trace de tous les personnages créés
    private static List<Character> allCharacters = new ArrayList<>();

    // Constructeur avec deux paramètres
    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        allCharacters.add(this);  // Ajouter le personnage à la liste statique
    }

    // Getters pour les propriétés
    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    // Méthode toString pour afficher le personnage avec le format demandé
    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " : KO";  // Si currentHealth est 0, retourne KO
        }
        return name + " : " + currentHealth + "/" + maxHealth;
    }

    // Méthode takeDamage qui réduit la santé courante
    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;  // currentHealth ne peut pas être en dessous de 0
        }
    }

    // Méthode attack qui inflige 9 points de dégâts à un autre personnage
    public void attack(Character target) {
        target.takeDamage(9);  // L'autre personnage reçoit 9 points de dégâts
    }

    // Méthode statique pour afficher le statut de tous les personnages
    public static String printStatus() {
        if (allCharacters.isEmpty()) {
            return "------------------------------------------\nNobody's fighting right now !\n------------------------------------------";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------\n");
        sb.append("Characters currently fighting : \n");
        for (Character character : allCharacters) {
            sb.append(" - ").append(character.toString()).append("\n");
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }


    // Méthode statique pour gérer un combat entre deux personnages
    public static Character fight(Character c1, Character c2) {
        while (c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {
            c1.attack(c2);  // c1 attaque c2
            if (c2.getCurrentHealth() > 0) {
                c2.attack(c1);  // c2 attaque c1 si c2 n'est pas KO
            }
        }
        return c1.getCurrentHealth() > 0 ? c1 : c2;  // Retourne le vainqueur
    }


    public static void main(String[] args) {
        System.out.println(Character.printStatus());

        Character aragorn = new Character("Aragorn", 20);
        Character uruk = new Character("Uruk", 15);

        System.out.println(Character.printStatus());

        Character winner = Character.fight(aragorn, uruk);

        System.out.println(winner.toString());
        System.out.println(Character.printStatus());
    }

}
