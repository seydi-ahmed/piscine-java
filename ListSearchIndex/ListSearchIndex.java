import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        if (list.lastIndexOf(value) == -1) {
            return null;
        } else {
            return list.lastIndexOf(value);
        }
    }
    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        if (list.indexOf(value) == -1) {
            return null;
        } else {
            return list.indexOf(value);
        }
    }
    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        if (list == null) {
            return indexList;
        }
        if (list.isEmpty() || list.size() == 0) {
            return indexList;
        }
        if (list.contains(value)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(value)) {
                    indexList.add(i);
                }
            }
        } else {
            return indexList;
        }
        return indexList;
    }
}