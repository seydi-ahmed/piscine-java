import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> coinList = new ArrayList<>(coins);  // Convertir le set en liste
        Collections.sort(coinList, Collections.reverseOrder());  // Trier les pièces par ordre décroissant
        List<Integer> change = new ArrayList<>();  // Liste pour stocker les pièces de change

        for (int coin : coinList) {
            while (amount >= coin) {  // Ajouter autant de fois la pièce tant que c'est possible
                change.add(coin);
                amount -= coin;
            }
        }

        return change;  // Retourner la liste des pièces
    }
}
