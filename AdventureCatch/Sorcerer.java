public class Sorcerer extends Character
        implements Healer {

    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    public void heal(Character warrior) throws DeadCharacterException {
        if (warrior.getCurrentHealth() == 0) {
            throw new DeadCharacterException(warrior);
        } else if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if ((this.healCapacity + warrior.getCurrentHealth()) >= warrior.getMaxHealth()) {
            warrior.setCurrentHealth(warrior.getMaxHealth());
        } else {
            warrior.setCurrentHealth(warrior.getCurrentHealth() + this.healCapacity);
        }
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() == 0) {
            return this.getName() + " is a dead sorcerer. So bad, it could heal " + this.healCapacity
                    + " HP. He has the weapon " + this.getWeapon().toString();
        } else {
            return this.getName() + " is a sorcerer with " + this.getCurrentHealth() + " HP. It can heal "
                    + this.healCapacity + " HP. He has the weapon " + this.getWeapon().toString();
        }
    }

    public void takeDamage(int damage) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        } else {
            if ((damage) >= this.getCurrentHealth()) {
                this.setCurrentHealth(0);
            } else {
                this.setCurrentHealth(this.getCurrentHealth() - damage);
            }
        }
    }

    public void attack(Character opponent) throws DeadCharacterException {
        if (opponent.getCurrentHealth() == 0) {
            throw new DeadCharacterException(opponent);
        } else if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        } else {
            this.heal(this);
            if (this.getWeapon() != null) {
                opponent.takeDamage(this.getWeapon().getDamage());
            } else {
                opponent.takeDamage(10);
            }
        }
    }
}