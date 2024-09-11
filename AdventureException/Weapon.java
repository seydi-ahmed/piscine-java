public class Weapon {
    private final String name;
    private final int damage;
    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
    public int getDamage() {
        return this.damage;
    }
    public String getName() {
        return this.name;
    }
    public void takeDamage(int damage) {
    }
    public void attack(Character opponent) {
    }
    @Override
    public String toString() {
        return this.getName() + " deals " + this.getDamage() + " damages";
    }
}