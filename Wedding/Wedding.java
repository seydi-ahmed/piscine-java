import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        // Convertir les ensembles en listes pour permettre le shuffle
        ArrayList<String> firstList = new ArrayList<>(first);
        ArrayList<String> secondList = new ArrayList<>(second);

        // Mélanger les deux listes pour les associations aléatoires
        Collections.shuffle(firstList);
        Collections.shuffle(secondList);

        // Créer une Map pour stocker les couples
        Map<String, String> couples = new HashMap<>();

        // Associer chaque élément des deux listes jusqu'à la plus petite taille
        int minSize = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < minSize; i++) {
            couples.put(firstList.get(i), secondList.get(i));
        }

        return couples;
    }
}
