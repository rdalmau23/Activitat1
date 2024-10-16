package metodes;

import java.io.File;
import java.util.Scanner;

public class Directori {

    public static void mostrarDirectoriPare() {
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriu la ruta del directori origen:");
        String origenPath = scanner.nextLine();
        
        // Crear un objecte File per al directori origen
        File currentDir = new File(origenPath);
        
        // Verificar si el directori existeix i és vàlid
        if (!currentDir.exists() || !currentDir.isDirectory()) {
            System.out.println("El directori no existeix");
            return;
        }
        
        // Recórrer els directoris pares fins arribar a l'arrel
        while (currentDir != null) {
            // Mostrar la informació del directori actual
            System.out.println("Directori: " + currentDir.getAbsolutePath());
            System.out.println("Espai lliure: " + currentDir.getFreeSpace() / (1024 * 1024) + " MB");
            System.out.println("Espai total: " + currentDir.getTotalSpace() / (1024 * 1024) + " MB");
            System.out.println("Espai utilitzable: " + currentDir.getUsableSpace() / (1024 * 1024) + " MB");
            System.out.println("---------------------------");
            
            // Passar al directori pare
            currentDir = currentDir.getParentFile();
        }
    }
}
