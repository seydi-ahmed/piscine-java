public class EpargnePierre {

    public static void main(String[] args) {
        
        double capital = 500_000;
        double tauxInteret = 0.02;
        double depotAnnuel = 20_000;
        double objectif = 1_000_000;

        int annees = 0;

        while (capital <= objectif) {
            annees++;
            capital += capital * tauxInteret;
            capital += depotAnnuel;
        }

        System.out.println("Il faudra " + annees + " années pour dépasser 1 000 000 F.");
        System.out.printf("Le capital final sera de %.2f F.%n", capital);
    }
}
