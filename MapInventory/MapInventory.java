import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapInventory {
    public static int getProductPrice(Map<String, Integer> inventory, String productId) {
        if (inventory.containsKey(productId)) {
            return inventory.get(productId);
        } else {
            return -1;
        }
    }

    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
        List<String> list = new ArrayList<String>();
        if (inventory.containsValue(price)) {
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                if (entry.getValue() == price) {
                    list.add(entry.getKey());
                }
                // System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            return list;
        } else {
            return list;
        }
    }
}