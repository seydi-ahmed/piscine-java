// Templar.java
public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public int getShield() {
        return this.shield;
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
        int effectiveDamage = Math.max(damage - this.shield, 0);
        setCurrentHealth(getCurrentHealth() - effectiveDamage);
    }

    @Override
    public void attack(Character opponent) {
        heal(this); // Heal itself
        opponent.takeDamage(6);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " has been beaten, even with its " + this.shield 
                + " shield. So bad, it could heal " + this.healCapacity + " HP.";
        } else {
            return getName() + " is a strong Templar with " + getCurrentHealth() 
                + " HP. It can heal " + this.healCapacity + " HP and has a shield of " + this.shield + ".";
        }
    }
}
