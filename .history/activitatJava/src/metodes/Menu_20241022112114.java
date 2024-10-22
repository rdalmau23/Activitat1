package metodes;

import java.util.Scanner;

public class Menu {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        // Definir el menú como un string
        String menuOpcions = "\nTria una opció:\n" +
                "1. Buscar un fitxer o carpeta per nom\n" +
                "2. Buscar fitxer o carpeta a partir de la ruta\n" +
                "3. Llistar fitxers dins un directori\n" +
                "4. Canvia l'extensió d'un fitxer\n" +
                "0. Sortir";

        System.out.println(menuOpcions);
        
        int opcio = scanner.nextInt();

        // Utilizar el switch solo para llamar a los métodos
        switch (opcio) {
            case 1:
                buscarFitxerPerNom(); // Método para buscar fitxer per nom
                break;

            case 2:
                buscarFitxerPerRuta(); // Método para buscar fitxer per ruta
                break;

            case 3:
                llistarFitxersEnDirectori(); // Método para llistar fitxers
                break;

            case 4:
                canviarExtensioFitxer(); // Método para cambiar la extensión del fitxer
                break;

            case 0:
                System.out.println("Adeu siau!");
                break;

            default:
                System.out.println("Opció no vàlida. Si us plau, tria una opció correcta.");
                break;
        }
    }

    // Métodos con el enunciado de la opción, que llaman al método funcional
    private static void buscarFitxerPerNom() {
        System.out.println("Opció: Buscar un fitxer per nom.");
        NomFitxer.buscarFitxer();
    }

    private static void buscarFitxerPerRuta() {
        System.out.println("Opció: Buscar fitxer per ruta.");
        RutaFitxer.buscarRuta();
    }

    private static void llistarFitxersEnDirectori() {
        System.out.println("Opció: Llistar fitxers dins un directori.");
        LlistaFitxers.llistarFixers();
    }

    private static void canviarExtensioFitxer() {
        System.out.println("Opció: Canviar l'extensió d'un fitxer.");
        Extensio.canviaExtensio();
    }
}