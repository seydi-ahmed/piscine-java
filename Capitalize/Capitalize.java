import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java Capitalize <input_file> <output_file>");
            return;
        }

        String inputFilename = args[0];
        String outputFilename = args[1];

        // Lire le contenu du fichier d'entrée
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");  // Ajouter un espace entre les lignes
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFilename);
            return;
        } catch (IOException e) {
            System.err.println("Error reading file: " + inputFilename);
            return;
        }

        // Capitaliser chaque mot dans le contenu et supprimer les espaces inutiles
        String capitalizedContent = capitalizeWords(content.toString().trim());

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
                // Ajouter un seul espace entre les mots
                if (result.length() > 0 && !Character.isWhitespace(result.charAt(result.length() - 1))) {
                    result.append(' ');
                }
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    result.append(c);
                }
            }
        }

        // Supprimer les espaces finaux en trop
        return result.toString().trim();
    }


    public static void main(String[] args) throws IOException {
        String[] tab = {"abc.txt", "def.txt"};
        capitalize(tab);
    }
}
