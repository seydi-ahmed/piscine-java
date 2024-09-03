import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        // Vérifier que le tableau d'arguments contient exactement un fichier
        if (args.length != 1) {
            System.err.println("Usage: java CatInFile <output_filename>");
            return;
        }

        // Récupérer le nom du fichier de sortie
        String outputFilename = args[0];

        // Ouvrir le fichier de sortie en mode écriture binaire
        try (FileOutputStream fos = new FileOutputStream(outputFilename)) {
            // Créer un buffer pour lire les données en morceaux
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Lire depuis l'entrée standard et écrire dans le fichier
            while ((bytesRead = System.in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + outputFilename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + outputFilename);
        }
    }
}
