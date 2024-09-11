/**
 * Healer
 */
public interface Healer {

    void heal(Character player) throws DeadCharacterException;

    int getHealCapacity();
}