public class Excalibur {
    // Nom de l'Excalibur
    private String name;

    // Instance unique de la classe
    private static Excalibur INSTANCE;

    // Constructeur privé pour empêcher l'instanciation externe
    private Excalibur(String name) {
        this.name = name;
    }

    // Méthode pour obtenir l'instance unique de la classe
    public static Excalibur getInstance() {
        // Création de l'instance unique si elle n'existe pas encore
        if (INSTANCE == null) {
            INSTANCE = new Excalibur("Sword");
        }
        return INSTANCE;
    }

    // Méthode pour obtenir le nom de l'Excalibur
    public String getName() {
        return name;
    }

    public static void main(String[] args)  {
        System.out.println(Excalibur.getInstance().getName());
    }

}
