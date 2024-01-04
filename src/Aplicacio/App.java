package bin.Aplicacio;

import java.io.*;
import bin.Excepcions.TallerNoTrobatExcepcio;
import bin.Entitats.LlistaEntitats;
import bin.Usuaris.LlistaUsuaris;
import bin.Reserves.LlistaReserves;
import bin.Activitats.*;

public class App {
    /**
     * Funcio que retorna la quantitat de linies del fitxer especificat
     *
     * @param   filename    Nom del fixer on hi han les dades
     */
    private static int liniesFitxer ( final String filename ) {
        BufferedReader br; String linia; int linies = 0;
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null ) {
                linies++;
                linia = br.readLine();
            }
            br.close();
        } catch ( FileNotFoundException e ) {
            System.out.println( e.getMessage() );
        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
        return linies;
    }

    /**
     * Funcio que llegeix la informacio del fitxer de Entitats
     *
     * @param   filename    Nom del fixer on hi han les dades
     * @param   llista      Llista que guardara les entitats
     */
    private static void carregarEntitats ( final String filename, LlistaEntitats entitats ) {
        BufferedReader br; String linia;
        String[] dades; String nom, telf, correu; // Informacio de la entitat llegida
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null && ! entitats.llistaPlena() ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                nom    = dades[0];
                telf   = dades[1];
                correu = dades[2];
                /* Afegir una nova entitat amb la informacio llegida */
                entitats.addEntitat(nom, telf, correu);
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

    /**
     * Funcio que llegeix la informacio del fitxer de Usuaris
     *
     * @param   filename    Nom del fixer on hi han les dades
     * @param   llista      Llista que guardara els Usuaris
     */
    private static void carregarUsuaris  ( final String filename, LlistaUsuaris usuaris ) {
        BufferedReader br; String linia;
        String[] dades; String alies, correu; int cpostal; // Informacio del Usuari llegit
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null && ! usuaris.llistaPlena() ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                alies    = dades[0];
                correu   = dades[1];
                cpostal  = Integer.parseInt(dades[2]);
                /* Afegir una nou Usuari amb la informacio llegida */
                usuaris.addUsuari(alies, correu, cpostal);
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

    /**
     * Funcio que llegeix la informacio del fitxer de Activitats
     *
     * @param   filename    Nom del fixer on hi han les dades
     * @param   llista      Llista que guardara les activitats
     */
    private static void carregarActivitats ( final String filename, LlistaActivitats activitats ) {
        BufferedReader br; String linia;
        String[] dades;
        /* Atributos de la clase Actividad*/
        String  codi, nom, lloc, nomEntitat;
        int     cpostal, dia;

        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                codi       = dades[0];
                nom        = dades[1];
                lloc       = dades[2];
                cpostal    = Integer.parseInt(dades[3]);
                dia        = Integer.parseInt(dades[4]);
                nomEntitat = dades[5];
                /* Segun la cantidad de datos leidos es un taller, visita o xerrada */
                switch ( dades.length ) {
                    case 7:
                        /* Variables de Xerrada Adicionals */
                        String nomAutor = dades[6];
                        /* Afegir una nova activitat tipus Xerrada */
                        activitats.addXerrada( new Xerrada(codi, nom, lloc, cpostal, dia, nomEntitat, nomAutor) );
                        break;
                    case 8:
                        /* Variables de Visita Adicionals */
                        boolean audioguia = Boolean.parseBoolean(dades[6]);
                        boolean adaptada  = Boolean.parseBoolean(dades[7]);
                        /* Afegir una nova activitat tipus Visita */
                        activitats.addVisita( new Visita(codi, nom, lloc, cpostal, dia, nomEntitat, audioguia, adaptada ) );
                        break;
                    case 9:
                        /* Variables de Taller Adicionals */
                        int hora      = Integer.parseInt(dades[6]);
                        int durada    = Integer.parseInt(dades[7]);
                        int capacitat = Integer.parseInt(dades[8]);
                        /* Afegir una nova activitat tipus Taller */
                        activitats.addTaller( new Taller(codi, nom, lloc, cpostal, dia, nomEntitat, hora, durada, capacitat ) );
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

    /**
    * Funcio que llegeix la informacio del fitxer de Reserves
    *
    * @param   filename    Nom del fixer on hi han les dades
    * @param   llista      Llista que guardara les reserves
    */
    private static void carregarReserves  ( final String filename, LlistaActivitats activitats ) {
        BufferedReader br; String linia;
        String[] dades; String aliesUsuari, coditaller;  // Informacio del Usuari llegit
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                //codi    = Integer.parseInt(dades[0]);
                aliesUsuari = dades[0];
                coditaller  = dades[1];
                /* Afegir una nova Reserva amb la informacio llegida */
                try {
                    activitats.getTallerPerCodi(coditaller).ferReserva( aliesUsuari );
                } catch ( TallerNoTrobatExcepcio ex ) {
                    System.out.println(ex.toString());
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

    /**
    * Funcio que llegeix TOTA la informacio dels fitxer de dades
    *
    * @param   entitats    Objecte tipus LlistaEntitats
    * @param   usuaris     Objecte tipus LlistaUsuaris
    * @param   activitats  Objecte tipus LlistaActivitats
    */
    private static void carregarInfoFitxers ( LlistaEntitats entitats, LlistaUsuaris usuaris, LlistaActivitats activitats ) {
        carregarEntitats(ArxiusApp.ARXIU_ENTITATS, entitats);
        carregarUsuaris(ArxiusApp.ARXIU_USUARIS, usuaris);
        carregarActivitats(ArxiusApp.ARXIU_ACTIVITATS, activitats);
        carregarReserves(ArxiusApp.ARXIU_RESERVES, activitats);
    }
    public static void main ( String[] args ) {
        LlistaEntitats   entitats   = new LlistaEntitats(liniesFitxer(ArxiusApp.ARXIU_ENTITATS));
        LlistaUsuaris    usuaris    = new LlistaUsuaris(liniesFitxer(ArxiusApp.ARXIU_USUARIS));
        LlistaActivitats activitats = new LlistaActivitats();

        carregarInfoFitxers(entitats, usuaris, activitats);

        System.out.println(" <= ENTITATS => \n" + entitats.entitats());
        System.out.println();
        System.out.println(" <= USUARIS => \n" + usuaris.usuaris());
        System.out.println();

        System.out.println(" <= ACTIVITATS " + activitats.getNElem() + " => \n" + activitats.activitats());
        System.out.println();
        System.out.println();
        System.out.println(" <= RESERVES => ");
        System.out.println(activitats.reserves());
        System.out.println(activitats.getTaller(0).reserves());


    }
}
