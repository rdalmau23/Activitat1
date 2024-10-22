package metodes;

import java.util.Scanner;

public class MenuSwitch {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        // Obtener el menú desde la clase MenuString
        String menuOpcions = MenuString.obtenerMenu();
        System.out.println(menuOpcions);
        
        // Leer la opción ingresada por el usuario
        int opcio = scanner.nextInt();

        // Utilizar el switch para llamar a los métodos correspondientes
        switch (opcio) {
            case 1:
                buscarFitxerPerNom();
                break;

            case 2:
                buscarFitxerPerRuta();
                break;

            case 3:
                llistarFitxersEnDirectori();
                break;

            case 4:
                canviarExtensioFitxer();
                break;

            case 0:
                System.out.println("Adeu siau!");
                break;

            default:
                System.out.println("Opció no vàlida. Si us plau, tria una opció correcta.");
                break;
        }

        scanner.close();
    }

    // Métodos que llaman a las funcionalidades
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
