public class AverageCalc {
    public static int average(int start, int end, int step) {

        // Initialisation des variables pour la somme et le nombre de termes
        int sum = 0;
        int count = 0;

        // Boucle pour calculer la somme des nombres
        for (int i = start; i <= end; i += step) {
            sum += i;
            count++;
        }

        // Retourne 0 si aucun nombre n'a été trouvé (évite une division par zéro)
        if (count == 0) {
            return 0;
        } else {
            return sum / count;
        }
    }

    public static void main(String[] args) {
        System.out.println(AverageCalc.average(1,5,1));
    }
}