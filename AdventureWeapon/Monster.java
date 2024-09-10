// Monster.java
public class Monster extends Character {
    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = (int) Math.floor(damage * 0.8);
        setCurrentHealth(getCurrentHealth() - reducedDamage);
    }

    @Override
    public void attack(Character opponent) {
        int damage = (getWeapon() != null) ? getWeapon().getDamage() : 7;
        opponent.takeDamage(damage);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() > 0) {
            return getName() + " is a monster with " + getCurrentHealth() + " HP.";
        } else {
            return getName() + " is a monster and is dead.";
        }
    }
}
