public class Sorcerer extends Character implements Healer {
    private int healCapacity;

    // Constructeur avec les paramètres name, maxHealth et healCapacity
    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);  // Appel du constructeur de Character
        this.healCapacity = healCapacity;
    }

    // Implémentation de la méthode getHealCapacity de l'interface Healer
    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    // Implémentation de la méthode heal de l'interface Healer
    @Override
    public void heal(Character character) {
        // Ajout de la capacité de soin à la santé actuelle du personnage
        character.currentHealth += this.healCapacity;
        // On s'assure que la santé actuelle ne dépasse pas la santé maximale
        if (character.currentHealth > character.getMaxHealth()) {
            character.currentHealth = character.getMaxHealth();
        }
    }

    // Surcharge de la méthode toString pour donner une description du Sorcier
    @Override
    public String toString() {
        if (this.currentHealth > 0) {
            return this.getName() + " is a sorcerer with " + this.currentHealth + " HP. It can heal " + this.healCapacity + " HP.";
        } else {
            return this.getName() + " is a dead sorcerer. So bad, it could heal " + this.healCapacity + " HP.";
        }
    }
}
