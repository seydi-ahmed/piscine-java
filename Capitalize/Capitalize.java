import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        // Vérifier que le tableau d'arguments contient exactement deux fichiers
        if (args.length != 2) {
            System.err.println("Usage: java Capitalize <input_file> <output_file>");
            return;
        }

        // Récupérer les noms des fichiers d'entrée et de sortie
        String inputFilename = args[0];
        String outputFilename = args[1];

        // Lire le contenu du fichier d'entrée
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFilename);
            return;
        } catch (IOException e) {
            System.err.println("Error reading file: " + inputFilename);
            return;
        }

        // Capitaliser chaque mot dans le contenu
        String capitalizedContent = capitalizeWords(content.toString());

        // Écrire le contenu capitalisé dans le fichier de sortie
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
            writer.write(capitalizedContent);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + outputFilename);
        }
    }

    private static String capitalizeWords(String text) {
        // Utiliser StringBuilder pour construire le texte capitalisé
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
                result.append(c);
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
