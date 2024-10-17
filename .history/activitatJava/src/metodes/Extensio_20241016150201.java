package metodes;

import java.io.File;
import java.util.Scanner;

public class Extensio {

    public static void canviaExtensio() {
        
        
        Scanner scanner = new Scanner(System.in);
        
        // Demanar la ruta completa  o relativa del fitxer
        System.out.println("Escriu la ruta completa del fitxer amb la seva extensió actual (exemple: /home/usuari/fitxer.jpg o C:\\Users\\Usuari\\fitxer.jpg):");
        String filePath = scanner.nextLine();
        
        // Comprovar si existeix el fitxer i si no es aixi adverteix de l'error
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("El fitxer no existeix.");
            return;
        }
        
        // Demanar la nova extensió
        System.out.println("Escriu la nova extensió (sense el punt). Exemple: png");
        String newExtension = scanner.nextLine();

        // Obtenir el nom base del fitxer sense l'extensió actual
        String baseName = filePath.substring(0, filePath.lastIndexOf('.'));
        
        // Crear el nou nom amb la nova extensió
        String newName = baseName + "." + newExtension;
        
        // Crear un objecte file
        File renamedFile = new File(newName);
        
        if (file.renameTo(renamedFile)) {
            System.out.println("Fitxer amb extensió canviada de " + filePath + " a " + newName);
        } else {
            System.out.println("Error al canviar l'extensió del fitxer.");
        }
    }
}
