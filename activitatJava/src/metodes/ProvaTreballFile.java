//Autor: Rafel Dalmau
//Data: 29-10-2024

package metodes;

import java.util.Scanner;

public class ProvaTreballFile {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcio;

        do {
            String menuOpcions = obtenirMenu();
            System.out.println(menuOpcions);
            
            opcio = scanner.nextInt();
            
            switch (opcio) {
                case 1:
                    System.out.println("Buscar un fitxer per nom.");
                    TreballFile.buscarFitxer();
                    break;

                case 2:
                    System.out.println("Buscar fitxer per ruta.");
                    TreballFile.buscarRuta();
                    break;

                case 3:
                    System.out.println("Llistar fitxers dins un directori.");
                    TreballFile.llistarFitxers();
                    break;

                case 4:
                    System.out.println("Canviar l'extensió d'un fitxer.");
                    TreballFile.canviaExtensio();
                    break;

                case 5:
                    System.out.println("Mostrar directoris pares.");
                    TreballFile.mostrarDirectoris();
                    break;

                case 0:
                    System.out.println("Adeu Andreu!");
                    break;

                default:
                    System.out.println("Opció no vàlida. tria una opció correcta.");
                    break;
            }

        } while (opcio != 0); // eel bucle continua fins que el usuari esculli la opció 0

        scanner.close();
    }

    public static String obtenirMenu() {
        return "\nTria una opció:\n" +
               "1. Buscar un fitxer o carpeta per nom\n" +
               "2. Buscar fitxer o carpeta a partir de la ruta\n" +
               "3. Llistar fitxers dins un directori\n" +
               "4. Canvia l'extensió d'un fitxer\n" +
               "5. Mostrar directoris pares\n" +
               "0. Sortir";
    }
}
