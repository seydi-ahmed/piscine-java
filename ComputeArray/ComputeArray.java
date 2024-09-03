public class ComputeArray {
    public static int[] computeArray(int[] array) {

                // Vérifier si le tableau est null
                if (array == null) {
                    throw new IllegalArgumentException("Le tableau ne peut pas être null");
                }
                
                // Vérifier si le tableau est vide
                if (array.length == 0) {
                    return new int[0]; // Retourner un tableau vide
                }

        int[] result = new int[array.length];

        // Parcourir chaque élément du tableau d'entrée
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value % 3 == 0) {
                // Si l'élément est un multiple de 3, le multiplier par 5
                result[i] = value * 5;
            } else if (value % 3 == 1) {
                // Si l'élément est de la forme 3k + 1, l'incrémenter de 7
                result[i] = value + 7;
            } else {
                // Si l'élément est de la forme 3k + 2, le laisser inchangé
                result[i] = value;
            }
        }

        return result;
    }

    // public static void main(String[] args) {
    //     // Test de la fonction computeArray
    //     int[] array = ComputeArray.computeArray(new int[]{9, 13, 8, 23, 1, 0, 89});
    //     for (int i : array) {
    //         System.out.println(i + " ");
    //     }
    // }
}
