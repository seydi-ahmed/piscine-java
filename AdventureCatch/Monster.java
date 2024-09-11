public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
        // TODO Auto-generated constructor stub
    }

    public void takeDamage(int damage) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        } else {
            int calculDamage = (int) Math.floor(damage * 0.8);
            if (calculDamage >= this.getCurrentHealth()) {
                this.setCurrentHealth(0);
            } else {
                this.setCurrentHealth(this.getCurrentHealth() - calculDamage);
            }
        }
    }

    public void attack(Character opponent) throws DeadCharacterException {
        if (opponent.getCurrentHealth() == 0) {
            throw new DeadCharacterException(opponent);
        } else if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        } else {
            if (this.getWeapon() != null) {
                opponent.takeDamage(this.getWeapon().getDamage());
            } else {
                opponent.takeDamage(7);
            }
        }
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() != 0) {
            return this.getName() + " is a monster with " + this.getCurrentHealth() + " HP. He has the weapon "
                    + this.getWeapon().toString();
        } else {
            return this.getName() + " is a monster and is dead. He has the weapon " + this.getWeapon().toString();
        }
    }
}