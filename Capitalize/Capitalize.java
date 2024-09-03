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

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFilename);
            return;
        } catch (IOException e) {
            System.err.println("Error reading file: " + inputFilename);
            return;
        }

        // Traiter le contenu pour capitaliser les mots en ignorant les caractères non alphabétiques
        String capitalizedContent = capitalizeWords(content.toString());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
            writer.write(capitalizedContent);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + outputFilename);
        }
    }

    private static String capitalizeWords(String text) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        boolean previousWasSpace = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(Character.toLowerCase(c));
                }
                capitalizeNext = false;
                previousWasSpace = false;
            } else if (Character.isWhitespace(c)) {
                if (!previousWasSpace) {  // Ajoute un seul espace lorsqu'il y a plusieurs espaces consécutifs
                    result.append(' ');
                    previousWasSpace = true;
                }
                capitalizeNext = true;
            } else {
                result.append(c);
                previousWasSpace = false;
            }
        }

        // Retirer les espaces en trop à la fin de la chaîne
        return result.toString().trim();
    }
    public static void main(String[] args) throws IOException {
        String[] tab = {"abc.txt", "def.txt"};
        capitalize(tab);
    }
}

