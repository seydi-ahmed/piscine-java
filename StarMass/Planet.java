public class Planet extends CelestialObject {
    private Star centerStar;

    // Constructeur par défaut
    public Planet() {
        super();
        this.centerStar = new Star();
    }

    // Constructeur complet
    public Planet(String name, double x, double y, double z, Star centerStar, int mass) {
        super(name, x, y, z, mass);
        this.centerStar = centerStar;
    }

    // Getters et setters
    public Star getCenterStar() { return centerStar; }
    public void setCenterStar(Star centerStar) { this.centerStar = centerStar; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Planet planet = (Planet) obj;
        return centerStar.equals(planet.centerStar);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + centerStar.hashCode();
        return result;
    }

    @Override
    public String toString() {
        double distanceWithCenterStar = getDistanceBetween(this, centerStar);
        return getName() + " circles around " + centerStar.getName() + " at the " + String.format("%.3f", distanceWithCenterStar) + " AU";
    }
}
