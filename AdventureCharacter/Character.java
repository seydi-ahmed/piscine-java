public class Character {
    // Propriétés privées avec les modificateurs d'accès appropriés
    private final int maxHealth; // Utilisation du mot-clé 'final' car non modifiable
    private int currentHealth;
    private final String name; // Utilisation du mot-clé 'final' car non modifiable

    // Constructeur avec deux paramètres
    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth; // currentHealth est initialisé avec maxHealth
    }

    // Getter pour maxHealth
    public int getMaxHealth() {
        return maxHealth;
    }

    // Getter pour currentHealth
    public int getCurrentHealth() {
        return currentHealth;
    }

    // Getter pour name
    public String getName() {
        return name;
    }

    // Méthode toString pour afficher le personnage avec le format demandé
    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " : KO"; // Si currentHealth est 0, retourne KO
        }
        return name + " : " + currentHealth + "/" + maxHealth; // Sinon, retourne l'état courant
    }

    // Méthode takeDamage qui réduit la santé courante
    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0; // currentHealth ne peut pas être en dessous de 0
        }
    }

    // Méthode attack qui inflige 9 points de dégâts à un autre personnage
    public void attack(Character target) {
        target.takeDamage(9); // L'autre personnage reçoit 9 points de dégâts
    }
}
