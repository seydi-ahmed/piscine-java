public class AverageCalc {
    public static int average(int start, int end, int step) {
        // Vérifiez que le step est positif pour éviter une boucle infinie
        if (step <= 0) {
            throw new IllegalArgumentException("Step must be greater than 0");
        }

        // Initialisation des variables pour la somme et le nombre de termes
        int sum = 0;
        int count = 0;

        // Boucle pour calculer la somme des nombres
        for (int i = start; i <= end; i += step) {
            sum += i;
            count++;
        }

        // Calculer la moyenne
        // Retourne 0 si aucun nombre n'a été trouvé (évite une division par zéro)
        return (count == 0) ? 0 : (sum / count);
    }

    public static void main(String[] args) {
        System.out.println(AverageCalc.average(1,5,1));
    }
}
