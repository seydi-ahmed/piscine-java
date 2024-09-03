public class SortArgs {
    public static void sort(String[] args) {
        
        if (args == null || args.length == 0){
            System.out.println("\n");
            return;
        }

        for (int i = 0; i < args.length; i++){
            for (int j = i+1; j < args.length; j++){
                int valeuri = Integer.parseInt(args[i]);
                int valeurj = Integer.parseInt(args[j]);
                if (valeuri > valeurj) {
                    String temoin = args[i];
                    args[i] = args[j];
                    args[j] = temoin;
                }
            }
        }

        for (int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }

    // public static void main(String[] args) {
    //     String[] tab = {"23", "2", "13", "3"};

    //     sort(tab);
    // }
}
