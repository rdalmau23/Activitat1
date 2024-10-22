package metodes;

import java.io.File;
import java.util.Scanner;

public class LlistaFitxers{
    public static void llistarFixers() {
    Scanner scanner = new Scanner(System.in);  // Demanar el nom del directori

    System.out.print("\n Introdueix el nom del directori: ");
    String nomDirectori = scanner.nextLine();

    // Crear un objecte File amb el nom del directori introduït
    File directori = new File(nomDirectori);

    // Comprovar si és un directori i si existeix
    if (directori.exists() && directori.isDirectory()) {
        llistarFitxers(directori);  // Si el directori existeix, llistar els fitxers
    } else {
        System.out.println("El directori no existeix o no és un directori vàlid.");
    }

    scanner.close();
}

// Mètode per llistar els fitxers dins d'un directori
private static void llistarFitxers(File directori) {
    // Llistar els fitxers dins del directori
    File[] fitxers = directori.listFiles();

    if (fitxers != null && fitxers.length > 0) {
        System.out.println("Fitxers dins del directori " + directori.getName() + ":");

        // Recorre tots els fitxers i directoris dins del directori especificat
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