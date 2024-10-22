package metodes;

import java.io.File;
import java.util.Scanner;

public class LlistaFitxers {
    public static void llistarFixers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIntrodueix el nom del directori: ");
        String nomDirectori = scanner.nextLine();

        File directori = new File(nomDirectori);

        if (directori.exists() && directori.isDirectory()) {
            llistarFitxers(directori);
        } else {
            System.out.println("El directori no existeix o no és un directori vàlid.");
        }

        scanner.close();
    }

    private static void llistarFitxers(File directori) {
        File[] fitxers = directori.listFiles();

        if (fitxers != null && fitxers.length > 0) {
            System.out.println("Fitxers dins del directori " + directori.getName() + ":");
            for (File fitxer : fitxers) {
                if (fitxer.isFile()) {
                    System.out.println("Fitxer: " + fitxer.getName());
                } else if (fitxer.isDirectory()) {
                    System.out.println("Carpeta: " + fitxer.getName());
                }
            }
        } else {
            System.out.println("El directori està buit.");
        }
    }
}
