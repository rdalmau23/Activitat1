package metodes;

import java.io.File;
import java.util.Scanner;

public class RutaFitxer {
     public static void buscarRuta() { 

        Scanner scanner= new Scanner(System.in);// demanar el  nom del fitxer 
        
        System.out.print("Nom arxiu o carpeta: ");  
        String nomFitxer = scanner.nextLine();
        
        File arxiu = new File(nomFitxer);     //Crea un objecte File amb el nom del fitxer que s'ha introduit
        
        if (arxiu.exists()) {   

            mostrarInfoArxiu(arxiu);
        } else {
            System.out.println("El arxiu o carpeta no existeix.");    //si no existeix mostri aquest missatge

        }
        
        scanner.close();
    }
    
    private static void mostrarInfoArxiu(File arxiu) {  
        System.out.println("El arcxiu o carpeta existeix."); 
        
        if (arxiu.isFile()) {
            System.out.println("Es un arxiu."); // si es un arxiu mostri aquest missatge

        } else if (arxiu.isDirectory()) {
            System.out.println("Es una carpeta."); // si es un directori  mostri aquest missatge

        }
        
        System.out.println("Ruta absoluta: " + arxiu.getAbsolutePath());  // mostri la ruta absoluta del fitxer o carpeta

        System.out.println("Nom: " + arxiu.getName());   //  mostri el nom del fitxer o carpeta

    }
}
