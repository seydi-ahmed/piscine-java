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

        // Traiter le contenu pour capitaliser uniquement le premier caractère des mots, sans affecter les caractères spéciaux
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
                    capitalizeNext = false;  // Ne capitalise que le premier caractère du mot
                } else {
                    result.append(Character.toLowerCase(c));
                }
                previousWasSpace = false;
            } else if (Character.isWhitespace(c)) {
                if (!previousWasSpace) {  // Ajoute un seul espace pour plusieurs espaces consécutifs
                    result.append(' ');
                    previousWasSpace = true;
                }
                capitalizeNext = true;  // Marque pour capitaliser le prochain mot
            } else {
                result.append(c);  // Caractères spéciaux sont laissés intacts
                previousWasSpace = false;
                capitalizeNext = false;  // Ne pas capitaliser après un caractère spécial
            }
        }

        // Retirer les espaces inutiles à la fin de la chaîne
        return result.toString().trim();
    }
    public static void main(String[] args) throws IOException {
        String[] tab = {"abc.txt", "def.txt"};
        capitalize(tab);
    }

}    


