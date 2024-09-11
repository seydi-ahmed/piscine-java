import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {

    // Fonction qui mappe la première lettre majuscule à une liste de Strings commençant par cette lettre
    public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {
        return s.collect(Collectors.groupingBy(
            str -> Character.toUpperCase(str.charAt(0))
        ));
    }

    // Fonction qui groupe les entiers par modulo 4 et retourne le maximum de chaque groupe
    public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer> s) {
        return s.collect(Collectors.groupingBy(
            num -> num % 4, 
            Collectors.maxBy(Comparator.naturalOrder())
        ));
    }

    // Fonction qui trie les Strings par ordre alphabétique et les concatène avec ' # ' entre chaque
    public static String orderAndConcatWithSharp(Stream<String> s) {
        return s.sorted()
                .collect(Collectors.joining(" # ", "{", "}"));
    }
}
