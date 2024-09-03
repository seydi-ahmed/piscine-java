import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    // Fonction pour créer un fichier avec un nom et du contenu spécifiés
    public static void createFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier: " + e.getMessage());
            throw e;
        }
    }

    // Fonction pour lire le contenu d'un fichier
    public static String getContentFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fichier non trouvé: " + fileName);
            throw e;
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier: " + e.getMessage());
            throw e;
        }

        return content.toString().trim();  // Retirer le dernier saut de ligne
    }

    // Fonction pour supprimer un fichier
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Fichier supprimé: " + fileName);
            } else {
                System.err.println("Échec de la suppression du fichier: " + fileName);
            }
        } else {
            System.err.println("Fichier non trouvé: " + fileName);
        }
    }
}
