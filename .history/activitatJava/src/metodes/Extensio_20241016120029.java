package metodes;

import java.io.File;
import java.util.Scanner;

public class Extensio {

    public static void changeFileExtensions() {
        // Crear un Scanner para pedir al usuario las extensiones
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe dos extensiones (separadas por un espacio):");
        String input = scanner.nextLine();
        
        // Dividir las dos extensiones
        String[] extensions = input.split(" ");
        if (extensions.length != 2 || extensions[0].length() != 3 || extensions[1].length() != 3) {
            System.out.println("Por favor, ingresa dos extensiones de tres letras cada una.");
            return;
        }

        String oldExtension = extensions[0];
        String newExtension = extensions[1];

        // Obtener el directorio de trabajo actual
        File currentDir = new File(System.getProperty("user.dir"));

        // Listar todos los archivos en el directorio actual
        File[] files = currentDir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No hay archivos en el directorio actual.");
            return;
        }

        // Procesar cada archivo en el directorio
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith("." + oldExtension)) {
                // Obtener el nombre del archivo sin la extensión anterior
                String newName = file.getName().replace("." + oldExtension, "." + newExtension);
                
                // Crear un nuevo archivo con el nuevo nombre
                File renamedFile = new File(currentDir, newName);
                
                // Renombrar el archivo
                if (file.renameTo(renamedFile)) {
                    System.out.println("Archivo renombrado: " + file.getName() + " -> " + newName);
                } else {
                    System.out.println("Error al renombrar el archivo: " + file.getName());
                }
            }
        }
    }
}
