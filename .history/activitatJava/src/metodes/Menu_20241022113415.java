package metodes;

import java.util.Scanner;

public class Menu {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        // Obtener el string del menú desde MenuString
        String menuOpcions = MenuString.obtenerMenu();
        System.out.println(menuOpcions);
        
        // Leer la opción elegida por el usuario
        int opcio = scanner.nextInt();
        
        // Controlar las opciones del menú
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
                
            case 5:
                mostrarDirectorisPadres(); // Nuevo caso para mostrar directorios padres
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

    // Método para llamar al método de la clase DirectoriPare
    private static void mostrarDirectorisPadres() {
        System.out.println("Opció: Mostrar directoris pares.");
        DirectoriPare.mostrarDirectoris(); // Llamada al método que muestra los padres del directorio
    }

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
