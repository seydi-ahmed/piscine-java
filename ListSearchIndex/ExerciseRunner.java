import java.util.List;

public class ExerciseRunner {
    public static void main(String[] args) {
        System.out.println(ListSearchIndex.findLastIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89));
        System.out.println(ListSearchIndex.findFirstIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89));
        System.out.println(ListSearchIndex.findAllIndexes(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89).toString());
        System.out.println(ListSearchIndex.findAllIndexes(List.of(43784, 327, 1903, 3847, 327, 327, 3289), 43784).toString());
    }
}
//[43784, 327, 1903, 3847, 327, 327, 3289]