public class ComputeArray {
    public static int[] computeArray(int[] array) {
        
        if (array == null) {
            throw new IllegalArgumentException("Le tableau ne peut pas être null");
        }
        
        if (array.length == 0) {
            return new int[0]; // Retourner un tableau vide
        }

        int[] result = new int[array.length];
        
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value % 3 == 0) {
                result[i] = value * 5;
            } else if (value % 3 == 1) {
                result[i] = value + 7;
            } else if (value % 3 == 2) {
                result[i] = value;
            } else {
                result[i] = value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test de la fonction computeArray
        int[] array = ComputeArray.computeArray(new int[]{9, 13, 8, 23, 1, 0, 89});
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println(); // Pour une nouvelle ligne après la sortie
    }
}
