import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Galaxy {
    private List<CelestialObject> celestialObjects;
    public static final double KM_IN_ONE_AU = 150_000_000; // Constante ajoutée

    public Galaxy() {
        this.celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void addCelestialObject(CelestialObject celestialObject) {
        this.celestialObjects.add(celestialObject);
    }

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> massRepartition = new HashMap<>();
        int starMass = 0;
        int planetMass = 0;
        int otherMass = 0;

        for (CelestialObject obj : celestialObjects) {
            if (obj instanceof Star) {
                starMass += obj.getMass();
            } else if (obj instanceof Planet) {
                planetMass += obj.getMass();
            } else {
                otherMass += obj.getMass();
            }
        }

        massRepartition.put("Star", starMass);
        massRepartition.put("Planet", planetMass);
        massRepartition.put("Other", otherMass);

        return massRepartition;
    }
}
