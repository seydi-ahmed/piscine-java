import java.util.*;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return list;
        }
        // list.stream().sorted();
        //Collections.sort(list);
        List<Integer> sortedList = list.stream().sorted(Comparator.naturalOrder()).toList();
        return sortedList;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        List<Integer> reverseList = new ArrayList<Integer>();
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return reverseList;
        }
        //List<Integer> sortedList = list.stream().sorted().collect(null);
        //Collections.sort(list, Collections.reverseOrder());
        reverseList = list.stream().sorted(Comparator.reverseOrder()).toList();
        // for (int i = sortedList.size()-1; i > 0; i--) {
        //     reverseList.add(sortedList.get(i));
        // }
        //return reverseList;
        return reverseList;
    }

}