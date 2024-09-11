/**
 * Templar
 */
public class Templar extends Character
        implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getShield() {
        return this.shield;
    }

    @Override
    public void heal(Character player) throws DeadCharacterException {
        if (player.getCurrentHealth() == 0) {
            throw new DeadCharacterException(player);
        } else if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if ((player.getCurrentHealth() + this.getHealCapacity()) >= player.getMaxHealth()) {
            player.setCurrentHealth(player.getMaxHealth());
        } else {
            player.setCurrentHealth(player.getCurrentHealth() + this.getHealCapacity());
        }
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() == 0) {
            return this.getName() + " has been beaten, even with its " + this.getShield()
                    + " shield. So bad, it could heal " + this.getHealCapacity() + " HP. He has the weapon "
                    + this.getWeapon().toString();
        } else {
            return this.getName() + " is a strong Templar with " + this.getCurrentHealth() + " HP. It can heal "
                    + this.getHealCapacity() + " HP and has a shield of " + this.getShield() + ". He has the weapon "
                    + this.getWeapon().toString();
        }
    }

    public void takeDamage(int damage) throws DeadCharacterException {
        // if (this.getCurrentHealth() == 0) {
        // throw new DeadCharacterException(this);
        // } else {
        if ((damage - this.getShield()) >= this.getCurrentHealth()) {
            if (this.getCurrentHealth() == 0) {
                throw new DeadCharacterException(this);
            } else {
                this.setCurrentHealth(0);
            }
        } else {
            this.setCurrentHealth(this.getCurrentHealth() - (damage - this.getShield()));
        }
        // }
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
                opponent.takeDamage(6);
            }
        }
    }
}