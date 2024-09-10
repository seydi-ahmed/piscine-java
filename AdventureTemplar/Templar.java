// Templar.java
public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    // Constructeur avec les 4 paramètres : name, maxHealth, healCapacity et shield
    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    // Implémentation de la méthode getHealCapacity de l'interface Healer
    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    // Implémentation de la méthode heal de l'interface Healer
    @Override
    public void heal(Character character) {
        if (character.getCurrentHealth() + this.healCapacity > character.getMaxHealth()) {
            character.setCurrentHealth(character.getMaxHealth());
        } else {
            character.setCurrentHealth(character.getCurrentHealth() + this.healCapacity);
        }
    }

    // Implémentation de la méthode getShield de l'interface Tank
    @Override
    public int getShield() {
        return this.shield;
    }

    // Redéfinition de la méthode toString
    @Override
    public String toString() {
        if (this.getCurrentHealth() == 0) {
            return this.getName() + " has been beaten, even with its " + this.shield 
                + " shield. So bad, it could heal " + this.healCapacity + " HP.";
        } else {
            return this.getName() + " is a strong Templar with " + this.getCurrentHealth() 
                + " HP. It can heal " + this.healCapacity + " HP and has a shield of " + this.shield + ".";
        }
    }
}
