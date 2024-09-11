import java.util.stream.Stream;

public class StreamReduce {

    // Fonction qui retourne la somme des entiers dans le stream
    public static Integer sumAll(Stream<Integer> s) {
        return s.reduce(0, Integer::sum);
    }

    // Fonction qui divise tous les entiers par le diviseur et en fait la somme
    public static Integer divideAndAddElements(Stream<Integer> s, int divider) {
        return s.map(n -> n / divider)
                .reduce(0, Integer::sum);
    }
}
