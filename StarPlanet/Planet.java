import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    // Constructeur par défaut
    public Planet() {
        super();
        this.centerStar = new Star();
    }

    // Constructeur avec paramètres
    public Planet(String name, double x, double y, double z, Star centerStar) {
        super(name, x, y, z);
        this.centerStar = centerStar;
    }

    // Getter pour centerStar
    public Star getCenterStar() {
        return centerStar;
    }

    // Setter pour centerStar
    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    // Méthode equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Planet planet = (Planet) obj;
        return Objects.equals(centerStar, planet.centerStar);
    }

    // Méthode hashCode
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centerStar);
    }

    // Méthode toString
    @Override
    public String toString() {
        // Calculer la distance en utilisant la méthode statique de la classe parent
        double distanceWithCenterStar = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), distanceWithCenterStar);
    }


    /*****************************MAIN******************************/
    public static void main(String[] args) {
        Planet earth = new Planet();
        Planet naboo = new Planet("Naboo", 17.4389, 8349.1, 8943.92, new Star("Betelgeuse", 128.23, -12.82, 32.328, 1289.3));

        System.out.println(naboo.toString());
        System.out.println(earth.toString());
        System.out.println(naboo.getCenterStar().toString());
    }

}
