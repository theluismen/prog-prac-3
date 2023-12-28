package bin.Aplicacio;

import java.io.*;
import bin.Entitats.LlistaEntitats;
import bin.Usuaris.LlistaUsuaris;

public class App {
    private static void carregarEntitats ( final String filename, LlistaEntitats llista ) {
        BufferedReader br; String line;
        String[] lineInfo; String nom, telf, correu; // Informacio de la entitat llegida
        try {
            br = new BufferedReader( new FileReader( filename ) );
            line = br.readLine();   // Llegir linia
            while ( line != null && ! llista.llistaPlena() ) {
                lineInfo = line.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                nom    = lineInfo[0];
                telf   = lineInfo[1];
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

    private static void carregarUsuaris  ( final String filename, LlistaUsuaris llista ) {
        BufferedReader br; String line;
        String[] lineInfo;
        String alies, correu; int cpostal; // Informacio del Usuari llegit
        try {
            br = new BufferedReader( new FileReader( filename ) );
            line = br.readLine();   // Llegir linia
            while ( line != null && ! llista.llistaPlena() ) {
                lineInfo = line.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                alies    = lineInfo[0];
                correu   = lineInfo[1];
                cpostal  = Integer.parseInt(lineInfo[2]);
                /* Afegir una nova entitat amb la informacio llegida */
                llista.addUsuari(alies, correu, cpostal);
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

    public static void main ( String[] args ) {
        LlistaEntitats entitats = new LlistaEntitats(10);
        carregarEntitats(ArxiusApp.ARXIU_ENTITATS, entitats);
        System.out.println(entitats.entitats());

        System.out.println("\n\n");

        LlistaUsuaris usuaris = new LlistaUsuaris(10);
        carregarUsuaris(ArxiusApp.ARXIU_USUARIS, usuaris);
        System.out.println(usuaris.usuaris());

    }
}
