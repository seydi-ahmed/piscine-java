import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

    // Fonction qui retourne la somme des longueurs des chaînes dans le stream
    public static Integer sumOfStringLength(Stream<String> s) {
        return s.mapToInt(String::length).sum();
    }

    // Fonction qui retourne la liste des chaînes en majuscules
    public static List<String> upperCaseAllString(Stream<String> s) {
        return s.map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    // Fonction qui filtre les doubles supérieurs à 42, les transforme en entiers et retourne un set
    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        return s.filter(d -> d > 42)
                .map(Double::intValue)
                .collect(Collectors.toSet());
    }
}
