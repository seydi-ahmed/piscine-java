// Sorcerer.java
public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public void heal(Character character) {
        if (character.getCurrentHealth() + this.healCapacity > character.getMaxHealth()) {
            character.setCurrentHealth(character.getMaxHealth());
        } else {
            character.setCurrentHealth(character.getCurrentHealth() + this.healCapacity);
        }
    }

    @Override
    public void takeDamage(int damage) {
        setCurrentHealth(getCurrentHealth() - damage);
    }

    @Override
    public void attack(Character opponent) {
        heal(this); // Heal itself
        opponent.takeDamage(10);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " is a dead sorcerer. So bad, it could heal " + this.healCapacity + " HP.";
        } else {
            return getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + this.healCapacity + " HP.";
        }
    }
}
