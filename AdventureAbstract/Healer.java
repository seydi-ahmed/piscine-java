public interface Healer {
    // Méthode pour soigner un personnage
    void heal(Character character);
    
    // Méthode qui retourne la capacité de soin
    int getHealCapacity();
}
