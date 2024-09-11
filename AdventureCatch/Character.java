import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private Weapon weapon;
    private static List<Character> allCharacters = new ArrayList<Character>();

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

    public abstract void takeDamage(int damage) throws DeadCharacterException;
    public abstract void attack(Character opponent) throws DeadCharacterException;

    protected void setCurrentHealth(int newValue) {
        this.currentHealth = newValue;
    }

    @Override
    public String toString() {
        if (this.currentHealth > 0) {
            return getName() + " : " + getCurrentHealth()+"/"+getMaxHealth();
        } else {
            return getName() + " : KO";
        }
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
        while (warrior1.currentHealth > 0 && warrior2.currentHealth > 0) {
            try {
                warrior1.attack(warrior2);
            } catch (DeadCharacterException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (warrior2.currentHealth == 0) {
                break;
            }
            try {
                warrior2.attack(warrior1);
            } catch (DeadCharacterException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (warrior1.currentHealth == 0) {
            return warrior2;
        } else {
            return warrior1;
        }
    }
}