package metodes;

import java.io.File;
import java.util.Scanner;

public class DirectoriPare {

    public static void mostrarDirectoris() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIntrodueix la ruta d'un fitxer o carpeta: ");
        String ruta = scanner.nextLine();

        File fitxer = new File(ruta);

        if (fitxer.exists()) {
            mostrarPares(fitxer);
        } else {
            System.out.println("El directori no existeix.");
        }

        scanner.close();
    }

    private static void mostrarPares(File fitxer) {
        File directorioPadre = fitxer.getParentFile();

        while (directorioPadre != null) {
            System.out.println("Directori pare: " + directorioPadre.getAbsolutePath());

            directorioPadre = directorioPadre.getParentFile();
        }
        
        System.out.println("No hi han més pares... :()");
    }
}
