package metodes;

import java.io.File;
import java.util.Scanner;

public class Extensio {

    public static void canviaExtensio() {
        
        // Crear un escàner per demanar al usuari la ruta del fitxer
        Scanner scanner = new Scanner(System.in);
        
        // Demanar la ruta completa o relativa del fitxer
        System.out.println("Escriu la ruta completa del fitxer amb la seva extensió actual (exemple: /home/usuari/fitxer.jpg o C:\\Users\\Usuari\\fitxer.jpg):");
        String filePath = scanner.nextLine();
        
        // Comprovar si el fitxer existeix
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("El fitxer no existeix a la ruta especificada.");
            return;
        }
        
        // Demanar la nova extensió
        System.out.println("Escriu la nova extensió (sense el punt). Exemple: png");
        String newExtension = scanner.nextLine();

        // Obtenir el nom base del fitxer (sense l'extensió actual)
        String baseName = filePath.substring(0, filePath.lastIndexOf('.'));
        
        // Crear el nou nom amb la nova extensió
        String newName = baseName + "." + newExtension;
        
        // Crear un objecte File per al fitxer renombrat
        File renamedFile = new File(newName);
        
        // Renombrar el fitxer
        if (file.renameTo(renamedFile)) {
            System.out.println("Fitxer amb extensió canviada: " + filePath + " -> " + newName);
        } else {
            System.out.println("Error al canviar l'extensió del fitxer.");
        }
    }

    public static void main(String[] args) {
        canviaExtensio();
    }
}
