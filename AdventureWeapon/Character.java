// Character.java
import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private final Weapon weapon;
    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        allCharacters.add(this);
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public String getName() {
        return this.name;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public abstract void takeDamage(int damage);

    public abstract void attack(Character opponent);

    protected void setCurrentHealth(int newValue) {
        if (newValue < 0) {
            this.currentHealth = 0;
        } else if (newValue > this.maxHealth) {
            this.currentHealth = this.maxHealth;
        } else {
            this.currentHealth = newValue;
        }
    }

    @Override
    public String toString() {
        String result = this.name;
        if (this.currentHealth > 0) {
            result += " : " + this.currentHealth + "/" + this.maxHealth;
        } else {
            result += " : KO";
        }
        if (this.weapon != null) {
            result += ". He has the weapon " + this.weapon.toString() + ".";
        }
        return result;
    }

    public static String printStatus() {
        String result = "------------------------------------------\n";
        if (allCharacters.isEmpty()) {
            result += "Nobody's fighting right now !\n";
        } else {
            result += "Characters currently fighting :\n";
            for (Character warrior : allCharacters) {
                result += " - " + warrior.toString() + "\n";
            }
        }
        result += "------------------------------------------\n";
        return result;
    }

    public static Character fight(Character warrior1, Character warrior2) {
        while (warrior1.getCurrentHealth() > 0 && warrior2.getCurrentHealth() > 0) {
            warrior1.attack(warrior2);
            if (warrior2.getCurrentHealth() == 0) {
                break;
            }
            warrior2.attack(warrior1);
        }
        if (warrior1.getCurrentHealth() == 0) {
            return warrior2;
        } else {
            return warrior1;
        }
    }
}
