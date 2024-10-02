package metodes;

import java.io.File;
import java.util.Scanner;

public class NomFitxer {
    public static void buscarFitxer() {
        Scanner scanner = new Scanner(System.in);  

        System.out.print("Introdueix el nom del fitxer o carpeta: ");

        String nomFitxer = scanner.nextLine();

        // busca desde el directori c:
        File directoriArrel = new File("C:\\"); 

        File resultat = cercarFitxer(directoriArrel, nomFitxer);

        if (resultat != null) {
            mostrarInfoFitxer(resultat);  
        } else {
            System.out.println("No existeix.");
        }

        scanner.close();
    }

    private static File cercarFitxer(File directori, String nomFitxer) {
        File[] fitxers = directori.listFiles();

        if (fitxers != null) {
            for (File fitxer : fitxers) {
                if (fitxer.getName().equalsIgnoreCase(nomFitxer)) {
                    return fitxer;
                }

                if (fitxer.isDirectory()) {
                    try {
                        File resultat = cercarFitxer(fitxer, nomFitxer);
                        if (resultat != null) {
                            return resultat;
                        }
                    } catch (SecurityException e) {
                        System.err.println("Error: " + fitxer.getAbsolutePath());
                    }
                }
            }
        }
        //  null si no troba res
        return null;
    }

    
    private static void mostrarInfoFitxer(File fitxer) {
        System.out.println("Si existeix.");

        // aqUí mira si es fitxer o carpeta/directori
        if (fitxer.isFile()) {
            System.out.println("És un fitxer.");
        } else if (fitxer.isDirectory()) {
            System.out.println("És una carpeta.");
        }

        // Mostrar la ruta absoluta del fitxer o carpeta
        System.out.println("Ruta absoluta: " + fitxer.getAbsolutePath());
    }
}
