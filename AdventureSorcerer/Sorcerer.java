public class Sorcerer extends Character
    implements Healer {
    private final int healCapacity;
    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }
    public int getHealCapacity() {
        return this.healCapacity;
    }
    public void heal(Character warrior) {
        if ((this.healCapacity + warrior.getCurrentHealth()) >= warrior.getMaxHealth()) {
            warrior.setCurrentHealth(warrior.getMaxHealth());
        } else {
            warrior.setCurrentHealth(warrior.getCurrentHealth() + this.healCapacity);
        } 
    }
    @Override
    public String toString() {
        if (this.getCurrentHealth() == 0) {
            return this.getName() + " is a dead sorcerer. So bad, it could heal " + this.healCapacity + " HP.";
        } else {
            return this.getName() + " is a sorcerer with " + this.getCurrentHealth() + " HP. It can heal " + this.healCapacity + " HP.";
        }
    }
}