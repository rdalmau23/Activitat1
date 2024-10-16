package metodes;

import java.io.File;
import java.util.Scanner;

public class Extensio {

    public static void changeSpecificFileExtension() {
        
        Scanner scanner = new Scanner(System.in);
        
        // Demana nom per escaner
        System.out.println("Escriu el nom del fitxer amb la seva extensió actual. (exemple: fitxer.jpg)");
        String fileName = scanner.nextLine();
        
        // comprova si existeix al directori actual
        File file = new File(System.getProperty("user.dir"), fileName);
        if (!file.exists()) {
            System.out.println("EL fitxer no existeix");
            return;
        }
        
        // Demana nova extensio
        System.out.println("Escriu la nova extensió. (exemple: png):");
        String newExtension = scanner.nextLine();

        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        
        // Crear nou nom amb nova extensió
        String newName = baseName + "." + newExtension;
        
        // Ara crea nou file
        File renamedFile = new File(System.getProperty("user.dir"), newName);
        
        
        if (file.renameTo(renamedFile)) {
            System.out.println("Fitxer amb extensió canviada: " + fileName + " -> " + newName);
        } else {
            System.out.println("Error.");
        }
    }
}
