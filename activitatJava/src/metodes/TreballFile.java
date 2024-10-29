package metodes;

import java.io.File;
import java.util.Scanner;

public class TreballFile {

    private static final Scanner scanner = new Scanner(System.in); // Instancia de Scanner a nivel de clase

    public static void buscarRuta() { 
        System.out.print("Nom fitxer o carpeta: ");  
        String nomFitxer = scanner.nextLine();
        
        File fitxer = new File(nomFitxer); // Crea un objecte File amb el nom del fitxer que s'ha introduit
        
        if (fitxer.exists()) {
            mostrarInfofitxer(fitxer);
        } else {
            System.out.println("El fitxer o carpeta no existeix."); // Si no existeix mostri missatge
        }
    }
    
    private static void mostrarInfofitxer(File fitxer) {  
        System.out.println("El fitxer o carpeta existeix."); 
        
        if (fitxer.isFile()) {
            System.out.println("És un fitxer."); // Si es un fitxer, mostri aquest missatge

        } else if (fitxer.isDirectory()) {
            System.out.println("És una carpeta."); // si ws un directorie

        }
        
        System.out.println("Ruta absoluta: " + fitxer.getAbsolutePath()); // Mostra la ruta absoluta del fitxer o carpeta
        System.out.println("Nom: " + fitxer.getName()); // Mostra el nom del fitxer o carpeta
    }

    public static void buscarFitxer() {
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

    public static void canviaExtensio() {
        // Demanar la ruta completa o relativa del directori
        System.out.println("Escriu la ruta del directori:");
        String rutaDirectori = scanner.nextLine();
        
        // Comprovar si existeix el directori
        File directori = new File(rutaDirectori);
        if (!directori.exists() || !directori.isDirectory()) {
            System.out.println("El directori no existeix o no és un directori.");
            return;
        }
        
        // Demanar l'extensió actual
        System.out.println("Escriu l'extensió actual dels fitxers (sense el punt). Exemple: png");
        String extensioActual = scanner.nextLine();
        
        // Demanar la nova extensió
        System.out.println("Escriu la nova extensió (sense el punt). Exemple: jpg");
        String novaExtensio = scanner.nextLine();
        
        // Llistar tots els fitxers del directori
        File[] fitxers = directori.listFiles();
        if (fitxers != null && fitxers.length > 0) {
            for (File fitxer : fitxers) {
                // Comprovar si és un fitxer i si té l'extensió actual
                if (fitxer.isFile() && fitxer.getName().endsWith("." + extensioActual)) {
                    // Obtenir el nom base del fitxer sense l'extensió actual
                    String nomBase = fitxer.getName().substring(0, fitxer.getName().lastIndexOf('.'));
                    
                    // Crear el nou nom amb la nova extensió
                    String nouNom = nomBase + "." + novaExtensio;
                    
                    // Crear un objecte File amb el nou nom
                    File fitxerRenombrat = new File(directori, nouNom);
                    
                    // Canviar el nom del fitxer
                    if (fitxer.renameTo(fitxerRenombrat)) {
                        System.out.println("Fitxer renombrat: " + fitxer.getName() + " a " + nouNom);
                    } else {
                        System.out.println("Error al renombrar el fitxer: " + fitxer.getName());
                    }
                }
            }
        } else {
            System.out.println("El directori està buit.");
        }
    }
    

    public static void llistarFitxers() {
        System.out.print("\nIntrodueix el nom del directori: ");
        String nomDirectori = scanner.nextLine();
    
        File directori = new File(nomDirectori);
    
        if (directori.exists() && directori.isDirectory()) {
            llistarFitxers(directori);
            calcularTamanyTotal(directori); // Calcula i mostra tamany total del dirtectori
        } else {
            System.out.println("El directori no és vàlid.");
        }
    }
    
    private static void llistarFitxers(File directori) {
        File[] fitxers = directori.listFiles();
    
        if (fitxers != null && fitxers.length > 0) {
            System.out.println("Fitxers dins del directori " + directori.getName() + ":");
            for (File fitxer : fitxers) {
                if (fitxer.isFile()) {
                    double tamanyMB = fitxer.length() / (1024.0 * 1024.0); // Convertir a megas
                    System.out.printf("Fitxer: %s - Tamany: %.2f MB%n", fitxer.getName(), tamanyMB);
                } else if (fitxer.isDirectory()) {
                    System.out.println("Carpeta: " + fitxer.getName());
                }
            }
        } else {
            System.out.println("El directori està buit.");
        }
    }
    
    private static void calcularTamanyTotal(File directori) {
        File[] fitxers = directori.listFiles();
        long tamanyTotal = 0;
    
        if (fitxers != null) {
            for (File fitxer : fitxers) {
                if (fitxer.isFile()) {
                    tamanyTotal += fitxer.length();
                } else if (fitxer.isDirectory()) {
                    tamanyTotal += calcularTamanyTotalRecursiu(fitxer); // Calcular els mb
                }
            }
        }
    
        double tamanyTotalMB = tamanyTotal / (1024.0 * 1024.0); // Convertir a megabytes
        System.out.printf("Tamany total del directori %s: %.2f MB%n", directori.getName(), tamanyTotalMB);
    }
    
    private static long calcularTamanyTotalRecursiu(File directori) {
        long tamany = 0;
        File[] fitxers = directori.listFiles();
    
        if (fitxers != null) {
            for (File fitxer : fitxers) {
                if (fitxer.isFile()) {
                    tamany += fitxer.length();
                } else if (fitxer.isDirectory()) {
                    tamany += calcularTamanyTotalRecursiu(fitxer); // Sumar el tamany
                }
            }
        }
        return tamany;
    }
    

    public static void mostrarDirectoris() {
        System.out.print("\nIntrodueix la ruta d'un fitxer: ");
        String ruta = scanner.nextLine();

        File fitxer = new File(ruta);

        if (fitxer.exists()) {
            mostrarPares(fitxer);
        } else {
            System.out.println("El directori no existeix.");
        }
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
