import java.io.File;

public class FileSearch {

    public static String searchFile(String fileName) {
        // Débuter la recherche dans le répertoire documents
        File rootDir = new File("documents");
        return searchInDirectory(rootDir, fileName);
    }

    // Fonction récursive pour parcourir les répertoires et trouver le fichier
    private static String searchInDirectory(File directory, String fileName) {
        if (directory.isDirectory()) {

            // Liste tous les fichiers et sous-répertoires
            File[] files = directory.listFiles();
            
            if (files != null) {

                for (File file : files) {
                    if (file.isDirectory()) {
                        
                        // Recherche récursive dans les sous-répertoires
                        String result = searchInDirectory(file, fileName);
                        
                        if (result != null) {
                            return result;
                        }
                    } else if (file.getName().equals(fileName)) {
                        // Fichier trouvé, retourne le chemin relatif
                        return file.getPath().replace("\\", "/");
                    }
                }
            }
        }
        // Fichier non trouvé dans ce répertoire
        return null;
    }
    
}
