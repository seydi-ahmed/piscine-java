import java.util.List;

public class ListContains {
    public static boolean containsValue(List<Integer> list, Integer value) {
        return list.contains(value);
        // for (int element : list) {
        //     if (element == value) {
        //         return true;
        //     }
        // }
        // return false;
    }
}