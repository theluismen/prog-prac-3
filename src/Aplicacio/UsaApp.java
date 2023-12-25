package App;

import Entitats.LlistaEntitats;
import java.io.*;

public class UsaApp {
    private static void carregarEntitats ( final String filename, LlistaEntitats llista ) {
        BufferedReader br;
        String[] lineInfo;
        String line;
        String nom, telf, correu; // Informacio de la entitat llegida
        try {
            br = new BufferedReader( new FileReader(  "../data/Entitats.txt") );
            line = br.readLine();   // Llegir linia
            while ( line != null && ! llista.llistaPlena() ) {
                lineInfo = line.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                nom  = lineInfo[0];
                telf  = lineInfo[1];
                correu = lineInfo[2];
                /* Afegir una nova entitat amb la informacio llegida */
                llista.addEntitat(nom, telf, correu);
                /* Tornar a Llegir linia */
                line = br.readLine();
            }
            br.close();
        } catch ( FileNotFoundException e ) {
            System.out.println( e.getMessage() );
        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
    }

    public static void main ( String[] args) {
        LlistaEntitats entitats = new LlistaEntitats(10);
        carregarEntitats(ArxiusApp.ARXIU_ENTITATS, entitats);
        System.out.println(entitats.entitats());
    }
}
