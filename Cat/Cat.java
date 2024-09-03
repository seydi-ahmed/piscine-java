import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Cat {
    public static void cat(String[] args) throws IOException {
        // Vérifier que le tableau d'arguments contient exactement un fichier
        if (args.length != 1) {
            System.err.println("Usage: java Cat <filename>");
            return;
        }

        // Récupérer le nom du fichier
        String filename = args[0];

        // Ouvrir le fichier en mode lecture binaire
        try (FileInputStream fis = new FileInputStream(filename)) {
            // Créer un buffer pour lire les données en morceaux
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Lire le fichier en morceaux et écrire le contenu sur la sortie standard
            while ((bytesRead = fis.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
        }
    }
}
