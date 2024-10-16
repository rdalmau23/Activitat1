package metodes;

import java.util.Scanner;

public class Menu {
    public static void mmostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Tria una opció; ");
        System.out.println("1. Buscar un fitxer o carpeta per nom");
        System.out.println("2. Buscar fitxer o carpeta a partir de la ruta");
        System.out.println("3. Llistar fitxers dins un directori");
        System.out.println("0. Sortir");
        
            int opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    NomFitxer.buscarFitxer();
                    break;

                case 2:
                    RutaFitxer.buscarRuta();
                    break;

                case 3:
                    LlistaFitxers.llistarFixers();
                    break;
                
                case 4:
                    Extensio.canviaExtensio();
                break;

                case 0:
                    System.out.println("Adeu siau!");
                    break;

                default:
                    System.out.println("Opció no vàlida. Si us plau, tria una opció correcta.");
                    break;
            }
    }      
    
}
