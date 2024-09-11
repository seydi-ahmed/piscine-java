import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    // Fonction pour l'union de deux ensembles
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> resultSet = new HashSet<>(set1);  // Crée une copie de set1
        resultSet.addAll(set2);  // Ajoute tous les éléments de set2
        return resultSet;
    }

    // Fonction pour l'intersection de deux ensembles
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> resultSet = new HashSet<>(set1);  // Crée une copie de set1
        resultSet.retainAll(set2);  // Garde uniquement les éléments présents dans set2
        return resultSet;
    }
}
