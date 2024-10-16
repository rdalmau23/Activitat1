package metodes;

import java.io.File;
import java.util.Scanner;

public class Extensio {

    public static void changeSpecificFileExtension() {
        // Crear un Scanner para pedir al usuario el archivo y la nueva extensión
        Scanner scanner = new Scanner(System.in);
        
        // Pedir el nombre del archivo existente
        System.out.println("Escribe el nombre del archivo con su extensión actual (ejemplo: archivo.txt):");
        String fileName = scanner.nextLine();
        
        // Comprobar si el archivo existe en el directorio de trabajo actual
        File file = new File(System.getProperty("user.dir"), fileName);
        if (!file.exists()) {
            System.out.println("El archivo no existe en el directorio de trabajo actual.");
            return;
        }
        
        // Pedir la nueva extensión
        System.out.println("Escribe la nueva extensión sin el punto (ejemplo: png):");
        String newExtension = scanner.nextLine();
        
        // Verificar si la extensión es válida (tres letras, en este caso)
        if (newExtension.length() != 3) {
            System.out.println("La extensión debe tener tres letras.");
            return;
        }

        // Obtener el nombre del archivo sin la extensión actual
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        
        // Crear el nuevo nombre del archivo con la nueva extensión
        String newName = baseName + "." + newExtension;
        
        // Crear un nuevo objeto File con el nuevo nombre
        File renamedFile = new File(System.getProperty("user.dir"), newName);
        
        // Renombrar el archivo
        if (file.renameTo(renamedFile)) {
            System.out.println("Archivo renombrado: " + fileName + " -> " + newName);
        } else {
            System.out.println("Error al renombrar el archivo.");
        }
    }
}
