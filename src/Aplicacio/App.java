package bin.Aplicacio;

import java.io.*;
import bin.Entitats.LlistaEntitats;
import bin.Usuaris.LlistaUsuaris;
import bin.Reserves.LlistaReserves;
import bin.Activitats.*;

public class App {
    private static void carregarEntitats ( final String filename, LlistaEntitats llista ) {
        BufferedReader br; String linia;
        String[] dades; String nom, telf, correu; // Informacio de la entitat llegida
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null && ! llista.llistaPlena() ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                nom    = dades[0];
                telf   = dades[1];
                correu = dades[2];
                /* Afegir una nova entitat amb la informacio llegida */
                llista.addEntitat(nom, telf, correu);
                /* Tornar a Llegir linia */
                linia = br.readLine();
            }
            br.close();
        } catch ( FileNotFoundException e ) {
            System.out.println( e.getMessage() );
        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
    }

    private static void carregarUsuaris  ( final String filename, LlistaUsuaris llista ) {
        BufferedReader br; String linia;
        String[] dades;
        String alies, correu; int cpostal; // Informacio del Usuari llegit
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null && ! llista.llistaPlena() ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                alies    = dades[0];
                correu   = dades[1];
                cpostal  = Integer.parseInt(dades[2]);
                /* Afegir una nou Usuari amb la informacio llegida */
                llista.addUsuari(alies, correu, cpostal);
                /* Tornar a Llegir linia */
                linia = br.readLine();
            }
            br.close();
        } catch ( FileNotFoundException e ) {
            System.out.println( e.getMessage() );
        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
    }

    private static void carregarReserves  ( final String filename, LlistaReserves llista ) {
        BufferedReader br; String linia;
        String[] dades;
        /*int codi;*/String aliesUsuari, coditaller;  // Informacio del Usuari llegit
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null && ! llista.llistaPlena() ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                //codi    = Integer.parseInt(dades[0]);
                aliesUsuari   = dades[0];
                coditaller  = dades[1];
                /* Afegir una nova Reserva amb la informacio llegida */
                llista.addReserva(aliesUsuari, coditaller);
                /* Tornar a Llegir linia */
                linia = br.readLine();
            }
            br.close();
        } catch ( FileNotFoundException e ) {
            System.out.println( e.getMessage() );
        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
    }

    private static void carregarActivitats ( final String filename, LlistaActivitats llista ) {
        BufferedReader br; String linia;
        String[] dades;
        /* Atributos de la clase Actividad*/
        String  nom, lloc, nomEntitat;
        int     cpostal, dia;

        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null && ! llista.llistaPlena() ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                nom        = dades[0];
                lloc       = dades[1];
                cpostal    = Integer.parseInt(dades[2]);
                dia        = Integer.parseInt(dades[3]);
                nomEntitat = dades[4];
                /* Segun la cantidad de datos leidos es un taller, visita o xerrada */
                switch ( dades.length ) {
                    case 6: // Xerrada
                        /* Variables de Xerrada Adicionals */
                        String nomAutor = dades[5];
                        /* Afegir una nova activitat tipus Xerrada */
                        llista.addActivitat( new Xerrada(nom, lloc, cpostal, dia, nomEntitat, nomAutor) );
                        break;
                    case 7:
                        /* Variables de Visita Adicionals */
                        boolean audioguia = Boolean.parseBoolean(dades[5]);
                        boolean adaptada  = Boolean.parseBoolean(dades[6]);
                        /* Afegir una nova activitat tipus Visita */
                        llista.addActivitat( new Visita(nom, lloc, cpostal, dia, nomEntitat, audioguia, adaptada ) );
                        break;
                    case 8:
                        /* Variables de Taller Adicionals */
                        int hora      = Integer.parseInt(dades[5]);
                        int durada    = Integer.parseInt(dades[6]);
                        int capacitat = Integer.parseInt(dades[7]);
                        /* Afegir una nova activitat tipus Taller */
                        llista.addActivitat( new Taller(nom, lloc, cpostal, dia, nomEntitat, hora, durada, capacitat ) );
                        break;
                }
                /* Tornar a Llegir linia */
                linia = br.readLine();
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
        System.out.println(" <= ENTITATS => \n" + entitats.entitats());

        System.out.println();

        LlistaUsuaris usuaris = new LlistaUsuaris(10);
        carregarUsuaris(ArxiusApp.ARXIU_USUARIS, usuaris);
        System.out.println(" <= USUARIS => \n" + usuaris.usuaris());

        System.out.println();

        LlistaReserves reserves = new LlistaReserves(10);
        carregarReserves(ArxiusApp.ARXIU_RESERVES, reserves);
        System.out.println(" <= RESERVES => \n" + reserves.reserves());
    }
}
